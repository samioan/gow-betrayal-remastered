cmake_minimum_required(VERSION 3.20)
project(gow_android CXX C)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# Chemin vers le dossier betrayal/port du dépôt
set(PORT_DIR "${CMAKE_CURRENT_SOURCE_DIR}/../../../../../betrayal/port")

# 1. SDL2
set(SDL_SHARED ON CACHE BOOL "" FORCE)
set(SDL_STATIC OFF CACHE BOOL "" FORCE)
set(SDL_TEST OFF CACHE BOOL "" FORCE)
add_subdirectory(SDL2 EXCLUDE_FROM_ALL)

# 2. stb_image (décodage PNG utilisé par Engine::loadImage)
add_library(stb_image STATIC "${PORT_DIR}/third_party/stb/stb_image_impl.cpp")
target_include_directories(stb_image PUBLIC "${PORT_DIR}/third_party/stb")

# 3. Code généré du jeu (Game.cpp, GOWMIDlet.cpp, SoundPlayer.cpp) + Moteur C++
file(GLOB GEN_SRC CONFIGURE_DEPENDS "${PORT_DIR}/src/gen/*.cpp")

add_library(main SHARED
    main_android.cpp
    platform_android.cpp
    "${PORT_DIR}/src/engine.cpp"
    "${PORT_DIR}/src/scene.cpp"
    "${PORT_DIR}/src/gfx.cpp"
    "${PORT_DIR}/src/jrt.cpp"
    ${GEN_SRC}
)

target_include_directories(main PRIVATE "${PORT_DIR}/src")
target_link_libraries(main PRIVATE SDL2 stb_image log)
