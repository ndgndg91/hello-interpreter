cmake_minimum_required(VERSION 3.28)
project(hello_interpreter C)

set(CMAKE_C_STANDARD 11)

include_directories(clox)

add_executable(hello_interpreter
        clox/chunk.c
        clox/chunk.h
        clox/common.h
        clox/main.c
        clox/memory.c
        clox/memory.h
        clox/debug.h
        clox/debug.c
        clox/debug.c
        clox/value.h
        clox/value.c)
