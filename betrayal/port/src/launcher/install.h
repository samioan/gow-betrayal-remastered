#pragma once

// Turning "the .jar the user picked" into a working install: unzip it into
// the install's own `data/` and check the result looks like the game.
// The jar is a plain zip whose entries are flat (tools/extract_jar.py's
// own loader is zipfile.extractall()).

#include <string>

namespace gow {
namespace launcher {

// The port supports one build: the Sony Ericsson K800i version (MIDlet 1.4.20,
// God-of-War-Betrayal_K800i_v1420.jar). RP1, RP2 and RP3 (the first three
// resource banks) must be top-level files, so an unrelated folder is not
// mistaken for the game, and RP19 must hold two resources (a level and its
// parallax background): the generic v1.4.8 build has the same file names but
// one resource there, 16 px tiles and different code, so it cannot run.
bool IsGameDataRoot(const std::string& directory);

// True when `directory` holds the game's files from a build other than the
// K800i one (RP1..RP3 present, RP19 not shaped like the K800i build's).
bool IsUnsupportedBuild(const std::string& directory);

// Unzips `jarPath` into `destDir` (creating it, overwriting what's already
// there) and checks the result via IsGameDataRoot. On failure returns
// false and puts something a user can act on in `error` (not a real jar,
// a permission problem, a full disk, a source that vanished mid-copy).
bool InstallGameJar(const std::string& jarPath, const std::string& destDir, std::string& error);

}  // namespace launcher
}  // namespace gow
