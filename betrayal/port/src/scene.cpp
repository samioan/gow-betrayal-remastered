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

Scene::Scene(bool buf, bool noSheet, int w, int h) : buffered(buf), bufferWidth(w), bufferHeight(h), noTileSheet(noSheet) {
  if (buf) buffer = new Surface(w, h);
  initObjects(0);
}

void Scene::setBufferWidth(int w) {
  if (w == bufferWidth || !buffered) return;
  bufferWidth = w;
  delete buffer;
  buffer = new Surface(w, bufferHeight);
  fullRedraw = true;
  visibleCount = 0;
}

// ------------------------------------------------------------- compositing
void Scene::renderAndBlit(Graphics* g) {
  updateBuffer();
  blitWrapped(g);
}

// Copies the ring buffer to the screen: the scroll position splits it into up to four rectangles.
void Scene::blitWrapped(Graphics* g) {
  int sx = scrollX % bufferWidth;
  int sy = scrollY % bufferHeight;
  auto blit = [&](int x, int y, int w, int h, int dx, int dy) { g->drawRegion(buffer, x, y, w, h, 0, dx, dy, 20); };
  if (sx == 0) {
    if (sy == 0) {
      blit(0, 0, bufferWidth, bufferHeight, 0, 0);
    } else {
      int h1 = bufferHeight - sy;
      blit(0, sy, bufferWidth, h1, 0, 0);
      blit(0, 0, bufferWidth, sy, 0, h1);
    }
  } else if (sy == 0) {
    int w1 = bufferWidth - sx;
    blit(sx, 0, w1, bufferHeight, 0, 0);
    blit(0, 0, sx, bufferHeight, w1, 0);
  } else {
    int h1 = bufferHeight - sy, w1 = bufferWidth - sx;
    blit(sx, sy, w1, h1, 0, 0);
    blit(0, sy, sx, h1, w1, 0);
    blit(sx, 0, w1, sy, 0, h1);
    blit(0, 0, sx, sy, w1, h1);
  }
}

// Objects from `start` along the linked list that intersect the visible window.
void Scene::collectVisibleObjects(int start) {
  int right = scrollX + bufferWidth, bottom = scrollY + bufferHeight;
  while (start >= 0) {
    int p = objPos.at((size_t)start);
    int x = posX(p), y = posY(p);
    Sprite* s = objSprites.at((size_t)start);
    if (x < right && y < bottom && scrollX < x + s->width && scrollY < y + s->height) {
      if (visibleCount >= (int)visibleObjs.size()) throw JavaException{"ArrayIndexOutOfBounds"};
      visibleObjs[(size_t)visibleCount++] = (uint16_t)start;
    }
    start = objNext.at((size_t)start);
  }
}

// Brings the ring buffer up to date with the scroll position.
void Scene::updateBuffer() {
  int first = objFirstDirty;
  if (objFirstDirty >= 0) {
    if (!fullRedraw) {  // new objects: draw just them over the existing background
      objectsOnly = true;
      redrawRegion(renderedX, renderedY, bufferWidth, bufferHeight);
      objectsOnly = false;
    }
    objFirstDirty = -1;
  }
  if (fullRedraw) {
    fullRedraw = false;
    renderedX = scrollX - bufferWidth;  // forces a complete redraw below
    renderedY = scrollY - bufferHeight;
  }
  if (renderedX == scrollX && renderedY == scrollY) {
    collectVisibleObjects(first);
    return;
  }
  int x = scrollX;
  int w = std::min(bufferWidth, std::abs(renderedX - scrollX));
  if (renderedX < scrollX) x += bufferWidth - w;
  renderedX = scrollX;
  int y = scrollY;
  int h = std::min(bufferHeight, std::abs(renderedY - scrollY));
  if (renderedY < scrollY) y += bufferHeight - h;
  renderedY = scrollY;
  visibleCount = 0;
  collectVisibleObjects(objHead);
  if (w == bufferWidth && h == bufferHeight) {
    redrawRegion(scrollX, scrollY, w, h);
  } else {
    if (w > 0) redrawRegion(x, scrollY, w, bufferHeight);
    if (h > 0) redrawRegion(scrollX, y, bufferWidth, h);
  }
}

// Redraws a world-space rectangle into the ring buffer, splitting it where it wraps.
void Scene::redrawRegion(int x, int y, int w, int h) {
  int bx = x % bufferWidth;
  int by = y % bufferHeight;
  int overX = bx + w - bufferWidth;
  int overY = by + h - bufferHeight;
  Graphics* g = buffer;
  if (overX <= 0) {
    if (overY <= 0) {
      redrawRect(g, x, y, bx, by, w, h);
    } else {
      h -= overY;
      redrawRect(g, x, y, bx, by, w, h);
      y += h;
      redrawRect(g, x, y, bx, 0, w, overY);
    }
  } else {
    w -= overX;
    if (overY <= 0) {
      redrawRect(g, x, y, bx, by, w, h);
      x += w;
      redrawRect(g, x, y, 0, by, overX, h);
    } else {
      h -= overY;
      redrawRect(g, x, y, bx, by, w, h);
      y += h;
      redrawRect(g, x, y, bx, 0, w, overY);
      x += w;
      redrawRect(g, x, y, 0, 0, overX, overY);
      y -= h;
      redrawRect(g, x, y, 0, by, overX, h);
    }
  }
}

void Scene::redrawRect(Graphics* g, int x, int y, int bufX, int bufY, int w, int h) {
  if (!objectsOnly) {
    if (!tileMap.empty()) drawTiles(g, x, y, bufX, bufY, w, h);
    if (staticCount > 0) drawStaticSprites(x, y, bufX, bufY, w, h, g);
  }
  if (objHead >= 0) drawObjects(x, y, bufX, bufY, w, h, objectsOnly, g);
}

// ---------------------------------------------------------------- tile layer
void Scene::drawTiles(Graphics* g, int x, int y, int bufX, int bufY, int w, int h) {
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
  int dx = bufX - x + tileWidth * cols;
  int dy = bufY - y + tileHeight * rows;
  for (int r = rows; r >= 0; r--) {
    for (int c = cols; c >= 0; c--) {
      int tile;
      if ((tile = tileMap.at((size_t)idx--) & 4095) > 0) {
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
  fullRedraw = true;
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

void Scene::drawStaticSprites(int x, int y, int bufX, int bufY, int w, int h, Graphics* g) {
  int clipX = g->getClipX(), clipY = g->getClipY(), clipW = g->getClipWidth(), clipH = g->getClipHeight();
  g->setClip(bufX, bufY, w, h);
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
  x -= bufX;
  y -= bufY;
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
  fullRedraw = true;
  objFirstDirty = -1;
  visibleObjs.clear();
  visibleCount = 0;
  if (capacity > 0) {
    objSprites.assign((size_t)capacity, nullptr);
    objPos.assign((size_t)capacity, 0);
    objNext.assign((size_t)capacity, 0);
    for (int i = 0; i < capacity - 1; i++) objNext[(size_t)i] = (int16_t)(i + 1);
    objNext[(size_t)capacity - 1] = -1;
    objPrev.assign((size_t)capacity, 0);
    objFree = 0;
    if (buffered) visibleObjs.assign((size_t)capacity, 0);
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
  if (objFirstDirty < 0) objFirstDirty = slot;
  objSprites[(size_t)slot] = s;
  x += s->anchorOffsetX(flags);
  y += s->anchorOffsetY(flags);
  objPos[(size_t)slot] = packPos(x, y, flags);
  return slot;
}

void Scene::drawObjects(int x, int y, int bufX, int bufY, int w, int h, bool onlyDirty, Graphics* g) {
  int clipX = g->getClipX(), clipY = g->getClipY(), clipW = g->getClipWidth(), clipH = g->getClipHeight();
  g->setClip(bufX, bufY, w, h);
  int cur = 0;
  bool fromVisible = false;
  if (onlyDirty) cur = objFirstDirty;
  else if (buffered) fromVisible = true;
  int right = w + x, bottom = h + y;
  int offX = x - bufX, offY = y - bufY;
  for (;;) {
    int slot;
    if (fromVisible) {
      if (cur == visibleCount) break;
      slot = visibleObjs.at((size_t)cur++);
    } else {
      if (cur < 0) break;
      slot = cur;
      cur = objNext.at((size_t)cur);
    }
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
