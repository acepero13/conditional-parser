package com.acepero13.research.conditionalparser.visitor;

import com.acepero13.research.conditional.ConditionalBaseVisitor;
import com.acepero13.research.conditional.ConditionalParser;
import com.acepero13.research.conditionalparser.model.Expr;
import com.acepero13.research.conditionalparser.model.OP;

import java.util.Optional;

public class ConditionalVisitor extends ConditionalBaseVisitor<Expr> {

    private Expr condition;


    @Override
    public Expr visitRelationalExpr(ConditionalParser.RelationalExprContext ctx) {

        Expr left = this.visit(ctx.expr(0));
        Expr right = this.visit(ctx.expr(1));

        switch (ctx.op.getType()) {
            case ConditionalParser.LT:
                var exprLT = Expr.relationalExpression(left, OP.LT, right);
                return this.condition = exprLT;

            case ConditionalParser.LTEQ:
                var exprLTEQ = Expr.relationalExpression(left, OP.LTEQ, right);
                return this.condition = exprLTEQ;
            case ConditionalParser.GT:
                var exprGT = Expr.relationalExpression(left, OP.GT, right);
                return this.condition = exprGT;
            case ConditionalParser.GTEQ:
                var exprGTEQ = Expr.relationalExpression(left, OP.GTEQ, right);
                return this.condition = exprGTEQ;
            default:
                throw new RuntimeException("unknown operator: " + ConditionalParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Expr visitAndExpr(ConditionalParser.AndExprContext ctx) {
        Expr left = this.visit(ctx.expr(0));
        Expr right = this.visit(ctx.expr(1));

        this.condition = Expr.andCondition(left, right);
        return this.condition;
    }

    @Override
    public Expr visitEqualityExpr(ConditionalParser.EqualityExprContext ctx) {
        Expr left = this.visit(ctx.expr(0));
        Expr right = this.visit(ctx.expr(1));

        this.condition = Expr.eq(left, right);
        return this.condition;
    }

    @Override
    public Expr visitOrExpr(ConditionalParser.OrExprContext ctx) {
        Expr left = this.visit(ctx.expr(0));
        Expr right = this.visit(ctx.expr(1));

        this.condition = Expr.orCondition(left, right);
        return this.condition;
    }

    @Override
    public Expr visitParExpr(ConditionalParser.ParExprContext ctx) {
        var expr = visit(ctx.expr());
        return expr;
    }

    @Override
    public Expr visitAction_block(ConditionalParser.Action_blockContext ctx) {
        Expr action = this.visit(ctx.expr());
        //builder.addAction(action);
        return visitChildren(ctx);
    }

    @Override
    public Expr visitEnd_block(ConditionalParser.End_blockContext ctx) {
        return visitChildren(ctx);
    }


    @Override
    public Expr visitIdAtom(ConditionalParser.IdAtomContext ctx) {
        return Expr.identifier(ctx.getText());
    }

    @Override
    public Expr visitNotExpr(ConditionalParser.NotExprContext ctx) {
        var value = visit(ctx.expr());
        return Expr.negated(value);
    }

    @Override
    public Expr visitNumberAtom(ConditionalParser.NumberAtomContext ctx) {
        return Expr.numeric(Double.valueOf(ctx.getText()));
    }

    public Optional<Expr> condition() {
        return Optional.ofNullable(condition);
    }
}
