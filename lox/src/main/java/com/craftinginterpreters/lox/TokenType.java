package com.craftinginterpreters.lox;

enum TokenType {
    // 단일 문자 토큰
    LEFT_PAREN("("), RIGHT_PAREN(")"), LEFT_BRACE("{"), RIGHT_BRACE("}"),
    COMMA(","), DOT("."), MINUS("-"), PLUS("+"), SEMICOLON(";"), SLASH("/"), STAR("*"),

    // 문자 1개 또는 2개짜리 토큰
    BANG("!"), BANG_EQUAL("!="),
    EQUAL("="), EQUAL_EQUAL("=="),
    GREATER(">"), GREATER_EQUAL(">="),
    LESS("<"), LESS_EQUAL("<="),

    // 리터럴
    IDENTIFIER(null), STRING(null), NUMBER(null),

    // 키워드
    AND("&&"), CLASS("class"), ELSE("else"), FALSE("false"), FUN("fun"), FOR("for"), IF("if"), NIL("nil"), OR("||"),
    PRINT("print"), RETURN("return"), SUPER("super"), THIS("this"), TRUE("true"), VAR("var"), WHILE("while"),

    EOF(null);

    TokenType(String notation) {}
}
