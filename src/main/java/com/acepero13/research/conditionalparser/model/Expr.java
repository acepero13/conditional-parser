package com.acepero13.research.conditionalparser.model;


import lombok.Data;

public interface Expr {

    static Expr relationalExpression(Expr left, OP operator, Expr right) {
        return new RelationalExpr(left, operator, right);
    }

    static Expr identifier(String value) {
        return new IdentifierExpr(value);
    }

    static Expr numeric(Double value) {
        return new NumericExpr(value);
    }

    static Expr andCondition(Expr left, Expr right) {
        return new AndExpr(left, right);
    }

    static Expr orCondition(Expr left, Expr right) {
        return new OrExpr(left, right);
    }

    static Expr eq(Expr left, Expr value) {
        return new EqualityExpr(left, value);
    }

    static Expr numeric(int value) {
        return numeric(Double.valueOf(value));
    }

    static Expr negated(Expr value) {
        return new NegationExpr(value);
    }

    static Expr negated(String value) {
        return negated(identifier(value));
    }

    static Expr action(String label, Expr value) {
        return new Action(label, value);
    }

    @Data
    class Action implements Expr {
        private final String className;
        private final Expr value;
    }

    @Data
    class AndExpr implements Expr {
        private final Expr left;
        private final Expr right;
    }

    @Data
    class NegationExpr implements Expr {
        private final Expr value;
    }

    @Data
    class OrExpr implements Expr {
        private final Expr left;
        private final Expr right;
    }

    @Data
    class NumericExpr implements Expr {
        private final double value;
    }

    @Data
    class IdentifierExpr implements Expr {
        private final String value;
    }

    @Data
    class EqualityExpr implements Expr {
        private final Expr left;
        private final Expr right;
    }

    @Data
    class RelationalExpr implements Expr {
        private final Expr left;
        private final OP operator;
        private final Expr right;
    }

}
