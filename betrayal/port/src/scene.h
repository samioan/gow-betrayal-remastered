// Port of Scene.java (betrayal/src/Scene.java, old class `b`): the scrolling world renderer.
// A 240x320 offscreen ring buffer holds the visible part of the level; scrolling redraws only the
// strips that came into view (wrapping around the buffer edges) and the buffer is copied to the
// screen in up to four pieces. Layers, drawn in order: a tile map, sorted static sprites, and a
// linked list of dynamic objects. See docs/CLASS_MAP.md, "Scene (b)".
#pragma once
#include <vector>

#include "engine.h"

namespace gow {

class Scene {
 public:
  static Scene* create(int w, int h) { return new Scene(true, false, w, h); }

  void setScroll(int x, int y) { scrollX = x; scrollY = y; }
  // Port addition (see tools/gow_port_patches.py): the visible width follows the window's logical width.
  // The ring buffer is reallocated and everything is redrawn on the next frame.
  void setBufferWidth(int w);
  void draw(Graphics* g) { if (buffered) renderAndBlit(g); }
  void setTileMap(int cols, int rows, Image* sheet, int tw, int th);
  void setTile(int x, int y, int tile) { tileMap.at((size_t)(y * mapCols + x)) = (int16_t)tile; fullRedraw = true; }
  void initStaticSprites(int capacity, bool sortByY);
  void addStaticSprite(Sprite* s, int x, int y, int flags);
  void initObjects(int capacity);
  int addObject(Sprite* s, int x, int y, int flags);

 private:
  Scene(bool buffered, bool noTileSheet, int w, int h);
  bool buffered;
  int bufferWidth, bufferHeight;
  int scrollX = 0, scrollY = 0;
  Surface* buffer = nullptr;
  int renderedX = 0, renderedY = 0;
  bool fullRedraw = false;
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
  int objHead = -1, objTail = -1, objFree = -1, objFirstDirty = -1;
  std::vector<uint16_t> visibleObjs;
  int visibleCount = 0;
  bool objectsOnly = false;

  void renderAndBlit(Graphics* g);
  void blitWrapped(Graphics* g);
  void collectVisibleObjects(int start);
  void updateBuffer();
  void redrawRegion(int x, int y, int w, int h);
  void redrawRect(Graphics* g, int x, int y, int bufX, int bufY, int w, int h);
  void drawTiles(Graphics* g, int x, int y, int bufX, int bufY, int w, int h);
  void clearTileMap();
  void drawStaticSprites(int x, int y, int bufX, int bufY, int w, int h, Graphics* g);
  void drawObjects(int x, int y, int bufX, int bufY, int w, int h, bool onlyDirty, Graphics* g);
};

}  // namespace gow
