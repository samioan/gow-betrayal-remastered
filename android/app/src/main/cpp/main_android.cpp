#include <SDL.h>
#include <jni.h>
#include <fcntl.h>
#include <signal.h>
#include <unistd.h>

#include <algorithm>
#include <chrono>
#include <cstdio>
#include <cstring>
#include <ctime>
#include <filesystem>
#include <string>
#include <vector>

#include "gen/classes.h"
#include "gfx.h"
#include "platform.h"

using namespace gow;

static Game* g_game = nullptr;
static Surface g_screen;
static int g_windowW = 800;
static int g_windowH = 480;

// ============================================================================
// CONFIGURATION DES TOUCHES TACTILES (Style Concept 1 : Bronze de Sparte)
// Modifie directement ces constantes pour ajuster l'opacité et l'épaisseur :
// ============================================================================
namespace TouchStyle {
    // Opacités (sur 255) : 217 = 85%, 166 = 65%, 255 = 100%
    constexpr float kTouchAlphaRest    = 217.0f; // Opacité au repos (~85%)
    constexpr float kTouchAlphaMinIdle = 166.0f; // Opacité minimale après inactivité (~65%)
    constexpr float kTouchAlphaPressed = 255.0f; // Opacité pendant l'appui (100%)

    // Épaisseur du trait principal et du contour sombre (en pixels écran)
    constexpr int kTouchStrokePx  = 3; // Épaisseur du trait de bronze/or (ex: 3 px)
    constexpr int kTouchOutlinePx = 2; // Épaisseur du contour sombre de chaque côté du trait (ex: 2 px)

    // Couleur du contour sombre (#0D0E0C - obsidienne) qui détache le trait sur les décors clairs
    constexpr uint8_t kShadowR = 13,  kShadowG = 14,  kShadowB = 12;
    // Couleur du cadre bronze au repos (#C47A52)
    constexpr uint8_t kFrameR  = 196, kFrameG  = 122, kFrameB  = 82;
    // Couleur du symbole gravé au repos (#E2AE82)
    constexpr uint8_t kSymR    = 226, kSymG    = 174, kSymB    = 130;
    // Couleur d'appui Or spartiate (#F2C166)
    constexpr uint8_t kGoldR   = 242, kGoldG   = 193, kGoldB   = 102;
    // Couleur d'appui Rouge sang pour le bouton d'attaque (#D82E08)
    constexpr uint8_t kBloodR  = 216, kBloodG  = 46,  kBloodB  = 8;

    // Compacité visuelle par rapport à la zone de toucher (0.64 = dessin 36% plus compact que la hitbox)
    constexpr float kVisualScale  = 0.64f;

    // Temporisations de fondu (en millisecondes)
    constexpr double kIdleDelayMs    = 3000.0; // Délai avant atténuation d'inactivité (3 s)
    constexpr double kIdleFadeMs     = 1000.0; // Durée du fondu vers l'opacité minimale (1 s)
    constexpr double kReleaseDecayMs = 180.0;  // Durée du retour doux après relâchement (180 ms)
}  // namespace TouchStyle

// ---- Réglages d'affichage sauvegardés (dans Platform::saveDir + "/android_display.cfg") ----
enum class AspectMode { Auto, Original, R16_9, R21_9, Count };
static AspectMode g_aspect = AspectMode::Auto;
static int g_fpsMode = 60;                  // 60/90/120 Hz par défaut
static bool g_showFpsCounter = false;       // Désactivé par défaut
static bool g_enableFrameProfiler = true;   // Active le profilage std::chrono dans logcat (frames > 12 ms)
static constexpr double kSlowFrameThresholdMs = 12.0;

static void loadDisplaySettings() {
    std::string path = Platform::saveDir + "/android_display.cfg";
    FILE* f = std::fopen(path.c_str(), "r");
    if (!f) return;
    int asp = 0, fps = g_fpsMode, showFps = 0;
    if (std::fscanf(f, "%d %d %d", &asp, &fps, &showFps) >= 3) {
        if (asp >= 0 && asp < (int)AspectMode::Count) g_aspect = (AspectMode)asp;
        if (fps == 0 || fps == 60 || fps == 90 || fps == 120) g_fpsMode = fps;
        g_showFpsCounter = (showFps != 0);
    }
    std::fclose(f);
}

static void saveDisplaySettings() {
    std::error_code ec;
    std::filesystem::create_directories(Platform::saveDir, ec);
    std::string path = Platform::saveDir + "/android_display.cfg";
    std::string tmpPath = path + ".tmp";
    FILE* f = std::fopen(tmpPath.c_str(), "w");
    if (!f) {
        f = std::fopen(path.c_str(), "w");
        if (!f) return;
        std::fprintf(f, "%d %d %d\n", (int)g_aspect, g_fpsMode, g_showFpsCounter ? 1 : 0);
        std::fflush(f);
        std::fclose(f);
        return;
    }
    std::fprintf(f, "%d %d %d\n", (int)g_aspect, g_fpsMode, g_showFpsCounter ? 1 : 0);
    bool ok = (std::fflush(f) == 0);
    if (std::fclose(f) != 0) ok = false;
    if (ok) {
        std::error_code renEc;
        std::filesystem::rename(tmpPath, path, renEc);
        if (renEc) {
            std::filesystem::copy_file(tmpPath, path, std::filesystem::copy_options::overwrite_existing, renEc);
            std::filesystem::remove(tmpPath, ec);
        }
    } else {
        std::filesystem::remove(tmpPath, ec);
    }
}

// ---- Implémentation de gow::Port (appelé par Game.cpp dans les menus Options et Pause) ----
namespace gow {

String Port::label(int row) {
    if (row == 0) {
        switch (g_aspect) {
            case AspectMode::Original: return String(u"Resolution: Original");
            case AspectMode::R16_9:    return String(u"Resolution: 16:9");
            case AspectMode::R21_9:    return String(u"Resolution: 21:9");
            default:                   return String(u"Resolution: Auto");
        }
    }
    if (row == 1) {
        return String(g_showFpsCounter ? u"FPS Counter: ON" : u"FPS Counter: OFF");
    }
    if (g_fpsMode == 0) return String(u"FPS: Original");
    return String(u"FPS: ") + String::valueOf(g_fpsMode);
}

void Port::change(int row, int dir) {
    if (row == 0) {
        int n = (int)AspectMode::Count;
        g_aspect = (AspectMode)(((int)g_aspect + dir + n) % n);
    } else if (row == 1) {
        g_showFpsCounter = !g_showFpsCounter;
    } else if (row == 2) {
        static const int kFps[] = {0, 60, 90, 120};
        int idx = 0;
        for (int i = 0; i < 4; i++) if (kFps[i] == g_fpsMode) idx = i;
        g_fpsMode = kFps[(idx + dir + 4) % 4];
    }
    saveDisplaySettings();
}

int Port::displayFps() { return g_fpsMode; }

int Port::viewWidth() {
    const int H = kScreenH, base = kScreenW, maxW = H * 24 / 9;
    int w = base;
    switch (g_aspect) {
        case AspectMode::Original: w = base; break;
        case AspectMode::R16_9:    w = (H * 16 + 4) / 9; break;
        case AspectMode::R21_9:    w = (H * 21 + 4) / 9; break;
        case AspectMode::Auto:
        default:
            if (g_windowW > 0 && g_windowH > 0) {
                w = (int)((long long)H * g_windowW / g_windowH);
            }
            break;
    }
    return w < base ? base : w > maxW ? maxW : w;
}

Arr<int> Port::extendMenu(const Arr<int>& t) {
    const int at = 22, n = 3;
    if (t.length() <= at) return t;
    Arr<int> o(t.length() + n);
    auto shifted = [&](int e) {
        int target = (e >> 8) & 0xFF;
        if (target >= at) e = (e & ~0xFF00) | (((target + n) & 0xFF) << 8);
        return e;
    };
    for (int i = 0; i < at; i++) o[i] = shifted(t[i]);
    o[at] = (13 << 26) | 0x3000000;
    o[at + 1] = (14 << 26) | 0x3000000;
    o[at + 2] = (15 << 26) | 0x3000000;
    for (int i = at; i < t.length(); i++) o[i + n] = shifted(t[i]);
    return o;
}

}  // namespace gow

// ---- Police bitmap 3x5 minimaliste intégrée pour le compteur FPS/TPS ----
// Chaque glyphe est codé sur 15 bits (5 lignes de 3 bits, de haut en bas).
static uint16_t glyph3x5(char c) {
    switch (c) {
        case '0': return 0b111'101'101'101'111;
        case '1': return 0b010'110'010'010'111;
        case '2': return 0b111'001'111'100'111;
        case '3': return 0b111'001'111'001'111;
        case '4': return 0b101'101'111'001'001;
        case '5': return 0b111'100'111'001'111;
        case '6': return 0b111'100'111'101'111;
        case '7': return 0b111'001'001'010'010;
        case '8': return 0b111'101'111'101'111;
        case '9': return 0b111'101'111'001'111;
        case 'F': return 0b111'100'111'100'100;
        case 'P': return 0b111'101'111'100'100;
        case 'S': return 0b111'100'111'001'111;
        case 'T': return 0b111'010'010'010'010;
        case '.': return 0b000'000'000'000'010;
        case ':': return 0b000'010'000'010'000;
        case '/': return 0b001'001'010'100'100;
        default:  return 0;
    }
}

static void drawRawText3x5(SDL_Renderer* renderer, const char* text, int x, int y, int scale) {
    SDL_Rect rects[256];
    int count = 0;
    int curX = x;
    for (const char* p = text; *p; ++p) {
        uint16_t bits = glyph3x5(*p);
        if (bits) {
            for (int row = 0; row < 5; ++row) {
                int rowBits = (bits >> ((4 - row) * 3)) & 0x7;
                for (int col = 0; col < 3; ++col) {
                    if (rowBits & (1 << (2 - col))) {
                        if (count < 256) {
                            rects[count++] = {curX + col * scale, y + row * scale, scale, scale};
                        }
                    }
                }
            }
        }
        curX += 4 * scale;
    }
    if (count > 0) {
        SDL_RenderFillRects(renderer, rects, count);
    }
}

static void drawFpsOverlay(SDL_Renderer* renderer, const char* text, int winW, int winH) {
    if (!text || !text[0]) return;
    // Taille discrète adaptative selon la résolution de l'écran (~2 à 4 px par point de la police 3x5)
    int scale = winH / 260;
    if (scale < 2) scale = 2;
    if (scale > 5) scale = 5;

    // Décalé pour éviter les coins arrondis / encoches des écrans de téléphones (aligné avec le bouton L1 à x=2.5%)
    int x = (int)(winW * 0.025f);
    int y = (int)(winH * 0.016f);
    if (x < 24) x = 24;
    if (y < 12) y = 12;

    SDL_SetRenderDrawBlendMode(renderer, SDL_BLENDMODE_BLEND);

    // 1. Ombre portée sombre semi-transparente (+1 scalaire en X/Y) pour rester lisible sur fond clair
    SDL_SetRenderDrawColor(renderer, 0, 0, 0, 165);
    drawRawText3x5(renderer, text, x + (scale > 2 ? 2 : 1), y + (scale > 2 ? 2 : 1), scale);

    // 2. Texte clair semi-transparent discret
    SDL_SetRenderDrawColor(renderer, 235, 245, 235, 195);
    drawRawText3x5(renderer, text, x, y, scale);
}

// ============================================================================
// SYSTÈME DE STOCKAGE CENTRALISÉ (GOW-Betra), MIGRATION, LOGS & CRASH HANDLER
// ============================================================================
static constexpr size_t kMaxLogFileBytes = 2 * 1024 * 1024; // Limite de ~2 Mo par fichier de log
static constexpr size_t kMaxSessionLogs  = 10;              // Garde uniquement les 10 derniers fichiers

static FILE* g_logFile = nullptr;
static size_t g_logBytesWritten = 0;
static bool g_logLimitReached = false;
static volatile sig_atomic_t g_crashLogFd = -1;
static bool g_usingExternalStorage = false;
static std::string g_activeRootDir;
static std::string g_sessionLogFilename;

// Gestionnaire de signal natif async-signal-safe (utilise uniquement write() et fsync() POSIX)
static struct sigaction g_oldSigActions[32];
static bool g_crashHandlersInstalled = false;

static void safeCrashSignalHandler(int sig, siginfo_t* info, void* ucontext) {
    int fd = (int)g_crashLogFd;
    if (fd >= 0) {
        const char* prefix = "\n=== NATIVE CRASH SIGNAL RECEIVED: ";
        const char* sigName = "UNKNOWN";
        if (sig == SIGSEGV) sigName = "SIGSEGV (Segmentation Fault)";
        else if (sig == SIGABRT) sigName = "SIGABRT (Abort)";
        else if (sig == SIGBUS)  sigName = "SIGBUS (Bus Error)";
        else if (sig == SIGFPE)  sigName = "SIGFPE (Floating Point Exception)";
        else if (sig == SIGILL)  sigName = "SIGILL (Illegal Instruction)";
        const char* suffix = " ===\n";

        (void)::write(fd, prefix, std::strlen(prefix));
        (void)::write(fd, sigName, std::strlen(sigName));
        (void)::write(fd, suffix, std::strlen(suffix));
        (void)::fsync(fd);
    }

    // Chaîne vers le handler Android par défaut (debuggerd) pour ne pas bloquer le rapport système
    if (sig >= 0 && sig < 32) {
        const struct sigaction& oldSa = g_oldSigActions[sig];
        if ((oldSa.sa_flags & SA_SIGINFO) && oldSa.sa_sigaction) {
            oldSa.sa_sigaction(sig, info, ucontext);
            return;
        } else if (oldSa.sa_handler != SIG_DFL && oldSa.sa_handler != SIG_IGN && oldSa.sa_handler != nullptr) {
            oldSa.sa_handler(sig);
            return;
        }
    }
    signal(sig, SIG_DFL);
    raise(sig);
}

static void installSafeCrashHandlers() {
    if (g_crashHandlersInstalled) return;
    g_crashHandlersInstalled = true;
    const int kSignals[] = {SIGSEGV, SIGABRT, SIGBUS, SIGFPE, SIGILL};
    for (int s : kSignals) {
        struct sigaction sa;
        std::memset(&sa, 0, sizeof(sa));
        sa.sa_sigaction = safeCrashSignalHandler;
        sigemptyset(&sa.sa_mask);
        sa.sa_flags = SA_SIGINFO | SA_ONSTACK;
        sigaction(s, &sa, &g_oldSigActions[s]);
    }
}

static void appLog(const char* category, const std::string& message) {
    const char* cat = category ? category : "INFO";
    SDL_Log("[%s] %s", cat, message.c_str());

    if (!g_logFile || g_logLimitReached) return;

    std::time_t t = std::time(nullptr);
    std::tm tmBuf{};
    localtime_r(&t, &tmBuf);
    char timeStr[32];
    std::snprintf(timeStr, sizeof(timeStr), "%02d:%02d:%02d",
                  tmBuf.tm_hour, tmBuf.tm_min, tmBuf.tm_sec);

    char lineBuf[2048];
    int n = std::snprintf(lineBuf, sizeof(lineBuf), "[%s] [%s] %s\n",
                          timeStr, cat, message.c_str());
    if (n <= 0) return;
    size_t len = (size_t)n >= sizeof(lineBuf) ? (sizeof(lineBuf) - 1) : (size_t)n;

    if (g_logBytesWritten + len > kMaxLogFileBytes) {
        const char* limitMsg = "[LOG] Limite de 2 Mo atteinte pour ce fichier de session.\n";
        std::fwrite(limitMsg, 1, std::strlen(limitMsg), g_logFile);
        std::fflush(g_logFile);
        g_logLimitReached = true;
        return;
    }

    if (std::fwrite(lineBuf, 1, len, g_logFile) == len) {
        g_logBytesWritten += len;
        std::fflush(g_logFile);
    }
}

// ---- Appels JNI vers GowMidiPlayer pour les permissions et infos appareil ----
static jclass getGowHelperClass(JNIEnv*& env) {
    env = (JNIEnv*)SDL_AndroidGetJNIEnv();
    if (!env) return nullptr;
    static jclass sHelperCls = nullptr;
    if (sHelperCls) return sHelperCls;

    jobject activity = (jobject)SDL_AndroidGetActivity();
    if (!activity) return nullptr;
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
        return nullptr;
    }
    sHelperCls = (jclass)env->NewGlobalRef(localCls);
    env->DeleteLocalRef(localCls);
    return sHelperCls;
}

static std::string jniCallStaticString(const char* methodName, const char* fallback) {
    JNIEnv* env = nullptr;
    jclass cls = getGowHelperClass(env);
    if (!cls) return fallback;
    jmethodID mid = env->GetStaticMethodID(cls, methodName, "()Ljava/lang/String;");
    if (!mid) {
        if (env->ExceptionCheck()) env->ExceptionClear();
        return fallback;
    }
    jstring jstr = (jstring)env->CallStaticObjectMethod(cls, mid);
    if (env->ExceptionCheck() || !jstr) {
        env->ExceptionClear();
        return fallback;
    }
    const char* utf = env->GetStringUTFChars(jstr, nullptr);
    std::string out = utf ? utf : fallback;
    if (utf) env->ReleaseStringUTFChars(jstr, utf);
    env->DeleteLocalRef(jstr);
    return out;
}

static bool jniHasStoragePermission() {
    JNIEnv* env = nullptr;
    jclass cls = getGowHelperClass(env);
    if (!cls) return false;
    jmethodID mid = env->GetStaticMethodID(cls, "hasStoragePermission", "()Z");
    if (!mid) {
        if (env->ExceptionCheck()) env->ExceptionClear();
        return false;
    }
    jboolean res = env->CallStaticBooleanMethod(cls, mid);
    if (env->ExceptionCheck()) {
        env->ExceptionClear();
        return false;
    }
    return res == JNI_TRUE;
}

static void jniOpenStoragePermissionSettings() {
    JNIEnv* env = nullptr;
    jclass cls = getGowHelperClass(env);
    if (!cls) return;
    jmethodID mid = env->GetStaticMethodID(cls, "openStoragePermissionSettings", "()V");
    if (!mid) {
        if (env->ExceptionCheck()) env->ExceptionClear();
        return;
    }
    env->CallStaticVoidMethod(cls, mid);
    if (env->ExceptionCheck()) env->ExceptionClear();
}

// ---- Extraction des fichiers RP1..RP33 depuis l'APK vers Platform::dataDir ----
static void unpackAssetsToStorage(const std::string& destDir) {
    std::error_code ec;
    std::filesystem::create_directories(destDir, ec);

    if (std::filesystem::exists(destDir + "/RP19", ec) &&
        std::filesystem::exists(destDir + "/RP1", ec)) {
        return;
    }

    int extracted = 0;
    for (int i = 1; i <= 33; i++) {
        std::string name = "RP" + std::to_string(i);
        std::string outPath = destDir + "/" + name;
        if (std::filesystem::exists(outPath, ec) && std::filesystem::file_size(outPath, ec) > 0) {
            extracted++;
            continue;
        }
        SDL_RWops* rw = SDL_RWFromFile(name.c_str(), "rb");
        if (!rw) continue;

        Sint64 size = SDL_RWsize(rw);
        if (size > 0) {
            std::vector<uint8_t> buf;
            try {
                buf.resize((size_t)size);
            } catch (...) {
                SDL_RWclose(rw);
                continue;
            }
            size_t got = SDL_RWread(rw, buf.data(), 1, (size_t)size);
            if (got == (size_t)size) {
                FILE* out = std::fopen(outPath.c_str(), "wb");
                if (out) {
                    if (std::fwrite(buf.data(), 1, buf.size(), out) == buf.size() &&
                        std::fflush(out) == 0) {
                        extracted++;
                    }
                    std::fclose(out);
                }
            }
        }
        SDL_RWclose(rw);
    }
    appLog("ASSETS", "Verification/extraction de RP1..RP33 vers " + destDir +
                     " (" + std::to_string(extracted) + "/33 prets)");
}

// Vérifie que les sous-dossiers data/, saves/, logs/ peuvent être créés et qu'un fichier test peut y être écrit
static bool probeRootDirectoryWritable(const std::string& rootDir) {
    std::error_code ec;
    std::filesystem::create_directories(rootDir + "/data", ec);
    if (ec) return false;
    std::filesystem::create_directories(rootDir + "/saves", ec);
    if (ec) return false;
    std::filesystem::create_directories(rootDir + "/logs", ec);
    if (ec) return false;

    std::string testFile = rootDir + "/saves/.gow_write_probe";
    FILE* f = std::fopen(testFile.c_str(), "wb");
    if (!f) return false;
    const char kProbe[] = "OK";
    bool ok = (std::fwrite(kProbe, 1, sizeof(kProbe), f) == sizeof(kProbe)) && (std::fflush(f) == 0);
    if (std::fclose(f) != 0) ok = false;
    std::filesystem::remove(testFile, ec);
    return ok;
}

// Copie les fichiers de srcDir vers dstDir sans supprimer la source et sans écraser un fichier plus récent
static int migrateDirectoryFiles(const std::string& srcDir, const std::string& dstDir) {
    if (srcDir == dstDir) return 0;
    std::error_code ec;
    if (!std::filesystem::exists(srcDir, ec) || !std::filesystem::is_directory(srcDir, ec)) {
        return 0;
    }
    std::filesystem::create_directories(dstDir, ec);
    if (ec) return 0;

    int copiedCount = 0;
    for (std::filesystem::directory_iterator it(srcDir, std::filesystem::directory_options::skip_permission_denied, ec);
         !ec && it != std::filesystem::directory_iterator();
         it.increment(ec)) {
        const auto& entry = *it;
        std::error_code stEc;
        if (!entry.is_regular_file(stEc) || stEc) continue;

        std::string filename = entry.path().filename().string();
        if (filename.empty() || filename[0] == '.') continue;
        // Ignore les fichiers temporaires inachevés
        if (filename.size() > 4 && filename.substr(filename.size() - 4) == ".tmp") continue;

        std::filesystem::path dstPath = std::filesystem::path(dstDir) / filename;
        bool shouldCopy = false;
        if (!std::filesystem::exists(dstPath, stEc) || stEc) {
            shouldCopy = true;
        } else {
            auto srcTime = std::filesystem::last_write_time(entry.path(), stEc);
            std::error_code dstEc;
            auto dstTime = std::filesystem::last_write_time(dstPath, dstEc);
            if (!stEc && !dstEc && srcTime > dstTime) {
                shouldCopy = true;
            }
        }

        if (shouldCopy) {
            std::error_code cpEc;
            std::filesystem::copy_file(entry.path(), dstPath,
                                       std::filesystem::copy_options::overwrite_existing, cpEc);
            if (!cpEc) {
                copiedCount++;
            }
        }
    }
    return copiedCount;
}

// Ne conserve que les kMaxSessionLogs (10) derniers fichiers de session dans logDir
static void rotateSessionLogs(const std::string& logDir) {
    std::error_code ec;
    if (!std::filesystem::exists(logDir, ec)) return;

    struct LogEntry {
        std::filesystem::path path;
        std::filesystem::file_time_type mtime;
    };
    std::vector<LogEntry> sessionLogs;

    for (std::filesystem::directory_iterator it(logDir, std::filesystem::directory_options::skip_permission_denied, ec);
         !ec && it != std::filesystem::directory_iterator();
         it.increment(ec)) {
        std::error_code stEc;
        if (!it->is_regular_file(stEc) || stEc) continue;
        std::string fname = it->path().filename().string();
        // Rotation sur les journaux de lancement (gow_*.log), en gardant exceptions.log à part
        if (fname.rfind("gow_", 0) == 0 && fname.size() > 4 && fname.substr(fname.size() - 4) == ".log") {
            auto mt = std::filesystem::last_write_time(it->path(), stEc);
            sessionLogs.push_back({it->path(), mt});
        }
    }

    if (sessionLogs.size() <= kMaxSessionLogs) return;

    std::sort(sessionLogs.begin(), sessionLogs.end(), [](const LogEntry& a, const LogEntry& b) {
        if (a.mtime != b.mtime) return a.mtime > b.mtime;
        return a.path.filename().string() > b.path.filename().string();
    });

    for (size_t i = kMaxSessionLogs; i < sessionLogs.size(); ++i) {
        std::error_code rmEc;
        std::filesystem::remove(sessionLogs[i].path, rmEc);
    }
}

// Fonction UNIQUE qui décide de tous les chemins (dataDir, saveDir, logDir, exceptions.log),
// gère la demande non bloquante de permission au 1er lancement, le repli automatique,
// la migration des sauvegardes et l'ouverture du journal de session.
static void initStoragePaths(SDL_Window* window, bool isFirstStartup) {
    const char* rawInternal = SDL_AndroidGetInternalStoragePath();
    std::string internalRoot = (rawInternal && rawInternal[0]) ? rawInternal : ".";
    std::error_code ec;
    std::filesystem::create_directories(internalRoot, ec);

    // 1. Au tout premier lancement, si la permission n'est pas encore accordée, explique brièvement
    //    et ouvre l'écran système sans jamais bloquer le démarrage en cas de refus.
    if (isFirstStartup && !jniHasStoragePermission()) {
        std::string promptMarker = internalRoot + "/.gow_storage_prompted_v1";
        if (!std::filesystem::exists(promptMarker, ec)) {
            FILE* mf = std::fopen(promptMarker.c_str(), "wb");
            if (mf) {
                std::fwrite("1", 1, 1, mf);
                std::fclose(mf);
            }

            const SDL_MessageBoxButtonData buttons[] = {
                { SDL_MESSAGEBOX_BUTTON_RETURNKEY_DEFAULT, 1, "Ouvrir les reglages" },
                { SDL_MESSAGEBOX_BUTTON_ESCAPEKEY_DEFAULT, 0, "Plus tard" }
            };
            const SDL_MessageBoxData msgBox = {
                SDL_MESSAGEBOX_INFORMATION,
                window,
                "Dossier GOW-Betra",
                "God of War: Betrayal stocke vos sauvegardes, donnees et logs dans le dossier "
                "GOW-Betra a la racine du stockage.\n\n"
                "Appuyez sur « Ouvrir les reglages » pour autoriser l'acces aux fichiers, puis "
                "revenez au jeu.\n"
                "Si vous refusez, le jeu demarrera normalement sur son stockage interne.",
                SDL_arraysize(buttons),
                buttons,
                nullptr
            };
            int buttonId = 0;
            if (SDL_ShowMessageBox(&msgBox, &buttonId) == 0 && buttonId == 1) {
                jniOpenStoragePermissionSettings();

                // Attend brièvement que l'écran des réglages prenne le focus, puis attend le retour
                // de l'utilisateur dans l'app (sans jamais bloquer si l'activité ne perd pas le focus).
                uint32_t waitStart = SDL_GetTicks();
                bool lostFocus = false;
                while (SDL_GetTicks() - waitStart < 1500) {
                    SDL_Event ev;
                    while (SDL_PollEvent(&ev)) {
                        if (ev.type == SDL_WINDOWEVENT && ev.window.event == SDL_WINDOWEVENT_FOCUS_LOST) {
                            lostFocus = true;
                        } else if (ev.type == SDL_APP_WILLENTERBACKGROUND || ev.type == SDL_APP_DIDENTERBACKGROUND) {
                            lostFocus = true;
                        }
                    }
                    if (lostFocus) break;
                    SDL_Delay(20);
                }
                if (lostFocus) {
                    bool regainedFocus = false;
                    while (!regainedFocus) {
                        SDL_Event ev;
                        while (SDL_PollEvent(&ev)) {
                            if (ev.type == SDL_WINDOWEVENT && ev.window.event == SDL_WINDOWEVENT_FOCUS_GAINED) {
                                regainedFocus = true;
                            } else if (ev.type == SDL_APP_DIDENTERFOREGROUND) {
                                regainedFocus = true;
                            } else if (ev.type == SDL_QUIT) {
                                regainedFocus = true;
                            }
                        }
                        if (!regainedFocus) SDL_Delay(30);
                    }
                }
            }
        }
    }

    // 2. Détermine le dossier racine actif : /storage/emulated/0/GOW-Betra si accessible, sinon stockage interne
    std::string externalBase = jniCallStaticString("getExternalStorageRoot", "/storage/emulated/0");
    std::string externalRoot = externalBase + "/GOW-Betra";

    bool hasPerm = jniHasStoragePermission();
    bool canUseExternal = hasPerm && probeRootDirectoryWritable(externalRoot);

    std::string chosenRoot = canUseExternal ? externalRoot : internalRoot;
    if (!canUseExternal) {
        probeRootDirectoryWritable(internalRoot);
    }

    // Si rien n'a changé lors d'une vérification en cours de session, on ne réinitialise pas
    if (!isFirstStartup && chosenRoot == g_activeRootDir && g_logFile != nullptr) {
        return;
    }

    g_usingExternalStorage = canUseExternal;
    g_activeRootDir = chosenRoot;

    // 3. Affecte tous les chemins du portage en un seul endroit
    Platform::dataDir = chosenRoot + "/data";
    Platform::saveDir = chosenRoot + "/saves";
    Platform::fallbackSaveDir = internalRoot + "/saves";
    Platform::logDir  = chosenRoot + "/logs";
    Platform::exceptionsLogPath = Platform::logDir + "/exceptions.log";
    Platform::logCallback = appLog;

    // 4. Migration non destructive depuis l'ancien emplacement interne vers GOW-Betra (si actif)
    int migratedSaves = 0;
    int migratedData  = 0;
    if (canUseExternal) {
        migratedSaves = migrateDirectoryFiles(internalRoot + "/saves", Platform::saveDir);
        migratedData  = migrateDirectoryFiles(internalRoot + "/data",  Platform::dataDir);
        migrateDirectoryFiles(internalRoot + "/logs", Platform::logDir);
    }

    // 5. Ouvre le fichier de log de la session dans Platform::logDir et applique la rotation (max 10 fichiers)
    if (g_sessionLogFilename.empty()) {
        std::time_t now = std::time(nullptr);
        std::tm tmNow{};
        localtime_r(&now, &tmNow);
        char fnameBuf[64];
        std::snprintf(fnameBuf, sizeof(fnameBuf), "gow_%04d-%02d-%02d_%02d-%02d-%02d.log",
                      tmNow.tm_year + 1900, tmNow.tm_mon + 1, tmNow.tm_mday,
                      tmNow.tm_hour, tmNow.tm_min, tmNow.tm_sec);
        g_sessionLogFilename = fnameBuf;
    }

    if (g_logFile) {
        std::fflush(g_logFile);
        g_crashLogFd = -1;
        std::fclose(g_logFile);
        g_logFile = nullptr;
    }

    std::string logFilePath = Platform::logDir + "/" + g_sessionLogFilename;
    g_logFile = std::fopen(logFilePath.c_str(), "ab");
    g_logBytesWritten = 0;
    g_logLimitReached = false;
    if (g_logFile) {
        g_crashLogFd = fileno(g_logFile);
        installSafeCrashHandlers();
    }
    rotateSessionLogs(Platform::logDir);

    // 6. Écrit l'en-tête complet du journal et vide immédiatement le tampon (fflush)
    std::string devHeader = jniCallStaticString("getDeviceHeaderInfo", "App=1.1 | Android");
    std::string permDesc  = jniCallStaticString("getPermissionStateDescription", hasPerm ? "GRANTED" : "DENIED");

    appLog("BOOT", "================================================================");
    appLog("BOOT", devHeader);
    appLog("BOOT", std::string("Mode de stockage : ") +
                   (canUseExternal ? "EXTERNE (GOW-Betra)" : "REPLI INTERNE PRIVE (fallback)"));
    appLog("BOOT", "Etat permission  : " + permDesc);
    appLog("BOOT", "Chemin dataDir   : " + Platform::dataDir);
    appLog("BOOT", "Chemin saveDir   : " + Platform::saveDir);
    appLog("BOOT", "Chemin logDir    : " + Platform::logDir);
    if (canUseExternal) {
        appLog("MIGRATE", "Fichiers migres depuis le stockage interne -> saves: " +
                          std::to_string(migratedSaves) + ", data: " + std::to_string(migratedData));
    }
    appLog("BOOT", "================================================================");

    // 7. S'assure que RP1..RP33 sont présents dans Platform::dataDir et charge les réglages d'affichage
    unpackAssetsToStorage(Platform::dataDir);
    loadDisplaySettings();
}

// ---- Codes MIDP attendus par Engine::platformKey ----
constexpr int kUp = -1, kDown = -2, kLeft = -3, kRight = -4;
constexpr int kFire = -5, kSoftL = -6, kSoftR = -7, kHash = 35;

// ---- Gestion de la Manette Externe + Bascule automatique Tactile <-> Manette ----
static std::vector<SDL_GameController*> g_controllers;
static std::vector<SDL_Joystick*> g_rawJoysticks;
static int g_padSlots[8] = {};
static bool g_showTouchOverlay = true;

static void scanAndOpenControllers() {
    int numJoy = SDL_NumJoysticks();
    for (int i = 0; i < numJoy; i++) {
        if (SDL_IsGameController(i)) {
            SDL_GameController* gc = SDL_GameControllerOpen(i);
            if (gc) {
                SDL_Joystick* j = SDL_GameControllerGetJoystick(gc);
                if (j && (SDL_JoystickNumAxes(j) >= 2 || SDL_JoystickNumHats(j) >= 1)) {
                    bool exists = false;
                    for (auto* c : g_controllers) if (c == gc) exists = true;
                    if (!exists) g_controllers.push_back(gc);
                } else {
                    SDL_GameControllerClose(gc);
                }
            }
        } else {
            SDL_Joystick* joy = SDL_JoystickOpen(i);
            if (joy) {
                if (SDL_JoystickNumAxes(joy) >= 2 && SDL_JoystickNumButtons(joy) >= 4) {
                    bool exists = false;
                    for (auto* j : g_rawJoysticks) if (j == joy) exists = true;
                    if (!exists) g_rawJoysticks.push_back(joy);
                } else {
                    SDL_JoystickClose(joy);
                }
            }
        }
    }
}

static void closeDisconnectedControllers() {
    for (auto it = g_controllers.begin(); it != g_controllers.end();) {
        if (!SDL_GameControllerGetAttached(*it)) {
            SDL_GameControllerClose(*it);
            it = g_controllers.erase(it);
        } else {
            ++it;
        }
    }
    for (auto it = g_rawJoysticks.begin(); it != g_rawJoysticks.end();) {
        if (!SDL_JoystickGetAttached(*it)) {
            SDL_JoystickClose(*it);
            it = g_rawJoysticks.erase(it);
        } else {
            ++it;
        }
    }
}

static bool hasExternalController() {
    return !g_controllers.empty() || !g_rawJoysticks.empty();
}

static void releaseAllPadKeys() {
    if (!g_game) return;
    for (int i = 0; i < 8; i++) {
        if (g_padSlots[i]) {
            g_game->platformKey(g_padSlots[i], false);
            g_padSlots[i] = 0;
        }
    }
}

static void pollControllers(bool inMenu) {
    if (!g_game) return;

    const int dead = 12000;
    bool dpadUp = false, dpadDown = false, dpadLeft = false, dpadRight = false;
    bool stickUp = false, stickDown = false, stickLeft = false, stickRight = false;
    bool btnA = false, btnB = false, btnX = false, btnY = false;
    bool btnStart = false, btnBack = false, btnL1 = false, btnR1 = false;

    for (SDL_GameController* gc : g_controllers) {
        if (!SDL_GameControllerGetAttached(gc)) continue;

        dpadUp    |= SDL_GameControllerGetButton(gc, SDL_CONTROLLER_BUTTON_DPAD_UP) != 0;
        dpadDown  |= SDL_GameControllerGetButton(gc, SDL_CONTROLLER_BUTTON_DPAD_DOWN) != 0;
        dpadLeft  |= SDL_GameControllerGetButton(gc, SDL_CONTROLLER_BUTTON_DPAD_LEFT) != 0;
        dpadRight |= SDL_GameControllerGetButton(gc, SDL_CONTROLLER_BUTTON_DPAD_RIGHT) != 0;

        Sint16 lx = SDL_GameControllerGetAxis(gc, SDL_CONTROLLER_AXIS_LEFTX);
        Sint16 ly = SDL_GameControllerGetAxis(gc, SDL_CONTROLLER_AXIS_LEFTY);
        stickLeft  |= (lx < -dead);
        stickRight |= (lx >  dead);
        stickUp    |= (ly < -dead);
        stickDown  |= (ly >  dead);

        btnA     |= SDL_GameControllerGetButton(gc, SDL_CONTROLLER_BUTTON_A) != 0;
        btnB     |= SDL_GameControllerGetButton(gc, SDL_CONTROLLER_BUTTON_B) != 0;
        btnX     |= SDL_GameControllerGetButton(gc, SDL_CONTROLLER_BUTTON_X) != 0;
        btnY     |= SDL_GameControllerGetButton(gc, SDL_CONTROLLER_BUTTON_Y) != 0;
        btnStart |= SDL_GameControllerGetButton(gc, SDL_CONTROLLER_BUTTON_START) != 0;
        btnBack  |= SDL_GameControllerGetButton(gc, SDL_CONTROLLER_BUTTON_BACK) != 0;
        btnL1    |= SDL_GameControllerGetButton(gc, SDL_CONTROLLER_BUTTON_LEFTSHOULDER) != 0;
        btnR1    |= SDL_GameControllerGetButton(gc, SDL_CONTROLLER_BUTTON_RIGHTSHOULDER) != 0;

        btnL1 |= SDL_GameControllerGetAxis(gc, SDL_CONTROLLER_AXIS_TRIGGERLEFT) > 8000;
        btnR1 |= SDL_GameControllerGetAxis(gc, SDL_CONTROLLER_AXIS_TRIGGERRIGHT) > 8000;
    }

    for (SDL_Joystick* joy : g_rawJoysticks) {
        if (!SDL_JoystickGetAttached(joy)) continue;
        if (SDL_JoystickNumHats(joy) > 0) {
            Uint8 hat = SDL_JoystickGetHat(joy, 0);
            dpadUp    |= (hat & SDL_HAT_UP) != 0;
            dpadDown  |= (hat & SDL_HAT_DOWN) != 0;
            dpadLeft  |= (hat & SDL_HAT_LEFT) != 0;
            dpadRight |= (hat & SDL_HAT_RIGHT) != 0;
        }
        if (SDL_JoystickNumAxes(joy) >= 2) {
            Sint16 lx = SDL_JoystickGetAxis(joy, 0);
            Sint16 ly = SDL_JoystickGetAxis(joy, 1);
            stickLeft  |= (lx < -dead);
            stickRight |= (lx >  dead);
            stickUp    |= (ly < -dead);
            stickDown  |= (ly >  dead);
        }
        int nb = SDL_JoystickNumButtons(joy);
        if (nb > 0) btnA     |= SDL_JoystickGetButton(joy, 0) != 0;
        if (nb > 1) btnB     |= SDL_JoystickGetButton(joy, 1) != 0;
        if (nb > 2) btnX     |= SDL_JoystickGetButton(joy, 2) != 0;
        if (nb > 3) btnY     |= SDL_JoystickGetButton(joy, 3) != 0;
        if (nb > 4) btnL1    |= SDL_JoystickGetButton(joy, 4) != 0;
        if (nb > 5) btnR1    |= SDL_JoystickGetButton(joy, 5) != 0;
        if (nb > 6) btnBack  |= SDL_JoystickGetButton(joy, 6) != 0;
        if (nb > 7) btnStart |= SDL_JoystickGetButton(joy, 7) != 0;
    }

    bool pressed[8] = {};
    pressed[0] = dpadUp    || stickUp    || (!inMenu && btnA);
    pressed[1] = dpadDown  || stickDown  || (!inMenu && btnB);
    pressed[2] = dpadLeft  || stickLeft;
    pressed[3] = dpadRight || stickRight;
    pressed[4] = btnX;
    pressed[5] = btnY || btnR1 || (inMenu && btnA);
    pressed[6] = btnStart || (inMenu && btnB);
    pressed[7] = btnL1 || btnBack;

    for (int i = 0; i < 8; i++) {
        if (pressed[i]) {
            g_showTouchOverlay = false;
            break;
        }
    }

    static const int codes[8] = {kUp, kDown, kLeft, kRight, kFire, kSoftL, kSoftR, kHash};
    for (int i = 0; i < 8; i++) {
        if (pressed[i] && !g_padSlots[i]) {
            g_padSlots[i] = codes[i];
            g_game->platformKey(codes[i], true);
        } else if (!pressed[i] && g_padSlots[i]) {
            g_padSlots[i] = 0;
            g_game->platformKey(codes[i], false);
        }
    }
}

static double nowMs() {
    using namespace std::chrono;
    return duration<double, std::milli>(steady_clock::now().time_since_epoch()).count();
}

// ---- Contrôles tactiles à l'écran (Overlay SDL2) ----
struct TouchButton {
    float nx, ny, nw, nh;
    int codeLevel;
    int codeMenu;
    uint8_t r, g, b;
    bool held = false;
    float glow = 0.0f; // 0.0 (repos) -> 1.0 (appuyé), redescend doucement au relâchement
};

static TouchButton g_buttons[] = {
    // Croix directionnelle (en bas à gauche) : index 0..3
    {0.10f, 0.44f, 0.09f, 0.16f, kUp,    kUp,    196, 122,  82}, // 0: Haut
    {0.10f, 0.78f, 0.09f, 0.16f, kDown,  kDown,  196, 122,  82}, // 1: Bas
    {0.02f, 0.61f, 0.08f, 0.17f, kLeft,  kLeft,  196, 122,  82}, // 2: Gauche
    {0.19f, 0.61f, 0.08f, 0.17f, kRight, kRight, 196, 122,  82}, // 3: Droite

    // Boutons d'action (en bas à droite, disposition style PS2 / PSP) : index 4..7
    {0.73f, 0.61f, 0.09f, 0.17f, kFire,  kFire,  216,  46,   8}, // 4: Carré (Gauche) : Attaque / Valider
    {0.82f, 0.78f, 0.09f, 0.16f, kUp,    kSoftL, 242, 193, 102}, // 5: Croix (Bas)    : Saut / Sélectionner
    {0.90f, 0.61f, 0.08f, 0.17f, kDown,  kSoftR, 242, 193, 102}, // 6: Rond (Droite)  : Prise/Parade / Retour
    {0.82f, 0.44f, 0.09f, 0.16f, kSoftL, kSoftL, 242, 193, 102}, // 7: Triangle (Haut): Changer arme/magie

    // Boutons supérieurs (Coins haut gauche / droite) : index 8..9
    {0.02f, 0.05f, 0.09f, 0.12f, kHash,  kHash,  242, 193, 102}, // 8: L1 (Haut-Gauche) : Menu d'amélioration (#)
    {0.89f, 0.05f, 0.09f, 0.12f, kSoftR, kSoftR, 242, 193, 102}, // 9: Start (Haut-Droite) : Pause / Retour
};
constexpr int kNumButtons = sizeof(g_buttons) / sizeof(g_buttons[0]);

struct FingerPoint {
    SDL_FingerID id;
    float x, y;
};
static std::vector<FingerPoint> g_fingers;
static double g_lastTouchTimeMs = 0.0;
static double g_lastDrawTouchMs = 0.0;

static float normCoord(float v, int winSize) {
    if (v > 1.05f && winSize > 0) {
        return v / (float)winSize;
    }
    return v;
}

static void updateTouchButtons(bool inMenu) {
    if (!g_game) return;
    g_lastTouchTimeMs = nowMs();
    for (int i = 0; i < kNumButtons; i++) {
        TouchButton& b = g_buttons[i];
        bool nowHeld = false;
        for (const auto& f : g_fingers) {
            if (f.x >= b.nx && f.x <= b.nx + b.nw && f.y >= b.ny && f.y <= b.ny + b.nh) {
                nowHeld = true;
                break;
            }
        }
        int code = inMenu ? b.codeMenu : b.codeLevel;
        if (nowHeld && !b.held) {
            b.held = true;
            b.glow = 1.0f;
            g_game->platformKey(code, true);
        } else if (!nowHeld && b.held) {
            b.held = false;
            g_game->platformKey(b.codeLevel, false);
            if (b.codeMenu != b.codeLevel) g_game->platformKey(b.codeMenu, false);
        }
    }
}

// Segment géométrique d'un bouton (isSymbol = true : couleur symbole, false : couleur cadre)
struct TouchSeg {
    int x1, y1, x2, y2;
    bool isSymbol;
};

struct SegList {
    TouchSeg s[32];
    int n = 0;
    void add(int x1, int y1, int x2, int y2, bool isSymbol) {
        if (n < 32) s[n++] = {x1, y1, x2, y2, isSymbol};
    }
};

// Trace un segment d'épaisseur `widthPx` centré sur (x1,y1)-(x2,y2)
static void drawThickSegment(SDL_Renderer* r, int x1, int y1, int x2, int y2, int widthPx) {
    if (widthPx <= 1) {
        SDL_RenderDrawLine(r, x1, y1, x2, y2);
        return;
    }
    int half = widthPx / 2;
    int start = -half;
    int end = start + widthPx - 1;
    int dx = std::abs(x2 - x1);
    int dy = std::abs(y2 - y1);
    // Épaississement sur les deux axes pour que les traits horizontaux, verticaux et diagonaux soient nets
    if (dx >= dy) {
        for (int o = start; o <= end; ++o) {
            SDL_RenderDrawLine(r, x1, y1 + o, x2, y2 + o);
        }
    } else {
        for (int o = start; o <= end; ++o) {
            SDL_RenderDrawLine(r, x1 + o, y1, x2 + o, y2);
        }
    }
}

// Rend tous les segments d'un élément en 2 passes :
//   Passe 1 : contour sombre continu derrière tout le tracé (visibilité sur pierre beige claire)
//   Passe 2 : trait principal bronze/or/sang par-dessus dans le même tracé
static void renderSegList(SDL_Renderer* r, const SegList& list,
                          uint8_t frameR, uint8_t frameG, uint8_t frameB,
                          uint8_t symR, uint8_t symG, uint8_t symB,
                          uint8_t alpha) {
    if (alpha == 0 || list.n == 0) return;

    const int strokeW  = std::max(1, TouchStyle::kTouchStrokePx);
    const int outlineW = strokeW + 2 * std::max(0, TouchStyle::kTouchOutlinePx);

    // Passe 1 : Contour sombre derrière le tracé
    if (TouchStyle::kTouchOutlinePx > 0) {
        SDL_SetRenderDrawColor(r, TouchStyle::kShadowR, TouchStyle::kShadowG, TouchStyle::kShadowB, alpha);
        for (int i = 0; i < list.n; ++i) {
            drawThickSegment(r, list.s[i].x1, list.s[i].y1, list.s[i].x2, list.s[i].y2, outlineW);
        }
    }

    // Passe 2 : Trait principal par-dessus
    for (int i = 0; i < list.n; ++i) {
        if (list.s[i].isSymbol) {
            SDL_SetRenderDrawColor(r, symR, symG, symB, alpha);
        } else {
            SDL_SetRenderDrawColor(r, frameR, frameG, frameB, alpha);
        }
        drawThickSegment(r, list.s[i].x1, list.s[i].y1, list.s[i].x2, list.s[i].y2, strokeW);
    }
}

// Ajoute les 4 équerres octogonales à pans coupés dans SegList
static void addOctagonalBrackets(SegList& list, int cx, int cy, int rad) {
    int cut = std::max(3, rad * 30 / 100); // Pan coupé à 45°
    int arm = std::max(5, rad * 58 / 100); // Longueur des branches (laisse le centre des côtés ouvert)

    // Coin Haut-Gauche
    list.add(cx - arm, cy - rad, cx - rad + cut, cy - rad, false);
    list.add(cx - rad + cut, cy - rad, cx - rad, cy - rad + cut, false);
    list.add(cx - rad, cy - rad + cut, cx - rad, cy - arm, false);

    // Coin Haut-Droite
    list.add(cx + arm, cy - rad, cx + rad - cut, cy - rad, false);
    list.add(cx + rad - cut, cy - rad, cx + rad, cy - rad + cut, false);
    list.add(cx + rad, cy - rad + cut, cx + rad, cy - arm, false);

    // Coin Bas-Gauche
    list.add(cx - arm, cy + rad, cx - rad + cut, cy + rad, false);
    list.add(cx - rad + cut, cy + rad, cx - rad, cy + rad - cut, false);
    list.add(cx - rad, cy + rad - cut, cx - rad, cy + arm, false);

    // Coin Bas-Droite
    list.add(cx + arm, cy + rad, cx + rad - cut, cy + rad, false);
    list.add(cx + rad - cut, cy + rad, cx + rad, cy + rad - cut, false);
    list.add(cx + rad, cy + rad - cut, cx + rad, cy + arm, false);
}

static uint8_t lerpU8(uint8_t a, uint8_t b, float t) {
    float v = a + (b - a) * t;
    return (uint8_t)(v < 0.0f ? 0 : v > 255.0f ? 255 : v);
}

static void drawTouchButtons(SDL_Renderer* renderer, int winW, int winH, double now) {
    SDL_SetRenderDrawBlendMode(renderer, SDL_BLENDMODE_BLEND);

    if (g_lastTouchTimeMs == 0.0) g_lastTouchTimeMs = now;
    double dtMs = (g_lastDrawTouchMs > 0.0) ? (now - g_lastDrawTouchMs) : 16.0;
    if (dtMs < 0.0 || dtMs > 250.0) dtMs = 16.0;
    g_lastDrawTouchMs = now;

    // Si au moins un doigt est posé, on réinitialise le timer d'inactivité
    if (!g_fingers.empty()) {
        g_lastTouchTimeMs = now;
    }

    // Facteur de veille visuelle après kIdleDelayMs sans toucher
    double idleElapsed = now - g_lastTouchTimeMs;
    float idleFactor = 0.0f;
    if (idleElapsed > TouchStyle::kIdleDelayMs) {
        idleFactor = (float)((idleElapsed - TouchStyle::kIdleDelayMs) / TouchStyle::kIdleFadeMs);
        if (idleFactor > 1.0f) idleFactor = 1.0f;
    }

    // Opacité de base directe (sans multiplicateur caché) : de 85% au repos à 65% minimum après inactivité
    float baseAlpha = TouchStyle::kTouchAlphaRest +
                      (TouchStyle::kTouchAlphaMinIdle - TouchStyle::kTouchAlphaRest) * idleFactor;
    if (baseAlpha < TouchStyle::kTouchAlphaMinIdle) {
        baseAlpha = TouchStyle::kTouchAlphaMinIdle;
    }

    // 1. Petit losange central de repère au cœur de la croix directionnelle
    {
        int dpadCx = (int)(0.145f * winW);
        int dpadCy = (int)(0.695f * winH);
        int dr = std::max(5, (int)(0.012f * winH));
        uint8_t centerAlpha = (uint8_t)(baseAlpha > 255.0f ? 255 : baseAlpha);
        SegList centerSegs;
        centerSegs.add(dpadCx, dpadCy - dr, dpadCx + dr, dpadCy, false);
        centerSegs.add(dpadCx + dr, dpadCy, dpadCx, dpadCy + dr, false);
        centerSegs.add(dpadCx, dpadCy + dr, dpadCx - dr, dpadCy, false);
        centerSegs.add(dpadCx - dr, dpadCy, dpadCx, dpadCy - dr, false);
        renderSegList(renderer, centerSegs,
                      TouchStyle::kFrameR, TouchStyle::kFrameG, TouchStyle::kFrameB,
                      TouchStyle::kSymR, TouchStyle::kSymG, TouchStyle::kSymB,
                      centerAlpha);
    }

    // 2. Dessin de chaque bouton
    for (int i = 0; i < kNumButtons; i++) {
        TouchButton& b = g_buttons[i];
        if (b.held) {
            b.glow = 1.0f;
        } else if (b.glow > 0.0f) {
            b.glow -= (float)(dtMs / TouchStyle::kReleaseDecayMs);
            if (b.glow < 0.0f) b.glow = 0.0f;
        }

        float curAlphaF = baseAlpha + (TouchStyle::kTouchAlphaPressed - baseAlpha) * b.glow;
        if (curAlphaF < 1.0f) continue;
        uint8_t alpha = (uint8_t)(curAlphaF > 255.0f ? 255 : curAlphaF);

        // Teinte : bronze au repos -> Or spartiate (ou Rouge sang pour Attaque) à l'appui
        bool isAttack = (i == 4);
        uint8_t targetR = isAttack ? TouchStyle::kBloodR : TouchStyle::kGoldR;
        uint8_t targetG = isAttack ? TouchStyle::kBloodG : TouchStyle::kGoldG;
        uint8_t targetB = isAttack ? TouchStyle::kBloodB : TouchStyle::kGoldB;

        uint8_t frameR = lerpU8(TouchStyle::kFrameR, TouchStyle::kGoldR, b.glow);
        uint8_t frameG = lerpU8(TouchStyle::kFrameG, TouchStyle::kGoldG, b.glow);
        uint8_t frameB = lerpU8(TouchStyle::kFrameB, TouchStyle::kGoldB, b.glow);

        uint8_t symR = lerpU8(TouchStyle::kSymR, targetR, b.glow);
        uint8_t symG = lerpU8(TouchStyle::kSymG, targetG, b.glow);
        uint8_t symB = lerpU8(TouchStyle::kSymB, targetB, b.glow);

        int boxX = (int)(b.nx * winW);
        int boxY = (int)(b.ny * winH);
        int boxW = (int)(b.nw * winW);
        int boxH = (int)(b.nh * winH);
        int cx = boxX + boxW / 2;
        int cy = boxY + boxH / 2;
        int rad = (int)(std::min(boxW, boxH) * 0.5f * TouchStyle::kVisualScale);
        if (rad < 8) rad = 8;

        SegList segs;

        if (i < 4) {
            // ---- CROIX DIRECTIONNELLE (0: Haut, 1: Bas, 2: Gauche, 3: Droite) ----
            int w = rad * 75 / 100;
            int h = rad * 55 / 100;
            int cap = rad * 88 / 100;
            if (i == 0) { // Haut (^)
                segs.add(cx - w, cy - cap, cx + w, cy - cap, false);
                segs.add(cx, cy - h + 3, cx, cy + h * 2 / 3, false);
                segs.add(cx - w, cy + h / 3, cx, cy - h, true);
                segs.add(cx, cy - h, cx + w, cy + h / 3, true);
            } else if (i == 1) { // Bas (v)
                segs.add(cx - w, cy + cap, cx + w, cy + cap, false);
                segs.add(cx, cy - h * 2 / 3, cx, cy + h - 3, false);
                segs.add(cx - w, cy - h / 3, cx, cy + h, true);
                segs.add(cx, cy + h, cx + w, cy - h / 3, true);
            } else if (i == 2) { // Gauche (<)
                segs.add(cx - cap, cy - w, cx - cap, cy + w, false);
                segs.add(cx - h + 3, cy, cx + h * 2 / 3, cy, false);
                segs.add(cx + h / 3, cy - w, cx - h, cy, true);
                segs.add(cx - h, cy, cx + h / 3, cy + w, true);
            } else { // Droite (>)
                segs.add(cx + cap, cy - w, cx + cap, cy + w, false);
                segs.add(cx - h * 2 / 3, cy, cx + h - 3, cy, false);
                segs.add(cx - h / 3, cy - w, cx + h, cy, true);
                segs.add(cx + h, cy, cx - h / 3, cy + w, true);
            }
        } else if (i >= 4 && i <= 7) {
            // ---- BOUTONS D'ACTION (Cadre octogonal ouvert + Symbole spartiate) ----
            addOctagonalBrackets(segs, cx, cy, rad);
            int s = rad * 48 / 100;

            if (i == 4) {
                // 4: ATTAQUE (Deux lames croisées avec gardes)
                int gOff = s * 45 / 100;
                int gSpan = std::max(3, s * 32 / 100);
                segs.add(cx - gOff - gSpan, cy + gOff - gSpan, cx - gOff + gSpan, cy + gOff + gSpan, false);
                segs.add(cx + gOff - gSpan, cy + gOff + gSpan, cx + gOff + gSpan, cy + gOff - gSpan, false);
                segs.add(cx - s, cy + s, cx + s, cy - s, true);
                segs.add(cx - s, cy - s, cx + s, cy + s, true);
            } else if (i == 5) {
                // 5: SAUT (Double chevron ascendant spartiate / Lambda)
                int w1 = s, h1 = s * 55 / 100;
                int w2 = s * 65 / 100;
                segs.add(cx - w2, cy + h1, cx, cy, true);
                segs.add(cx, cy, cx + w2, cy + h1, true);
                segs.add(cx - w1, cy + h1 / 3, cx, cy - h1, true);
                segs.add(cx, cy - h1, cx + w1, cy + h1 / 3, true);
            } else if (i == 6) {
                // 6: PRISE / PARADE (Crochets de bouclier/saisie opposés [ ])
                int w = s * 85 / 100, h = s * 75 / 100, in = s * 35 / 100;
                segs.add(cx - in, cy - h, cx - w, cy - h / 2, true);
                segs.add(cx - w, cy - h / 2, cx - w, cy + h / 2, true);
                segs.add(cx - w, cy + h / 2, cx - in, cy + h, true);
                segs.add(cx + in, cy - h, cx + w, cy - h / 2, true);
                segs.add(cx + w, cy - h / 2, cx + w, cy + h / 2, true);
                segs.add(cx + w, cy + h / 2, cx + in, cy + h, true);
            } else if (i == 7) {
                // 7: ARME / MAGIE (Losange spartiate gravé <> avec fente centrale)
                int slit = s * 42 / 100;
                segs.add(cx, cy - slit, cx, cy + slit, false);
                segs.add(cx, cy - s, cx + s, cy, true);
                segs.add(cx + s, cy, cx, cy + s, true);
                segs.add(cx, cy + s, cx - s, cy, true);
                segs.add(cx - s, cy, cx, cy - s, true);
            }
        } else {
            // ---- BOUTONS SUPÉRIEURS (8: L1 Amélioration, 9: Start Pause) ----
            int rw = (int)(boxW * 0.34f);
            int rh = (int)(boxH * 0.32f);
            int cut = std::max(3, rh / 3);
            segs.add(cx - rw + cut, cy - rh, cx - rw, cy - rh + cut, false);
            segs.add(cx - rw + cut, cy - rh, cx - rw / 4, cy - rh, false);
            segs.add(cx - rw, cy - rh + cut, cx - rw, cy + rh / 3, false);

            segs.add(cx + rw - cut, cy + rh, cx + rw, cy + rh - cut, false);
            segs.add(cx + rw - cut, cy + rh, cx + rw / 4, cy + rh, false);
            segs.add(cx + rw, cy + rh - cut, cx + rw, cy - rh / 3, false);

            int s = std::max(4, rh * 58 / 100);
            if (i == 8) {
                // 8: L1 AMÉLIORATION (#) -> Symbole Oméga angulaire spartiate
                int w = s, h = s * 80 / 100, foot = std::max(2, s * 45 / 100);
                segs.add(cx - w, cy + h, cx - foot, cy + h, true);
                segs.add(cx + foot, cy + h, cx + w, cy + h, true);
                segs.add(cx - foot, cy + h, cx - w, cy - h / 3, true);
                segs.add(cx - w, cy - h / 3, cx - foot, cy - h, true);
                segs.add(cx - foot, cy - h, cx + foot, cy - h, true);
                segs.add(cx + foot, cy - h, cx + w, cy - h / 3, true);
                segs.add(cx + w, cy - h / 3, cx + foot, cy + h, true);
            } else {
                // 9: START / PAUSE -> Deux traits verticaux gravés ||
                int gap = std::max(3, s * 45 / 100);
                segs.add(cx - gap, cy - s, cx - gap, cy + s, true);
                segs.add(cx + gap, cy - s, cx + gap, cy + s, true);
            }
        }

        renderSegList(renderer, segs, frameR, frameG, frameB, symR, symG, symB, alpha);
    }
}

int main(int argc, char* argv[]) {
    (void)argc;
    (void)argv;

    if (SDL_Init(SDL_INIT_VIDEO | SDL_INIT_JOYSTICK | SDL_INIT_GAMECONTROLLER) != 0) {
        SDL_Log("Erreur SDL_Init: %s", SDL_GetError());
        return 1;
    }

    SDL_SetHint(SDL_HINT_TOUCH_MOUSE_EVENTS, "0");
    SDL_SetHint(SDL_HINT_MOUSE_TOUCH_EVENTS, "0");
    SDL_SetHint(SDL_HINT_RENDER_SCALE_QUALITY, "nearest");
    SDL_SetHint(SDL_HINT_ACCELEROMETER_AS_JOYSTICK, "0");

    // Garde l'écran allumé pendant toute la session de jeu (sans permission requise)
    SDL_DisableScreenSaver();

    scanAndOpenControllers();
    g_showTouchOverlay = !hasExternalController();

    SDL_Window* window = SDL_CreateWindow(
        "God of War: Betrayal",
        SDL_WINDOWPOS_CENTERED, SDL_WINDOWPOS_CENTERED,
        0, 0,
        SDL_WINDOW_FULLSCREEN | SDL_WINDOW_SHOWN | SDL_WINDOW_ALLOW_HIGHDPI
    );
    if (!window) return 1;

    SDL_Renderer* renderer = SDL_CreateRenderer(
        window, -1,
        SDL_RENDERER_ACCELERATED | SDL_RENDERER_PRESENTVSYNC
    );
    if (!renderer) return 1;

    SDL_GetRendererOutputSize(renderer, &g_windowW, &g_windowH);

    // Adapte par défaut la cadence d'interpolation au taux de rafraîchissement de l'écran (60 / 90 / 120 Hz)
    SDL_DisplayMode dm;
    if (SDL_GetCurrentDisplayMode(0, &dm) == 0 && dm.refresh_rate >= 60) {
        g_fpsMode = dm.refresh_rate;
    }

    // 1. Centralise l'initialisation des chemins (GOW-Betra ou repli interne), la permission,
    //    la migration non destructive, l'extraction de RP1..RP33, les réglages et le fichier de log.
    initStoragePaths(window, true);

    // 2. Démarre le MIDlet et le jeu God of War: Betrayal
    GOWMIDlet* midlet = new GOWMIDlet();
    midlet->startApp();
    g_game = static_cast<Game*>(midlet->game);

    if (!g_game || !g_game->ok() || !g_game->supportedBuild()) {
        appLog("FATAL", "Impossible de charger RP1..RP33 depuis " + Platform::dataDir);
        if (g_logFile) {
            std::fflush(g_logFile);
            g_crashLogFd = -1;
            std::fclose(g_logFile);
            g_logFile = nullptr;
        }
        return 1;
    }
    appLog("BOOT", "MIDlet demarre avec succes (RP1..RP33 valides).");

    // 3. Texture SDL2 qui recevra les pixels 0xAARRGGBB de g_screen
    SDL_Texture* gameTex = nullptr;
    int texW = 0, texH = 0;

    // 4. Variables de mesure du compteur FPS / TPS (lissées et rafraîchies toutes les ~500 ms)
    double fpsWindowStartMs = 0.0;
    int renderedFramesInWindow = 0;
    long lastTickCount = 0;
    double smoothedFps = 0.0;
    double smoothedTps = 0.0;
    char fpsText[32] = "";

    bool running = true;
    while (running && !g_game->quit) {
        bool inMenu = (Game::state != 100);

        SDL_Event ev;
        while (SDL_PollEvent(&ev)) {
            switch (ev.type) {
                case SDL_QUIT:
                    running = false;
                    break;
                case SDL_WINDOWEVENT:
                    if (ev.window.event == SDL_WINDOWEVENT_SIZE_CHANGED) {
                        SDL_GetRendererOutputSize(renderer, &g_windowW, &g_windowH);
                    } else if (ev.window.event == SDL_WINDOWEVENT_FOCUS_LOST) {
                        g_fingers.clear();
                        updateTouchButtons(inMenu);
                        releaseAllPadKeys();
                        g_game->shown = false;
                        g_game->hideNotify();
                    } else if (ev.window.event == SDL_WINDOWEVENT_FOCUS_GAINED) {
                        // Si la permission a été accordée entre-temps dans les réglages Android,
                        // bascule automatiquement vers GOW-Betra et migre les sauvegardes.
                        if (!g_usingExternalStorage && jniHasStoragePermission()) {
                            initStoragePaths(window, false);
                        }
                        g_game->shown = true;
                        g_game->showNotify();
                    }
                    break;
                case SDL_CONTROLLERDEVICEADDED:
                case SDL_JOYDEVICEADDED:
                    scanAndOpenControllers();
                    if (hasExternalController()) {
                        g_showTouchOverlay = false;
                        g_fingers.clear();
                        updateTouchButtons(inMenu);
                    }
                    break;
                case SDL_CONTROLLERDEVICEREMOVED:
                case SDL_JOYDEVICEREMOVED:
                    closeDisconnectedControllers();
                    if (!hasExternalController()) {
                        releaseAllPadKeys();
                        g_showTouchOverlay = true;
                    }
                    break;
                case SDL_KEYDOWN:
                    if (ev.key.keysym.sym == SDLK_AC_BACK || ev.key.keysym.sym == SDLK_ESCAPE) {
                        g_game->platformKey(kSoftR, true);
                    }
                    break;
                case SDL_KEYUP:
                    if (ev.key.keysym.sym == SDLK_AC_BACK || ev.key.keysym.sym == SDLK_ESCAPE) {
                        g_game->platformKey(kSoftR, false);
                    }
                    break;
                case SDL_FINGERDOWN: {
                    if (!hasExternalController()) g_showTouchOverlay = true;
                    float fx = normCoord(ev.tfinger.x, g_windowW);
                    float fy = normCoord(ev.tfinger.y, g_windowH);
                    for (auto it = g_fingers.begin(); it != g_fingers.end();) {
                        if (it->id == ev.tfinger.fingerId) it = g_fingers.erase(it);
                        else ++it;
                    }
                    g_fingers.push_back({ev.tfinger.fingerId, fx, fy});
                    updateTouchButtons(inMenu);
                    break;
                }
                case SDL_FINGERMOTION: {
                    float fx = normCoord(ev.tfinger.x, g_windowW);
                    float fy = normCoord(ev.tfinger.y, g_windowH);
                    for (auto& f : g_fingers) {
                        if (f.id == ev.tfinger.fingerId) {
                            f.x = fx;
                            f.y = fy;
                            break;
                        }
                    }
                    updateTouchButtons(inMenu);
                    break;
                }
                case SDL_FINGERUP:
                    for (auto it = g_fingers.begin(); it != g_fingers.end(); ++it) {
                        if (it->id == ev.tfinger.fingerId) {
                            g_fingers.erase(it);
                            break;
                        }
                    }
                    updateTouchButtons(inMenu);
                    break;
            }
        }

        if (hasExternalController()) {
            pollControllers(inMenu);
        }

        // 5. Fait avancer d'une image la logique et le rendu logiciel dans g_screen
        g_frameProfile.reset();
        double frameNow = nowMs();
        int sleepMs = g_game->runFrame(frameNow, g_screen);
        if (g_game->quit) break;

        double sdlStartMs = nowMs();

        // 6. Crée ou redimensionne la texture SDL2 si la largeur logique (widescreen) a changé
        if (!gameTex || texW != g_screen.w || texH != g_screen.h) {
            if (gameTex) SDL_DestroyTexture(gameTex);
            texW = g_screen.w;
            texH = g_screen.h;
            SDL_SetHint(SDL_HINT_RENDER_SCALE_QUALITY, "nearest");
            gameTex = SDL_CreateTexture(
                renderer,
                SDL_PIXELFORMAT_ARGB8888,
                SDL_TEXTUREACCESS_STREAMING,
                texW, texH
            );
            if (gameTex) {
                SDL_SetTextureScaleMode(gameTex, SDL_ScaleModeNearest);
                SDL_SetTextureBlendMode(gameTex, SDL_BLENDMODE_NONE);
            }
        }

        // 7. Transfert direct des pixels vers la texture GPU
        void* texPixels = nullptr;
        int texPitch = 0;
        if (SDL_LockTexture(gameTex, nullptr, &texPixels, &texPitch) == 0) {
            const uint8_t* src = reinterpret_cast<const uint8_t*>(g_screen.px.data());
            uint8_t* dst = static_cast<uint8_t*>(texPixels);
            const int rowBytes = texW * (int)sizeof(uint32_t);
            if (texPitch == rowBytes) {
                std::memcpy(dst, src, (size_t)rowBytes * (size_t)texH);
            } else {
                for (int y = 0; y < texH; y++) {
                    std::memcpy(dst + y * texPitch, src + y * rowBytes, (size_t)rowBytes);
                }
            }
            SDL_UnlockTexture(gameTex);
        } else {
            SDL_UpdateTexture(gameTex, nullptr, g_screen.px.data(), texW * (int)sizeof(uint32_t));
        }

        SDL_SetRenderDrawColor(renderer, 0, 0, 0, 255);
        SDL_RenderClear(renderer);

        int dstW = g_windowW, dstH = g_windowH;
        if ((long long)g_windowW * texH >= (long long)g_windowH * texW) {
            dstH = g_windowH;
            dstW = (int)((long long)g_windowH * texW / texH);
        } else {
            dstW = g_windowW;
            dstH = (int)((long long)g_windowW * texH / texW);
        }
        SDL_Rect dstRect = {(g_windowW - dstW) / 2, (g_windowH - dstH) / 2, dstW, dstH};
        SDL_RenderCopy(renderer, gameTex, nullptr, &dstRect);

        // 8. Dessine les boutons tactiles si aucune vraie manette n'est active
        if (g_showTouchOverlay) {
            drawTouchButtons(renderer, g_windowW, g_windowH, frameNow);
        }

        // 9. Compteur FPS / TPS (zéro coût quand g_showFpsCounter == false)
        if (g_showFpsCounter) {
            renderedFramesInWindow++;
            if (fpsWindowStartMs == 0.0) {
                fpsWindowStartMs = frameNow;
                lastTickCount = g_game->tickCount;
                std::snprintf(fpsText, sizeof(fpsText), "-- FPS  -- TPS");
            } else {
                double elapsedMs = frameNow - fpsWindowStartMs;
                if (elapsedMs >= 500.0) {
                    double instFps = renderedFramesInWindow * 1000.0 / elapsedMs;
                    double instTps = (g_game->tickCount - lastTickCount) * 1000.0 / elapsedMs;
                    smoothedFps = (smoothedFps == 0.0) ? instFps : (smoothedFps * 0.35 + instFps * 0.65);
                    smoothedTps = (smoothedTps == 0.0) ? instTps : (smoothedTps * 0.35 + instTps * 0.65);
                    std::snprintf(fpsText, sizeof(fpsText), "%d FPS  %d TPS",
                                  (int)(smoothedFps + 0.5), (int)(smoothedTps + 0.5));
                    fpsWindowStartMs = frameNow;
                    renderedFramesInWindow = 0;
                    lastTickCount = g_game->tickCount;
                }
            }
            drawFpsOverlay(renderer, fpsText, g_windowW, g_windowH);
        } else {
            fpsWindowStartMs = 0.0;
            renderedFramesInWindow = 0;
        }

        SDL_RenderPresent(renderer);
        g_frameProfile.sdlMs = nowMs() - sdlStartMs;

        // 10. Outil de mesure temporaire : écrit dans logcat uniquement les images > 12 ms
        if (g_enableFrameProfiler) {
            double totalMs = g_frameProfile.tickMs + g_frameProfile.drawMs +
                             g_frameProfile.sdlMs + g_frameProfile.audioMs;
            if (totalMs > kSlowFrameThresholdMs) {
                SDL_Log("[GowPerf] SLOW FRAME #%ld: total=%.2f ms | (a) tick=%.2f ms (tick=%d) | "
                        "(b) draw=%.2f ms | (c) sdl=%.2f ms | (d) audio=%.2f ms "
                        "(start=%d prefetch=%d stop=%d state=%d) | exc=%d",
                        g_game->paintCount,
                        totalMs,
                        g_frameProfile.tickMs, g_frameProfile.didTick ? 1 : 0,
                        g_frameProfile.drawMs,
                        g_frameProfile.sdlMs,
                        g_frameProfile.audioMs,
                        g_frameProfile.audioPlays,
                        g_frameProfile.audioPrefetches,
                        g_frameProfile.audioStops,
                        g_frameProfile.audioQueries,
                        g_frameProfile.javaExceptions);
            }
        }

        if (sleepMs > 0) {
            SDL_Delay((Uint32)sleepMs);
        }
    }

    appLog("SHUTDOWN", "Fermeture propre de l'application.");
    if (g_logFile) {
        std::fflush(g_logFile);
        g_crashLogFd = -1;
        std::fclose(g_logFile);
        g_logFile = nullptr;
    }

    if (gameTex) SDL_DestroyTexture(gameTex);
    SDL_DestroyRenderer(renderer);
    SDL_DestroyWindow(window);
    SDL_Quit();
    return 0;
}
