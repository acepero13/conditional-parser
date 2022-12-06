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
        if (expr instanceof Expr.AndExpr andExpr) {
            return and(andExpr);
        } else if (expr instanceof Expr.OrExpr orExpr) {
            return or(orExpr);
        } else if (expr instanceof Expr.NegationExpr negationExpr) {
            return negation(negationExpr);
        } else if (expr instanceof Expr.NumericExpr numericExpr) {
            return numeric(numericExpr);
        } else if (expr instanceof Expr.IdentifierExpr identifierExpr) {
            return identifier(identifierExpr);
        } else if (expr instanceof Expr.RelationalExpr relationalExpr) {
            return relational(relationalExpr);
        } else if (expr instanceof Expr.Action actionExpr) {
            return action(actionExpr);
        }
        throw new ParserException("Cannot parse expression: " + expr);
    }
}


