#include "launcher/install.h"

#include <filesystem>
#include <fstream>

#include "launcher/zip_reader.h"

namespace gow {
namespace launcher {

namespace {

namespace fs = std::filesystem;

const char* const kMarkerFiles[] = {
    "RP1",
    "RP2",
    "RP3",
};

bool HasMarkers(const std::string& directory) {
    if (directory.empty()) return false;
    std::error_code error;
    if (!fs::is_directory(fs::path(directory), error) || error) return false;
    for (const char* marker : kMarkerFiles) {
        if (!fs::is_regular_file(fs::path(directory) / marker, error) || error) return false;
    }
    return true;
}

// RP19's container header: u8 flags, u16 big-endian resource count. 2 in the
// K800i build (level 19456 + background 19457), 1 in v1.4.8.
bool IsK800iBuild(const std::string& directory) {
    std::ifstream in(fs::path(directory) / "RP19", std::ios::binary);
    unsigned char header[3] = {};
    if (!in.read(reinterpret_cast<char*>(header), 3)) return false;
    return (header[1] << 8 | header[2]) == 2;
}

}  // namespace

bool IsGameDataRoot(const std::string& directory) {
    return HasMarkers(directory) && IsK800iBuild(directory);
}

bool IsUnsupportedBuild(const std::string& directory) {
    return HasMarkers(directory) && !IsK800iBuild(directory);
}

bool InstallGameJar(const std::string& jarPath, const std::string& destDir, std::string& error) {
    error.clear();
    std::error_code code;
    if (!fs::is_regular_file(fs::path(jarPath), code) || code) {
        error = jarPath + " is not a file";
        return false;
    }

    fs::create_directories(fs::path(destDir), code);
    if (code) {
        error = "could not create " + destDir + ": " + code.message();
        return false;
    }

    // A .jar is a plain zip; ExtractZip lands every entry straight into
    // destDir, the same flat layout tools/extract_jar.py's own
    // zipfile.extractall() produces.
    if (!ExtractZip(jarPath, destDir, error)) {
        error = "could not unpack " + jarPath + ": " + error;
        return false;
    }

    if (IsUnsupportedBuild(destDir)) {
        error = "that is a different version of God of War: Betrayal -- this port needs the "
                "Sony Ericsson K800i version (MIDlet 1.4.20, 22 px tiles and parallax backgrounds)";
        return false;
    }
    if (!IsGameDataRoot(destDir)) {
        error = "that .jar isn't God of War: Betrayal -- RP1/RP2/RP3 are missing after unpacking";
        return false;
    }
    return true;
}

}  // namespace launcher
}  // namespace gow
