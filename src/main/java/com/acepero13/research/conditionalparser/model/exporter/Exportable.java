package com.acepero13.research.conditionalparser.model.exporter;

import com.acepero13.research.conditionalparser.model.Expr;

public interface Exportable {
    <A> A and(Expr.AndExpr expr);

    <B> B or(Expr.OrExpr expr);

    <C> C negation(Expr.NegationExpr expr);

    <D> D numeric(Expr.NumericExpr expr);

    <E> E identifier(Expr.IdentifierExpr expr);

    <F> F eq(Expr.EqualityExpr expr);

    <G> G relational(Expr.RelationalExpr expr);
}
