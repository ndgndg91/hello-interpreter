#include <printf.h>
#include "common.h"
#include "vm.h"
#include "debug.h"

VM vm;

static void resetStack() {
    vm.stackTop = vm.stack;
}

void initVM() {
    resetStack();
}

void freeVM() {

}

void push(Value value) {
    *vm.stackTop = value;
    vm.stackTop++;
}

Value pop() {
    vm.stackTop--;
    return *vm.stackTop;
}

static InterpretResult run() {
#define READ_BYTE() (*vm.ip++)
#define READ_CONSTANT() (vm.chunk->constants.values[READ_BYTE()])
#define BINARY_OP(op) \
    do {              \
        double b = pop(); \
        double a = pop(); \
        push(a op b);      \
    } while(false)

    // 모든 명령어를 순차로 하나씩 실행 - decoding 또는 dispatch
    for (;;) {
#ifdef DEBUG_TRACE_EXECUTION
        printf("        ");
        for (Value* slot = vm.stack; slot < vm.stackTop; slot++) {
            printf("[  ");
            printValue(*slot);
            printf("  ]");
        }
        printf("\n");
        disassembleInstruction(vm.chunk, (int)(vm.ip - vm.chunk->code));
#endif
        uint8_t instruction;
        switch (instruction = READ_BYTE()) {
            case OP_CONSTANT: {
                Value constant = READ_CONSTANT();
                printValue(constant);
                push(constant);
                break;
            }
            case OP_ADD: {
                BINARY_OP(+);
                break;
            }
            case OP_SUBTRACT: {
                BINARY_OP(-);
                break;
            }
            case OP_MULTIPLY: {
                BINARY_OP(*);
                break;
            }
            case OP_DIVIDE: {
                BINARY_OP(/);
                break;
            }
            case OP_NEGATIVE: {
                push(-pop());
                break;
            }
            case OP_RETURN:{
                printValue(pop());
                printf("\n");
                return INTERPRET_OK;
            }
        }
    }

#undef READ_BYTE
#undef READ_CONSTANT
#undef BINARY_OP
}

InterpretResult interpret(Chunk* chunk) {
    vm.chunk = chunk; // 실행 중인 chunk 를 vm 에 저장.
    vm.ip = vm.chunk->code; // 현재 실행 중인 명령어의 위치를 ip 에 보관. instruction pointer (JVM program counter = pc )
    return run(); // 바이트코드 명령어를 실행하는 내부 헬퍼 함수 호출.
}