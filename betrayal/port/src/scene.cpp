#include "scene.h"

#include <algorithm>
#include <cstdlib>

namespace gow {

namespace {
// Positions are packed as x << 17 | (y & 0x7FFF) << 2 | flags: x is a signed 15-bit value in the
// top bits, y a signed 15-bit value in bits 2..16, flags (mirror bits) in bits 0..1.
inline int packPos(int x, int y, int flags) {
  return (int)((uint32_t)x << 17) | (int)((uint32_t)((uint32_t)y << 17) >> 15) | flags;
}
inline int posX(int p) { return p >> 17; }
inline int posY(int p) { return (int16_t)(p >> 1) >> 1; }
}  // namespace

Scene::Scene(bool buf, bool noSheet, int w, int h) : buffered(buf), viewWidth(w), viewHeight(h), noTileSheet(noSheet) {
  initObjects(0);
}

// ------------------------------------------------------------- compositing
// The view (viewWidth x viewHeight at the scroll position) cut down to the Graphics clip, then drawn.
void Scene::drawViewport(Graphics* g) {
  int x = scrollX, y = scrollY;
  int sx = 0, sy = 0;
  int w = viewWidth, h = viewHeight;
  int c;
  if ((c = g->getClipX()) > 0) {
    x += c;
    w -= c;
    sx = c;
  }
  if ((c = sx + w - (c + g->getClipWidth())) > 0) w -= c;
  if ((c = g->getClipY()) > 0) {
    y += c;
    h -= c;
    sy = c;
  }
  if ((c = sy + h - (c + g->getClipHeight())) > 0) h -= c;
  if (w > 0 && h > 0) drawLayers(g, x, y, sx, sy, w, h);
}

void Scene::drawLayers(Graphics* g, int x, int y, int screenX, int screenY, int w, int h) {
  if (!objectsOnly) {
    if (!tileMap.empty()) drawTiles(g, x, y, screenX, screenY, w, h);
    if (staticCount > 0) drawStaticSprites(x, y, screenX, screenY, w, h, g);
  }
  if (objHead >= 0) drawObjects(x, y, screenX, screenY, w, h, objectsOnly, g);
}

// ---------------------------------------------------------------- tile layer
void Scene::drawTiles(Graphics* g, int x, int y, int screenX, int screenY, int w, int h) {
  int lastCol, cols = (lastCol = (x + w - 1) / tileWidth) - x / tileWidth;
  int lastRow = (y + h - 1) / tileHeight;
  int idx = lastCol + lastRow * mapCols;
  int rows = lastRow - y / tileHeight;
  x %= tileWidth;
  y %= tileHeight;
  int clipLeft = x, clipTop = y;
  int clipRight;
  if ((clipRight = -(x + w) % tileWidth) < 0) clipRight += tileWidth;
  int clipBottom;
  if ((clipBottom = -(y + h) % tileHeight) < 0) clipBottom += tileHeight;
  int dx = screenX - x + tileWidth * cols;
  int dy = screenY - y + tileHeight * rows;
  for (int r = rows; r >= 0; r--) {
    for (int c = cols; c >= 0; c--) {
      int tile;
      // port: the widened view can reach past the map edge (a level narrower than the window): draw nothing there
      int mi = idx--;
      if (mi >= 0 && mi < (int)tileMap.size() && (tile = tileMap[(size_t)mi] & 4095) > 0) {
        tile--;
        int cropL = 0, cropT = 0, cropR = 0, cropB = 0;
        if (c == 0) cropL = clipLeft;
        if (c == cols) cropR = clipRight;
        if (r == 0) cropT = clipTop;
        if (r == rows) cropB = clipBottom;
        if (!noTileSheet)
          g->drawRegion(tileSheet, tileSrcX.at((size_t)tile) + cropL, tileSrcY.at((size_t)tile) + cropT, tileWidth - cropL - cropR,
                        tileHeight - cropT - cropB, 0, dx + cropL, dy + cropT, 20);
      }
      dx -= tileWidth;
    }
    idx += 1 + cols - mapCols;
    dx += tileWidth * (cols + 1);
    dy -= tileHeight;
  }
}

void Scene::setTileMap(int cols, int rows, Image* sheet, int tw, int th) {
  clearTileMap();
  mapCols = cols;
  tileMap.assign((size_t)cols * (size_t)rows, 0);
  tileWidth = tw;
  tileHeight = th;
  int sw = sheet->w, sh = sheet->h;
  int count = sw / tileWidth * (sh / tileHeight);
  sw -= tileWidth;
  sh -= tileHeight;
  if (!noTileSheet) {
    tileSheet = sheet;
    tileSrcX.assign((size_t)count, 0);
    tileSrcY.assign((size_t)count, 0);
    int n = 0;
    for (int yy = 0; yy <= sh; yy += tileHeight)
      for (int xx = 0; xx <= sw; xx += tileWidth) {
        tileSrcX.at((size_t)n) = (uint16_t)xx;
        tileSrcY.at((size_t)n) = (uint16_t)yy;
        n++;
      }
  }
}

void Scene::clearTileMap() {
  tileMap.clear();
  if (!noTileSheet) {
    tileSheet = nullptr;
    tileSrcX.clear();
    tileSrcY.clear();
  }
}

// ------------------------------------------------------------ static sprites
void Scene::initStaticSprites(int capacity, bool byY) {
  staticCount = 0;
  staticSprites.clear();
  staticPos = Arr<int>();
  staticSortKeys = Arr<int>();
  maxStaticExtent = 0;
  staticNeedsSort = true;
  visibleScratch = Arr<int>();
  if (capacity > 0) {
    sortByY = byY;
    staticSprites.assign((size_t)capacity, nullptr);
    staticPos = Arr<int>(capacity);
    staticSortKeys = Arr<int>(capacity);
    visibleScratch = Arr<int>(capacity);
  }
}

void Scene::addStaticSprite(Sprite* s, int x, int y, int flags) {
  staticSprites.at((size_t)staticCount) = s;
  x += s->anchorOffsetX(flags);
  y += s->anchorOffsetY(flags);
  staticPos[staticCount] = packPos(x, y, flags);
  staticSortKeys[staticCount] = (int)((uint32_t)(sortByY ? y : x) << 16) | staticCount;
  maxStaticExtent = std::max(maxStaticExtent, (int)(sortByY ? s->height : s->width));
  staticCount++;
}

void Scene::drawStaticSprites(int x, int y, int screenX, int screenY, int w, int h, Graphics* g) {
  int clipX = g->getClipX(), clipY = g->getClipY(), clipW = g->getClipWidth(), clipH = g->getClipHeight();
  g->setClip(screenX, screenY, w, h);
  if (staticNeedsSort) {
    Engine::sortInts(staticSortKeys, staticCount);
    staticNeedsSort = false;
  }
  int right = w + x, bottom = h + y;
  int limit = sortByY ? bottom : right;
  int visible = 0;
  for (int i = Engine::binarySearch(staticSortKeys, staticCount - 1, (int)((uint32_t)((sortByY ? y : x) - maxStaticExtent) << 16));
       i < staticCount && (staticSortKeys[i] >> 16) < limit; i++) {
    int slot = staticSortKeys[i] & 65535;
    int p = staticPos[slot];
    int sx = posX(p), sy = posY(p);
    Sprite* s = staticSprites[(size_t)slot];
    if (sx < right && sy < bottom && x < sx + s->width && y < sy + s->height) visibleScratch[visible++] = slot;
  }
  Engine::sortInts(visibleScratch, visible);  // draw in creation order
  x -= screenX;
  y -= screenY;
  for (int i = 0; i < visible; i++) {
    int slot = visibleScratch[i];
    Sprite* s = staticSprites[(size_t)slot];
    int p = staticPos[slot];
    int flags = p & 3;
    s->draw(g, posX(p) - s->anchorOffsetX(flags) - x, posY(p) - s->anchorOffsetY(flags) - y, flags);
  }
  g->setClip(clipX, clipY, clipW, clipH);
}

// ----------------------------------------------------------- dynamic objects
void Scene::initObjects(int capacity) {
  objSprites.clear();
  objPos.clear();
  objNext.clear();
  objPrev.clear();
  objHead = objTail = objFree = -1;
  if (capacity > 0) {
    objSprites.assign((size_t)capacity, nullptr);
    objPos.assign((size_t)capacity, 0);
    objNext.assign((size_t)capacity, 0);
    for (int i = 0; i < capacity - 1; i++) objNext[(size_t)i] = (int16_t)(i + 1);
    objNext[(size_t)capacity - 1] = -1;
    objPrev.assign((size_t)capacity, 0);
    objFree = 0;
  }
}

int Scene::addObject(Sprite* s, int x, int y, int flags) {
  int slot = objFree;
  objFree = objNext.at((size_t)slot);
  if (objHead < 0) objHead = slot;
  else objNext.at((size_t)objTail) = (int16_t)slot;
  objNext[(size_t)slot] = -1;
  objPrev[(size_t)slot] = (int16_t)objTail;
  objTail = slot;
  objSprites[(size_t)slot] = s;
  x += s->anchorOffsetX(flags);
  y += s->anchorOffsetY(flags);
  objPos[(size_t)slot] = packPos(x, y, flags);
  return slot;
}

void Scene::drawObjects(int x, int y, int screenX, int screenY, int w, int h, bool onlyObjects, Graphics* g) {
  int clipX = g->getClipX(), clipY = g->getClipY(), clipW = g->getClipWidth(), clipH = g->getClipHeight();
  g->setClip(screenX, screenY, w, h);
  int cur = 0;
  if (!onlyObjects && !buffered) cur = objHead;
  int right = w + x, bottom = h + y;
  int offX = x - screenX, offY = y - screenY;
  while (cur >= 0) {
    int slot = cur;
    cur = objNext.at((size_t)cur);
    int p = objPos.at((size_t)slot);
    int ox = posX(p), oy = posY(p);
    Sprite* s = objSprites.at((size_t)slot);
    if (ox < right && oy < bottom && x < ox + s->width && y < oy + s->height) {
      int flags = p & 3;
      s->draw(g, ox - s->anchorOffsetX(flags) - offX, oy - s->anchorOffsetY(flags) - offY, flags);
    }
  }
  g->setClip(clipX, clipY, clipW, clipH);
}

}  // namespace gow
