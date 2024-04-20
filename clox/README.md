# CLox

- bytecode format 에서 각 명령어는 1byte 오퍼레이션 코드(operation code), 줄여서 옵코드(opcode) 로 구성
- 값을 나타내는 비트가 옵코드 바로 뒤에 나오는 명령어 즉시 명렁어(immediate instruction) 이라 한다.
- 트라이(trie) 상태 기계를 통한 렉시컬 분석
  - 결정적 유한 자동화 (DFA, Deterministic Finite Automation)
  - 유한 상태 기계 finite state machine
  - switch 문을 통한 구현
  - 렉스 대안

## Scanner

## Compiler

## VM



- 하향식 연산자 우선순위 파싱 (top-down operator precedence parsing)

## Variable
- Bucket Array
- Resolve Collision
  - Load Factor
  - Open Addressing
- Hash Function
- Hash Table
- String Interning