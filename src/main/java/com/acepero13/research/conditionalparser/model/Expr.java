package com.acepero13.research.conditionalparser.model;


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


    record AndExpr(Expr left, Expr right) implements Expr {
    }

    record NegationExpr(Expr value) implements Expr {
    }

    record OrExpr(Expr left, Expr right) implements Expr {
    }

    record NumericExpr(double value) implements Expr {
    }

    record IdentifierExpr(String value) implements Expr {
    }

    record EqualityExpr(Expr left, Expr right) implements Expr {

    }

    record RelationalExpr(Expr left, OP operator, Expr right) implements Expr {

    }

}
