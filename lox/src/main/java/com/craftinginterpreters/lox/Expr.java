package com.craftinginterpreters.lox;

abstract class Expr {

    abstract <T> String accept(Visitor<T> visitor);
    public interface Visitor<T> {
        T visitBinaryExpr(Expr.Binary expr);
        T visitGroupingExpr(Expr.Grouping expr);
        T visitLiteralExpr(Expr.Literal expr);
        T visitUnaryExpr(Expr.Unary expr);

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
            return visitor.visitBinaryExpr(this).toString();
        }
    }

    static class Grouping extends Expr {
        final Expr expression;
        public Grouping(Expr expression) {
            this.expression = expression;
        }

        @Override
        <T> String accept(Visitor<T> visitor) {
            return visitor.visitGroupingExpr(this).toString();
        }
    }

    static class Literal extends Expr {
        final Object value;

        public Literal(Object value) {
            this.value = value;
        }

        @Override
        <T> String accept(Visitor<T> visitor) {
            return visitor.visitLiteralExpr(this).toString();
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
            return visitor.visitUnaryExpr(this).toString();
        }
    }
}
