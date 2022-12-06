package com.acepero13.research.conditionalparser.visitor;

import com.acepero13.research.conditionalparser.model.Expr;
import com.acepero13.research.conditionalparser.model.IfThen;
import com.acepero13.research.conditionalparser.model.OP;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.fail;

class ConditionalVisitorTest {


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


    @Test
    @DisplayName("if (a > 0) then b ;")
    void parseSimpleCondition() {

        final String simpleCondition = "if (a > 0) then b ;";


        var actualCondition = parse(simpleCondition);
        var expected = cond(Expr.relationalExpression(Expr.identifier("a"), OP.GT, Expr.numeric(0.0)), "b");
        assertEquals(actualCondition, expected);
    }

    @Test
    @DisplayName("if (a > 0) then b ; if (c < 0) then d;")
    void parsesTwoConditions() {

        final String simpleCondition = "if (a > 0) then b ; if (c < 0) then d; ";


        var actualCondition = parse(simpleCondition);
        var expected1 = cond(Expr.relationalExpression(Expr.identifier("a"), OP.GT, Expr.numeric(0.0)), "b");
        var expected2 = cond(Expr.relationalExpression(Expr.identifier("c"), OP.LT, Expr.numeric(0.0)), "d");
        assertEquals(actualCondition, expected1, expected2);
    }


    private static void assertEquals(List<IfThen> conditions, IfThen... expectations) {
        if (conditions.isEmpty()) {
            fail("Conditions cannot be empty");
        }
        if (conditions.size() != expectations.length) {
            fail("Number of conditions do not match. Expected: " + expectations.length + " actual: " + conditions.size());
        }
        for (int i = 0; i < conditions.size(); i++) {
            var expected = expectations[i];
            var actual = conditions.get(i);
            assertThat(actual, equalTo(expected));
        }


    }

    private static IfThen cond(Expr expected, String action) {
        return new IfThen(expected, Expr.identifier(action));
    }

    private static IfThen cond(Expr expected, Expr action) {
        return new IfThen(expected, action);
    }

    @Test
    @DisplayName("if (a <= 0) then b ;")
    void parseLessEqual() {

        final String simpleCondition = "if (a <= 0) then b ;";


        var actualCondition = parse(simpleCondition);
        var expected = cond(Expr.relationalExpression(Expr.identifier("a"), OP.LTEQ, Expr.numeric(0.0)), "b");
        assertEquals(actualCondition, expected);
    }

    @Test
    @DisplayName("if (a > 0) THEN class: neutral;")
    void classNeutralAction() {

        final String simpleCondition = "if (a > 0) THEN class: neutral;";
        var actualCondition = parse(simpleCondition);


        var condition = Expr.relationalExpression(Expr.identifier("a"), OP.GT, Expr.numeric(0.0));
        var expected = cond(condition, Expr.action("class", Expr.identifier("neutral")));
        assertEquals(actualCondition, expected);
    }

    @Test
    @DisplayName("if (a > 0) THEN label: neutral;")
    void labelNeutralAction() {

        final String simpleCondition = "if (a > 0) THEN label: neutral;";
        var actualCondition = parse(simpleCondition);

        var condition = Expr.relationalExpression(Expr.identifier("a"), OP.GT, Expr.numeric(0.0));
        var expected = cond(condition, Expr.action("label", Expr.identifier("neutral")));
        assertEquals(actualCondition, expected);
    }

    @Test
    @DisplayName("if (a >= 0) then b ;")
    void parseGreaterEqual() {

        final String simpleCondition = "if (a >= 0) then b ;";
        var actualCondition = parse(simpleCondition);


        var expected = cond(Expr.relationalExpression(Expr.identifier("a"), OP.GTEQ, Expr.numeric(0.0)), "b");
        assertEquals(actualCondition, expected);
    }

    @Test
    @DisplayName("if ((a > b) && (c > b)) then b ;")
    void parseAndConditionWithTwoExpressions() {
        final String simpleCondition = "if ((a > b) && (c < b)) then b ;";
        var actualCondition = parse(simpleCondition);


        var aGTb = Expr.relationalExpression(Expr.identifier("a"), OP.GT, Expr.identifier("b"));
        var cLTb = Expr.relationalExpression(Expr.identifier("c"), OP.LT, Expr.identifier("b"));
        var expected = cond(Expr.andCondition(aGTb, cLTb), "b");


        assertEquals(actualCondition, expected);
    }

    @Test
    @DisplayName("if (!(a > b) && (c > b))  then b ;")
    void parseAndConditionWithTwoExpressionsOneNegated() {
        final String simpleCondition = "if (!(a > b) && (c < b)) then b ;";
        var actualCondition = parse(simpleCondition);

        var aGTb = Expr.relationalExpression(Expr.identifier("a"), OP.GT, Expr.identifier("b"));
        var cLTb = Expr.relationalExpression(Expr.identifier("c"), OP.LT, Expr.identifier("b"));
        var expected = cond(Expr.andCondition(Expr.negated(aGTb), cLTb), "b");
        assertEquals(actualCondition, expected);
    }

    @Test
    @DisplayName("if (a || b) then c;")
    void parseSimpleOr() {
        final String simpleCondition = "if (a || b) then c ;";
        var actualCondition = parse(simpleCondition);

        var expected = cond(Expr.orCondition(Expr.identifier("a"), Expr.identifier("b")), "c");
        assertEquals(actualCondition, expected);
    }

    //

    @Test
    @DisplayName("if (!a || !b) then c")
    void parseNegatedSimpleOr() {
        final String simpleCondition = "if (!a || !b) then c ;";
        var actualCondition = parse(simpleCondition);

        var expected = cond(Expr.orCondition(Expr.negated("a"), Expr.negated("b")), "c");
        assertEquals(actualCondition, expected);
    }

    @Test
    @DisplayName("if(a && b) then c")
    void parseSimpleAnd() {
        final String simpleCondition = "if (a && b) then c ;";
        var actualCondition = parse(simpleCondition);

        var expected = cond(Expr.andCondition(Expr.identifier("a"), Expr.identifier("b")), "c");
        assertEquals(actualCondition, expected);
    }


    @Test
    @DisplayName("if (a == 1 && b == 2) then c")
    void parseComparisonAnd() {
        final String simpleCondition = "if (a == 1 && b == 2) then c ;";
        var actualCondition = parse(simpleCondition);

        var firstStm = Expr.eq(Expr.identifier("a"), Expr.numeric(1));
        var secondStm = Expr.eq(Expr.identifier("b"), Expr.numeric(2));
        var expected = cond(Expr.andCondition(firstStm, secondStm), "c");
        assertEquals(actualCondition, expected);
    }

    @Test
    @DisplayName("syntax error")
    void syntaxError() {
        var parsed = parse("if -syntax_error;");
        assertThat(parsed, emptyCollectionOf(IfThen.class));
    }


    private static List<IfThen> parse(String simpleCondition) {

        return ParserBuilder.of(simpleCondition).parse();
    }


}