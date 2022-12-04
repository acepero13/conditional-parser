package com.acepero13.research.conditionalparser.visitor;

import com.acepero13.research.conditional.ConditionalLexer;
import com.acepero13.research.conditional.ConditionalParser;
import com.acepero13.research.conditionalparser.model.Expr;
import com.acepero13.research.conditionalparser.model.OP;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.fail;

class ConditionalListenerTest {

    /**
     * Expr -> (AndExpr, NumericExpr, IdentifierExpr,  RelationalExpr,  OrExpr)
     * AndExpr(...Expr)
     * AndExpr()
     */

    // TODOS:
    //1. (a > b) - OK
    //2. ((a > b) && (c > b)) - OK
    //3. (a || b) - OK
    //4. (a && b) - OK
    //5. (a == 1 && b == 2) - OK
    //6. (a <= b) - OK
    //7. (a >= b) - OK
    //8. (!a || !b) -OK
    //9. (!(a > b) && (c > b))
    //7. ((a > b) && (c > b) || (d > f))

    /**
     * RelationalExpr(a, >, b)
     * AndExpr((RelationalExpr(a, >, b)), RelationalExpr(c, >, b)) -> ComplexAndExpr(ConditionalExpr, ConditionalExpr)
     * OrExpr(a, b)
     * AndExpr(a, b) -> AndExpr(Expr, Expr)
     * OrExpr(AndExpr, RelationalExpr)
     */
    @Test
    @DisplayName("if (a > 0) then b ;")
    void parseSimpleCondition() {

        final String simpleCondition = "if (a > 0) then b ;";
        ConditionalVisitor visitor = createVisitor(simpleCondition);

        var actualConditionOp = visitor.condition();
        var expected = Expr.relationalExpression(Expr.identifier("a"), OP.GT, Expr.numeric(0.0));
        if (actualConditionOp.isEmpty()) {
            fail("");
        }
        assertThat(actualConditionOp.get(), equalTo(expected));
    }

    @Test
    @DisplayName("if (a <= 0) then b ;")
    void parseLessEqual() {

        final String simpleCondition = "if (a <= 0) then b ;";
        ConditionalVisitor visitor = createVisitor(simpleCondition);

        var actualConditionOp = visitor.condition();
        var expected = Expr.relationalExpression(Expr.identifier("a"), OP.LTEQ, Expr.numeric(0.0));
        if (actualConditionOp.isEmpty()) {
            fail("");
        }
        assertThat(actualConditionOp.get(), equalTo(expected));
    }

    @Test
    @DisplayName("if (a >= 0) then b ;")
    void parseGreaterEqual() {

        final String simpleCondition = "if (a >= 0) then b ;";
        ConditionalVisitor visitor = createVisitor(simpleCondition);

        var actualConditionOp = visitor.condition();
        var expected = Expr.relationalExpression(Expr.identifier("a"), OP.GTEQ, Expr.numeric(0.0));
        if (actualConditionOp.isEmpty()) {
            fail("");
        }
        assertThat(actualConditionOp.get(), equalTo(expected));
    }

    @Test
    @DisplayName("if ((a > b) && (c > b)) then b ;")
    void parseAndConditionWithTwoExpressions() {
        final String simpleCondition = "if ((a > b) && (c < b)) then b ;";
        ConditionalVisitor visitor = createVisitor(simpleCondition);

        var actualConditionOp = visitor.condition();

        var aGTb = Expr.relationalExpression(Expr.identifier("a"), OP.GT, Expr.identifier("b"));
        var cLTb = Expr.relationalExpression(Expr.identifier("c"), OP.LT, Expr.identifier("b"));
        var expected = Expr.andCondition(aGTb, cLTb);

        /**
         * Builder
         *  .of(Expr.relationalExpression(Expr.identifier("a"), OP.GT, Expr.identifier("b")))
         *  .and(Expr.relationalExpression(Expr.identifier("c"), OP.LT, Expr.identifier("b")));
         */

        if (actualConditionOp.isEmpty()) {
            fail("");
        }
        assertThat(actualConditionOp.get(), equalTo(expected));
    }

    @Test
    @DisplayName("if (!(a > b) && (c > b))  then b ;")
    void parseAndConditionWithTwoExpressionsOneNegated() {
        final String simpleCondition = "if (!(a > b) && (c < b)) then b ;";
        ConditionalVisitor visitor = createVisitor(simpleCondition);

        var actualConditionOp = visitor.condition();
        var aGTb = Expr.relationalExpression(Expr.identifier("a"), OP.GT, Expr.identifier("b"));
        var cLTb = Expr.relationalExpression(Expr.identifier("c"), OP.LT, Expr.identifier("b"));
        if (actualConditionOp.isEmpty()) {
            fail("");
        }
        var expected = Expr.andCondition(Expr.negated(aGTb), cLTb);
        assertThat(actualConditionOp.get(), equalTo(expected));
    }

    @Test
    @DisplayName("if (a || b) then c;")
    void parseSimpleOr() {
        final String simpleCondition = "if (a || b) then c ;";
        ConditionalVisitor visitor = createVisitor(simpleCondition);

        var actualConditionOp = visitor.condition();
        var expected = Expr.orCondition(Expr.identifier("a"), Expr.identifier("b"));
        if (actualConditionOp.isEmpty()) {
            fail("");
        }
        assertThat(actualConditionOp.get(), equalTo(expected));
    }

    //

    @Test
    @DisplayName("if (!a || !b) then c")
    void parseNegatedSimpleOr() {
        final String simpleCondition = "if (!a || !b) then c ;";
        ConditionalVisitor visitor = createVisitor(simpleCondition);

        var actualConditionOp = visitor.condition();
        var expected = Expr.orCondition(Expr.negated("a"), Expr.negated("b"));
        if (actualConditionOp.isEmpty()) {
            fail("");
        }
        assertThat(actualConditionOp.get(), equalTo(expected));
    }

    @Test
    @DisplayName("if(a && b) then c")
    void parseSimpleAnd() {
        final String simpleCondition = "if (a && b) then c ;";
        ConditionalVisitor visitor = createVisitor(simpleCondition);

        var actualConditionOp = visitor.condition();
        var expected = Expr.andCondition(Expr.identifier("a"), Expr.identifier("b"));
        if (actualConditionOp.isEmpty()) {
            fail("");
        }
        assertThat(actualConditionOp.get(), equalTo(expected));
    }


    @Test
    @DisplayName("if (a == 1 && b == 2) then c")
    void parseComparisonAnd() {
        final String simpleCondition = "if (a == 1 && b == 2) then c ;";
        ConditionalVisitor visitor = createVisitor(simpleCondition);

        var actualConditionOp = visitor.condition();
        var firstStm = Expr.eq(Expr.identifier("a"), Expr.numeric(1));
        var secondStm = Expr.eq(Expr.identifier("b"), Expr.numeric(2));
        var expected = Expr.andCondition(firstStm, secondStm);
        if (actualConditionOp.isEmpty()) {
            fail("");
        }
        assertThat(actualConditionOp.get(), equalTo(expected));
    }

    private static ConditionalVisitor createVisitor(String simpleCondition) {
        ConditionalLexer lexer = new ConditionalLexer(CharStreams.fromString(simpleCondition));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        ConditionalParser parser = new ConditionalParser(tokens);

        var res = parser.if_stat();

        var visitor = new ConditionalVisitor();
        visitor.visitIf_stat(res);
        return visitor;
    }


//

}