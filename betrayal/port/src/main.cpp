// God of War: Betrayal -- PC port: the Win32 shell around the translated game.
//
//   gow_port.exe [--data <dir with RP1..RP33>] [--saves <dir>] [--windowed | --fullscreen]
//                [--dump <file.bmp> [--frames N] [--press KEY@FRAME[:HOLD] ...]] [--bench SECONDS] [--width LOGICAL_PX] [--trace FILE]
//
// --dump runs headless: N logic frames on a fake 40 ms clock, key presses scripted by frame (KEY is a
// MIDP key code: -1 up, -2 down, -3 left, -4 right, -5 fire, -6/-7 soft keys), then writes the last
// frame as a BMP. It is how the port is tested without a display. --bench runs the real-clock loop of the
// window (no window) for SECONDS and writes the logic steps per second to bench.txt: the original targets 25.
#define _CRT_SECURE_NO_WARNINGS
#include <windows.h>
#include <dbghelp.h>
#include <mmsystem.h>
#include <shellapi.h>

#include <cstdio>
#include <string>
#include <vector>

#include "display.h"
#include "gen/classes.h"
#include "input.h"

using namespace gow;

// Writes crash.txt with the faulting stack (needs the .pdb next to the exe for names).
static LONG WINAPI crashHandler(EXCEPTION_POINTERS* ep) {
  FILE* f = std::fopen("crash.txt", "w");
  if (!f) return EXCEPTION_EXECUTE_HANDLER;
  std::fprintf(f, "exception %08lx at %p\n", ep->ExceptionRecord->ExceptionCode, ep->ExceptionRecord->ExceptionAddress);
#if defined(_M_X64)
  HANDLE proc = GetCurrentProcess(), thread = GetCurrentThread();
  SymSetOptions(SYMOPT_LOAD_LINES | SYMOPT_UNDNAME);
  SymInitialize(proc, nullptr, TRUE);
  CONTEXT ctx = *ep->ContextRecord;
  STACKFRAME64 sf = {};
  sf.AddrPC.Offset = ctx.Rip;
  sf.AddrFrame.Offset = ctx.Rbp;
  sf.AddrStack.Offset = ctx.Rsp;
  sf.AddrPC.Mode = sf.AddrFrame.Mode = sf.AddrStack.Mode = AddrModeFlat;
  alignas(SYMBOL_INFO) char buf[sizeof(SYMBOL_INFO) + 256];
  SYMBOL_INFO* sym = (SYMBOL_INFO*)buf;
  for (int i = 0; i < 40; i++) {
    if (!StackWalk64(IMAGE_FILE_MACHINE_AMD64, proc, thread, &sf, &ctx, nullptr, SymFunctionTableAccess64, SymGetModuleBase64,
                     nullptr) ||
        !sf.AddrPC.Offset)
      break;
    sym->SizeOfStruct = sizeof(SYMBOL_INFO);
    sym->MaxNameLen = 255;
    DWORD64 disp = 0;
    DWORD lineDisp = 0;
    IMAGEHLP_LINE64 line = {sizeof line};
    if (SymFromAddr(proc, sf.AddrPC.Offset, &disp, sym)) {
      bool hasLine = SymGetLineFromAddr64(proc, sf.AddrPC.Offset, &lineDisp, &line) != 0;
      std::fprintf(f, "%2d %s +0x%llx  %s:%lu\n", i, sym->Name, (unsigned long long)disp, hasLine ? line.FileName : "?",
                   hasLine ? line.LineNumber : 0);
    }
  }
#endif
  std::fclose(f);
  return EXCEPTION_EXECUTE_HANDLER;
}

static Game* g_game = nullptr;
static HWND g_hwnd = nullptr;
static Surface g_screen;
static int g_headlessWidth = 0;  // --width: fixed logical width for headless runs (0 = follow the window)
static void updateTitle(HWND hwnd);

// ---- the PC options shown in the game's own menus (patched in by tools/gow_port_patches.py)
namespace gow {

static String wide(const std::wstring& w) { return String(std::u16string(w.begin(), w.end())); }

String Port::label(int row) {
  if (row == 0) return String(u"Resolution: ") + wide(display::aspectName());
  return String(display::isFullscreen() ? u"Fullscreen: ON" : u"Fullscreen: OFF");
}

void Port::change(int row, int dir) {
  if (row == 0) display::cycleAspect(g_hwnd, dir);
  else display::toggleFullscreen(g_hwnd);
  if (g_hwnd) updateTitle(g_hwnd);
}

int Port::viewWidth() {
  int cw = 0, chh = 0;
  if (g_hwnd) {
    RECT rc;
    GetClientRect(g_hwnd, &rc);
    cw = rc.right - rc.left;
    chh = rc.bottom - rc.top;
  }
  if (g_headlessWidth > 0) {
    int w = g_headlessWidth;
    return w < 240 ? 240 : w > 853 ? 853 : w;
  }
  return display::logicalWidth(cw, chh);
}

// The Options page (menu entries 19..22: sound, erase-save link, language, header) gets two carousel entries,
// type 13 (Resolution) and 14 (Fullscreen), inserted before its header (index 22). Everything after shifts by
// two, so every stored page link (bits 8..15) at or beyond 22 is shifted too. Game.updateMenu / drawMenu handle
// the new types (patched in), and the hard-coded jump to the quit page (23) becomes 25.
Arr<int> Port::extendMenu(const Arr<int>& t) {
  const int at = 22, n = 2;
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
  for (int i = at; i < t.length(); i++) o[i + n] = shifted(t[i]);
  return o;
}

}  // namespace gow

static void gameKeyDown(int code) { if (g_game) g_game->platformKey(code, true); }
static void gameKeyUp(int code) { if (g_game) g_game->platformKey(code, false); }

static std::string narrow(const wchar_t* w) {
  char b[1024];
  WideCharToMultiByte(CP_UTF8, 0, w, -1, b, sizeof b, nullptr, nullptr);
  return b;
}

static unsigned resolveKey(WPARAM vk, LPARAM lParam) {
  if (vk == VK_SHIFT || vk == VK_CONTROL || vk == VK_MENU) return MapVirtualKeyW((UINT)((lParam >> 16) & 0xFF), MAPVK_VSC_TO_VK_EX);
  return (unsigned)vk;
}

static void updateTitle(HWND hwnd) {
  wchar_t title[128];
  swprintf(title, 128, L"God of War: Betrayal Port  [%s scaling]", display::scalingName());
  SetWindowTextW(hwnd, title);
}

static LRESULT CALLBACK WindowProc(HWND hwnd, UINT msg, WPARAM wParam, LPARAM lParam) {
  switch (msg) {
    case WM_ERASEBKGND:
      return 1;  // present() paints the bars itself
    case WM_PAINT: {
      PAINTSTRUCT ps;
      BeginPaint(hwnd, &ps);
      EndPaint(hwnd, &ps);
      display::present(hwnd, g_screen);
      return 0;
    }
    case WM_SETCURSOR:
      if (display::isFullscreen() && LOWORD(lParam) == HTCLIENT) {
        SetCursor(nullptr);
        return TRUE;
      }
      return DefWindowProcW(hwnd, msg, wParam, lParam);
    case WM_SYSKEYDOWN:
      if (wParam == VK_RETURN && (lParam & (1 << 29))) {  // Alt+Enter
        display::toggleFullscreen(hwnd);
        return 0;
      }
      return DefWindowProcW(hwnd, msg, wParam, lParam);
    case WM_KEYDOWN:
      if (wParam == VK_F11) {
        if (!(lParam & (1 << 30))) display::toggleFullscreen(hwnd);
        return 0;
      }
      if (wParam == VK_F7) {  // scaling: fit <-> integer multiples
        if (!(lParam & (1 << 30))) {
          display::cycleScaling(hwnd);
          updateTitle(hwnd);
        }
        return 0;
      }
      input::keyEvent(resolveKey(wParam, lParam), true, (lParam & (1 << 30)) != 0);
      return 0;
    case WM_KEYUP:
      input::keyEvent(resolveKey(wParam, lParam), false, false);
      return 0;
    case WM_LBUTTONDOWN: input::keyEvent(VK_LBUTTON, true, false); return 0;
    case WM_LBUTTONUP: input::keyEvent(VK_LBUTTON, false, false); return 0;
    case WM_RBUTTONDOWN: input::keyEvent(VK_RBUTTON, true, false); return 0;
    case WM_RBUTTONUP: input::keyEvent(VK_RBUTTON, false, false); return 0;
    case WM_KILLFOCUS:
      input::releaseAll();
      if (g_game) g_game->shown = false, g_game->hideNotify();
      return 0;
    case WM_SETFOCUS:
      if (g_game) g_game->shown = true, g_game->showNotify();
      return 0;
    case WM_DESTROY:
      PostQuitMessage(0);
      return 0;
  }
  return DefWindowProcW(hwnd, msg, wParam, lParam);
}

static double nowMs() {
  static LARGE_INTEGER freq = [] { LARGE_INTEGER f; QueryPerformanceFrequency(&f); return f; }();
  LARGE_INTEGER t;
  QueryPerformanceCounter(&t);
  return (double)t.QuadPart * 1000.0 / (double)freq.QuadPart;
}

int WINAPI wWinMain(HINSTANCE hInstance, HINSTANCE, PWSTR, int) {
  SetUnhandledExceptionFilter(crashHandler);
  timeBeginPeriod(1);  // Sleep() granularity is ~15 ms by default, which would make the 25 FPS pacing uneven
  std::string dump;
  int frames = 30, argc = 0, fullscreenArg = -1;
  double benchSeconds = 0;
  std::string tracePath;
  int changeFrame = -1, changeWidth = 0;  // --width-change FRAME:WIDTH (headless: switch resolution mid-run)
  struct Press { int key, frame, hold; };
  std::vector<Press> presses;
  wchar_t** argvRaw = CommandLineToArgvW(GetCommandLineW(), &argc);
  std::vector<const wchar_t*> argv(argvRaw, argvRaw + argc);
  argv.push_back(L"");  // value options at the very end read an empty string
  for (int i = 1; i < argc; i++) {
    if (!wcscmp(argv[i], L"--data")) Platform::dataDir = narrow(argv[++i]);
    else if (!wcscmp(argv[i], L"--saves")) Platform::saveDir = narrow(argv[++i]);
    else if (!wcscmp(argv[i], L"--dump")) dump = narrow(argv[++i]);
    else if (!wcscmp(argv[i], L"--frames")) frames = _wtoi(argv[++i]);
    else if (!wcscmp(argv[i], L"--trace")) tracePath = narrow(argv[++i]);
    else if (!wcscmp(argv[i], L"--bench")) benchSeconds = _wtof(argv[++i]);
    else if (!wcscmp(argv[i], L"--width")) g_headlessWidth = _wtoi(argv[++i]);
    else if (!wcscmp(argv[i], L"--width-change")) swscanf(argv[++i], L"%d:%d", &changeFrame, &changeWidth);
    else if (!wcscmp(argv[i], L"--fullscreen")) fullscreenArg = 1;
    else if (!wcscmp(argv[i], L"--windowed")) fullscreenArg = 0;
    else if (!wcscmp(argv[i], L"--press")) {
      int k = 0, f = 0, h = 3;
      swscanf(argv[++i], L"%d@%d:%d", &k, &f, &h);
      presses.push_back({k, f, h});
    }
  }

  // Default data folder: next to the exe, in ./data, or in the repo's betrayal/extracted.
  wchar_t exe[MAX_PATH];
  GetModuleFileNameW(nullptr, exe, MAX_PATH);
  std::string dir = narrow(exe);
  dir = dir.substr(0, dir.find_last_of("\\/"));
  if (Platform::dataDir == ".") {
    for (const char* rel : {"", "/data", "/../data", "/../extracted", "/../../extracted", "/../../../extracted"}) {
      std::string cand = dir + rel;
      if (GetFileAttributesA((cand + "/RP1").c_str()) != INVALID_FILE_ATTRIBUTES) {
        Platform::dataDir = cand;
        break;
      }
    }
  }
  if (Platform::saveDir == "saves") {  // survives updates, which replace the files next to the exe
    const char* local = std::getenv("LOCALAPPDATA");
    Platform::saveDir = local ? std::string(local) + "/gow-betrayal-port/saves" : dir + "/saves";
    if (local) CreateDirectoryA((std::string(local) + "/gow-betrayal-port").c_str(), nullptr);
  }
  CreateDirectoryA(Platform::saveDir.c_str(), nullptr);

  if (!dump.empty() || benchSeconds > 0) display::setPersist(false);  // tests never touch the saved settings

  GOWMIDlet* midlet = new GOWMIDlet();
  midlet->startApp();
  g_game = static_cast<Game*>(midlet->game);
  if (!g_game || !g_game->ok()) {
    MessageBoxW(nullptr, L"Could not read the game files (RP1...RP33). Point --data at the folder holding them.",
                L"God of War: Betrayal", MB_ICONERROR);
    return 1;
  }
  input::init(gameKeyDown, gameKeyUp);

  if (benchSeconds > 0) {  // the window's loop on the real clock, without the window
    double start = nowMs();
    double end = start + benchSeconds * 1000.0;
    while (nowMs() < end && !g_game->quit) {
      int sleepMs = g_game->runFrame(nowMs(), g_screen);
      if (sleepMs > 0) Sleep((DWORD)sleepMs);
    }
    double secs = (nowMs() - start) / 1000.0;
    FILE* f = std::fopen("bench.txt", "w");
    if (f) {
      std::fprintf(f, "%ld logic steps in %.2f s = %.1f steps/s (original: 25)\n", g_game->tickCount, secs, g_game->tickCount / secs);
      std::fclose(f);
    }
    return 0;
  }

  if (!dump.empty()) {  // headless test run on a fake clock
    double t = 0;
    FILE* trace = tracePath.empty() ? nullptr : std::fopen(tracePath.c_str(), "w");  // --trace FILE: per-frame player state
    for (int f = 0; f < frames; f++) {
      if (f == changeFrame) g_headlessWidth = changeWidth;
      for (const Press& p : presses) {
        if (f == p.frame) g_game->platformKey(p.key, true);
        if (f == p.frame + p.hold) g_game->platformKey(p.key, false);
      }
      g_game->runFrame(t, g_screen);
      if (trace) std::fprintf(trace, "%d action=%d anim=%d x=%d y=%d dx=%d dy=%d onGround=%d state=%d\n", f, g_game->playerAction, Game::playerAnim, g_game->playerX, g_game->playerY, g_game->animDeltaX, g_game->animDeltaY, (int)g_game->onGround, Game::state);
      t += 40;
    }
    if (trace) std::fclose(trace);
    return writeBmp(g_screen, dump.c_str()) ? 0 : 1;
  }

  display::load();
  bool fs = fullscreenArg >= 0 ? fullscreenArg == 1 : display::settings().fullscreen;
  g_hwnd = display::createWindow(hInstance, WindowProc, fs);
  if (!g_hwnd) return 1;
  updateTitle(g_hwnd);

  MSG msg;
  for (;;) {
    while (PeekMessageW(&msg, nullptr, 0, 0, PM_REMOVE)) {
      if (msg.message == WM_QUIT) return 0;
      TranslateMessage(&msg);
      DispatchMessageW(&msg);
    }
    input::poll();
    int sleepMs = g_game->runFrame(nowMs(), g_screen);
    if (g_game->quit) break;
    display::present(g_hwnd, g_screen);
    if (sleepMs > 0) Sleep((DWORD)sleepMs);
  }
  return 0;
}
