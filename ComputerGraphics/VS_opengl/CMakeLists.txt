cmake_minimum_required(VERSION 3.12)

project(CG_aulas)

add_executable(CG_aulas main.cpp "Vectors.cpp" "matrizes.cpp")

target_include_directories(CG_aulas PRIVATE deps/glm deps/std deps/glfw/include deps/glew/include)

target_link_directories(CG_aulas PRIVATE deps/glfw/lib-vc2019 deps/glew/lib/Release/x64)

target_link_libraries(CG_aulas PRIVATE glfw3.lib glew.32.lib openg132.lib)

add_custom_command(TARGET CG_aulas POST_BUILD 

COMMAND ${CMAKE_COMMAND} -E copy "${CMAKE_SOURCE_DIR}/deps/glew/bin/Release/x64/glew32.dll"
"${CMAKE_BINARY_DIR}/glew32.dll")

add_executable(Vectors Vectors.cpp "matrizes.cpp")
target_include_directories(Vectors PRIVATE deps/glm)

add_executable(Matrizes "matrizes.cpp")
target_include_directories(Matrizes PRIVATE deps/glm)
