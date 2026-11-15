#include "platform.h"
#include "engine.h"

#include <SDL.h>
#include <jni.h>
#include <atomic>
#include <chrono>

namespace gow {

void audioLog(const std::string& line) {
    SDL_Log("[Audio] %s", line.c_str());
    if (Platform::logCallback) {
        Platform::logCallback("AUDIO", line);
    }
}

// Identifiant unique par instance de Player (correspondant à un son préchargé dans SoundPlayer)
struct MidiSequence {
    int id = 0;
    bool prefetched = false;
};

namespace {

inline double audioClockMs() {
    using namespace std::chrono;
    return duration<double, std::milli>(steady_clock::now().time_since_epoch()).count();
}

std::atomic<int> g_nextPlayerId{1};
jclass g_cls = nullptr;
jmethodID g_midPrefetch = nullptr;
jmethodID g_midStart = nullptr;
jmethodID g_midStop = nullptr;
jmethodID g_midIsPlaying = nullptr;

bool ensureJni(JNIEnv*& env) {
    env = (JNIEnv*)SDL_AndroidGetJNIEnv();
    if (!env) return false;
    if (g_cls) return true;

    jobject activity = (jobject)SDL_AndroidGetActivity();
    if (!activity) return false;

    jclass actCls = env->GetObjectClass(activity);
    jmethodID getClassLoader = env->GetMethodID(actCls, "getClassLoader", "()Ljava/lang/ClassLoader;");
    jobject loader = env->CallObjectMethod(activity, getClassLoader);
    jclass loaderCls = env->FindClass("java/lang/ClassLoader");
    jmethodID loadClass = env->GetMethodID(loaderCls, "loadClass", "(Ljava/lang/String;)Ljava/lang/Class;");

    jstring className = env->NewStringUTF("org.libsdl.app.GowMidiPlayer");
    jclass localCls = (jclass)env->CallObjectMethod(loader, loadClass, className);
    env->DeleteLocalRef(className);
    env->DeleteLocalRef(loaderCls);
    env->DeleteLocalRef(loader);
    env->DeleteLocalRef(actCls);
    env->DeleteLocalRef(activity);

    if (env->ExceptionCheck() || !localCls) {
        env->ExceptionClear();
        return false;
    }

    g_cls = (jclass)env->NewGlobalRef(localCls);
    env->DeleteLocalRef(localCls);

    g_midPrefetch  = env->GetStaticMethodID(g_cls, "prefetch",  "(I[BZ)V");
    g_midStart     = env->GetStaticMethodID(g_cls, "start",     "(II)V");
    g_midStop      = env->GetStaticMethodID(g_cls, "stop",      "(I)V");
    g_midIsPlaying = env->GetStaticMethodID(g_cls, "isPlaying", "(I)Z");
    return g_midPrefetch && g_midStart && g_midStop && g_midIsPlaying;
}

jbyteArray toJavaBytes(JNIEnv* env, const Arr<int8_t>& d) {
    if (d == nullptr || d.length() <= 0) return nullptr;
    jbyteArray arr = env->NewByteArray(d.length());
    if (!arr) return nullptr;
    env->SetByteArrayRegion(arr, 0, d.length(), (const jbyte*)d.data());
    return arr;
}

}  // namespace

bool Player::isMidi() const {
    return mime.equals(String(u"audio/midi"));
}

void Player::prefetch() {
    if (data == nullptr) return;
    // Déjà préchargé au démarrage (bootStep 4) : retour immédiat en O(1) sans JNI ni écriture disque
    if (seq_ && seq_->prefetched) return;

    double t0 = audioClockMs();
    ++g_frameProfile.audioPrefetches;
    if (!seq_) {
        seq_ = std::make_shared<MidiSequence>();
        seq_->id = g_nextPlayerId.fetch_add(1);
    }
    JNIEnv* env = nullptr;
    if (!ensureJni(env)) return;

    jbyteArray jbytes = toJavaBytes(env, data);
    if (!jbytes) return;
    env->CallStaticVoidMethod(g_cls, g_midPrefetch, seq_->id, jbytes, (jboolean)isMidi());
    if (env->ExceptionCheck()) env->ExceptionClear();
    env->DeleteLocalRef(jbytes);
    seq_->prefetched = true;
    g_frameProfile.audioMs += (audioClockMs() - t0);
}

void Player::start() {
    if (data == nullptr) return;
    if (!seq_ || !seq_->prefetched) prefetch();
    double t0 = audioClockMs();
    ++g_frameProfile.audioPlays;
    state_ = 400;

    JNIEnv* env = nullptr;
    if (!ensureJni(env) || !seq_) return;

    // Aucune allocation de tableau JNI : envoie uniquement l'identifiant du son déjà préchauffé
    env->CallStaticVoidMethod(g_cls, g_midStart, seq_->id, (jint)loops_);
    if (env->ExceptionCheck()) env->ExceptionClear();
    g_frameProfile.audioMs += (audioClockMs() - t0);
}

void Player::stop() {
    double t0 = audioClockMs();
    ++g_frameProfile.audioStops;
    state_ = 300;
    if (!seq_) return;
    JNIEnv* env = nullptr;
    if (!ensureJni(env)) return;
    env->CallStaticVoidMethod(g_cls, g_midStop, seq_->id);
    if (env->ExceptionCheck()) env->ExceptionClear();
    g_frameProfile.audioMs += (audioClockMs() - t0);
}

void Player::close() {
    stop();
    state_ = 0;
}

void Player::pumpLoops() {}

int Player::getState() {
    if (state_ == 400 && seq_) {
        double t0 = audioClockMs();
        ++g_frameProfile.audioQueries;
        JNIEnv* env = nullptr;
        if (ensureJni(env)) {
            jboolean playing = env->CallStaticBooleanMethod(g_cls, g_midIsPlaying, seq_->id);
            if (env->ExceptionCheck()) {
                env->ExceptionClear();
                playing = JNI_FALSE;
            }
            if (!playing) {
                state_ = 300;
            }
        }
        g_frameProfile.audioMs += (audioClockMs() - t0);
    }
    return state_;
}

}  // namespace gow
