package com.acepero13.research.conditionalparser.model.exporter;

import com.acepero13.research.conditionalparser.model.Expr;
import com.acepero13.research.conditionalparser.visitor.exceptions.ParserException;

public interface Exportable {
    <A> A and(Expr.AndExpr expr);

    <B> B or(Expr.OrExpr expr);

    <C> C negation(Expr.NegationExpr expr);

    <D> D numeric(Expr.NumericExpr expr);

    <E> E identifier(Expr.IdentifierExpr expr);

    <F> F eq(Expr.EqualityExpr expr);

    <G> G relational(Expr.RelationalExpr expr);

    <H> H action(Expr.Action expr);

    default <Y> Y export(Expr expr) {
        if (expr instanceof Expr.AndExpr) {
            return and((Expr.AndExpr) expr);
        } else if (expr instanceof Expr.OrExpr) {
            return or((Expr.OrExpr) expr);
        } else if (expr instanceof Expr.NegationExpr) {
            return negation((Expr.NegationExpr) expr);
        } else if (expr instanceof Expr.NumericExpr) {
            return numeric((Expr.NumericExpr) expr);
        } else if (expr instanceof Expr.IdentifierExpr) {
            return identifier((Expr.IdentifierExpr) expr);
        } else if (expr instanceof Expr.RelationalExpr) {
            return relational((Expr.RelationalExpr) expr);
        } else if (expr instanceof Expr.Action) {
            return action((Expr.Action) expr);
        }
        throw new ParserException("Cannot parse expression: " + expr);
    }
}


