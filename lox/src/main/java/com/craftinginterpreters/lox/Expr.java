package com.craftinginterpreters.lox;

abstract class Expr {

    abstract <T> String accept(Visitor<T> visitor);
    public interface Visitor<T> {
        String visitBinaryExpr(Expr.Binary expr);
        String visitGroupingExpr(Expr.Grouping expr);
        String visitLiteralExpr(Expr.Literal expr);
        String visitUnaryExpr(Expr.Unary expr);

    }

    static class Binary extends  Expr {
        final Expr left;
        final  Token operator;
        final Expr right;
        Binary(Expr left,  Token operator, Expr right) {
            this.left = left;
            this.operator = operator;
            this.right = right;
        }

        @Override
        <T> String accept(Visitor<T> visitor) {
            return visitor.visitBinaryExpr(this);
        }
    }

    static class Grouping extends Expr {
        final Expr expression;
        public Grouping(Expr expression) {
            this.expression = expression;
        }

        @Override
        <T> String accept(Visitor<T> visitor) {
            return visitor.visitGroupingExpr(this);
        }
    }

    static class Literal extends Expr {
        final Object value;

        public Literal(Object value) {
            this.value = value;
        }

        @Override
        <T> String accept(Visitor<T> visitor) {
            return visitor.visitLiteralExpr(this);
        }
    }

    static class Unary extends Expr {
        final Token operator;
        final Expr right;
        public Unary(Token operator, Expr right) {
            this.operator = operator;
            this.right = right;
        }

        @Override
        <T> String accept(Visitor<T> visitor) {
            return visitor.visitUnaryExpr(this);
        }
    }
}
