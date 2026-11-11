// Port of Scene.java (betrayal/src/Scene.java, class `b` of the K800i build): the scrolling world renderer.
// Draws straight to the screen every frame (no offscreen buffer): the view rectangle is intersected with the
// Graphics clip, then three layers are drawn in order: a tile map, sorted static sprites, and a linked list of
// dynamic objects. Game owns two: the level (`scene`) and its parallax background (`bgScene`).
// See docs/CLASS_MAP.md, "Scene (b)".
#pragma once
#include <vector>

#include "engine.h"

namespace gow {

class Scene {
 public:
  static Scene* create(int w, int h) { return new Scene(false, false, w, h); }

  void setScroll(int x, int y) { scrollX = x; scrollY = y; }
  // Port addition (see tools/rename_gow.py / gow_port_patches.py): the visible width follows the window's
  // logical width.
  void setViewWidth(int w) { viewWidth = w; }
  void draw(Graphics* g) { if (!buffered) drawViewport(g); }
  void setTileMap(int cols, int rows, Image* sheet, int tw, int th);
  void setTile(int x, int y, int tile) { tileMap.at((size_t)(y * mapCols + x)) = (int16_t)tile; }
  void initStaticSprites(int capacity, bool sortByY);
  void addStaticSprite(Sprite* s, int x, int y, int flags);
  void initObjects(int capacity);
  int addObject(Sprite* s, int x, int y, int flags);

 private:
  Scene(bool buffered, bool noTileSheet, int w, int h);
  bool buffered;  // always false in this build (create passes false); the buffer is never made
  int viewWidth, viewHeight;
  int scrollX = 0, scrollY = 0;
  int mapCols = 0;
  std::vector<int16_t> tileMap;
  bool noTileSheet;
  Image* tileSheet = nullptr;
  std::vector<uint16_t> tileSrcX, tileSrcY;
  int tileWidth = 0, tileHeight = 0;
  // static sprites
  int staticCount = 0;
  std::vector<Sprite*> staticSprites;
  Arr<int> staticPos, staticSortKeys, visibleScratch;
  int maxStaticExtent = 0;
  bool staticNeedsSort = true, sortByY = false;
  // dynamic objects (linked list in fixed slots)
  std::vector<Sprite*> objSprites;
  std::vector<int> objPos;
  std::vector<int16_t> objNext, objPrev;
  int objHead = -1, objTail = -1, objFree = -1;
  bool objectsOnly = false;  // never set in this build

  void drawViewport(Graphics* g);
  void drawLayers(Graphics* g, int x, int y, int screenX, int screenY, int w, int h);
  void drawTiles(Graphics* g, int x, int y, int screenX, int screenY, int w, int h);
  void clearTileMap();
  void drawStaticSprites(int x, int y, int screenX, int screenY, int w, int h, Graphics* g);
  void drawObjects(int x, int y, int screenX, int screenY, int w, int h, bool onlyObjects, Graphics* g);
};

}  // namespace gow
