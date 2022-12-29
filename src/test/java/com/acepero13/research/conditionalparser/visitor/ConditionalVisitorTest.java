package com.acepero13.research.conditionalparser.visitor;

import com.acepero13.research.conditionalparser.model.Expr;
import com.acepero13.research.conditionalparser.model.IfThen;
import com.acepero13.research.conditionalparser.model.OP;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.acepero13.research.conditionalparser.model.Expr.*;
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
        var expected = cond(relationalExpression(identifier("a"), OP.GT, numeric(0.0)), "b");
        assertEquals(actualCondition, expected);
    }

    @Test
    @DisplayName("if (a > 0) then b ; if (c < 0) then d;")
    void parsesTwoConditions() {

        final String simpleCondition = "if (a > 0) then b ; if (c < 0) then d; ";


        var actualCondition = parse(simpleCondition);
        var expected1 = cond(relationalExpression(identifier("a"), OP.GT, numeric(0.0)), "b");
        var expected2 = cond(relationalExpression(identifier("c"), OP.LT, numeric(0.0)), "d");
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
        return new IfThen(expected, identifier(action));
    }

    private static IfThen cond(Expr expected, Expr action) {
        return new IfThen(expected, action);
    }

    @Test
    @DisplayName("if (a <= 0) then b ;")
    void parseLessEqual() {

        final String simpleCondition = "if (a <= 0) then b ;";


        var actualCondition = parse(simpleCondition);
        var expected = cond(relationalExpression(identifier("a"), OP.LTEQ, numeric(0.0)), "b");
        assertEquals(actualCondition, expected);
    }

    @Test
    @DisplayName("if (a > 0) THEN class: neutral;")
    void classNeutralAction() {

        final String simpleCondition = "if (a > 0) THEN class: neutral;";
        var actualCondition = parse(simpleCondition);


        var condition = relationalExpression(identifier("a"), OP.GT, numeric(0.0));
        var expected = cond(condition, action("class", identifier("neutral")));
        assertEquals(actualCondition, expected);
    }

    @Test
    @DisplayName("if (a > 0) THEN label: neutral;")
    void labelNeutralAction() {

        final String simpleCondition = "if (a > 0) THEN label: neutral;";
        var actualCondition = parse(simpleCondition);

        var condition = relationalExpression(identifier("a"), OP.GT, numeric(0.0));
        var expected = cond(condition, action("label", identifier("neutral")));
        assertEquals(actualCondition, expected);
    }

    @Test
    @DisplayName("if (a >= 0) then b ;")
    void parseGreaterEqual() {

        final String simpleCondition = "if (a >= 0) then b ;";
        var actualCondition = parse(simpleCondition);


        var expected = cond(relationalExpression(identifier("a"), OP.GTEQ, numeric(0.0)), "b");
        assertEquals(actualCondition, expected);
    }

    @Test
    @DisplayName("if ((a > b) && (c > b)) then b ;")
    void parseAndConditionWithTwoExpressions() {
        final String simpleCondition = "if ((a > b) && (c < b)) then b ;";
        var actualCondition = parse(simpleCondition);


        var aGTb = relationalExpression(identifier("a"), OP.GT, identifier("b"));
        var cLTb = relationalExpression(identifier("c"), OP.LT, identifier("b"));
        var expected = cond(andCondition(aGTb, cLTb), "b");


        assertEquals(actualCondition, expected);
    }

    @Test
    @DisplayName("if (!(a > b) && (c > b))  then b ;")
    void parseAndConditionWithTwoExpressionsOneNegated() {
        final String simpleCondition = "if (!(a > b) && (c < b)) then b ;";
        var actualCondition = parse(simpleCondition);

        var aGTb = relationalExpression(identifier("a"), OP.GT, identifier("b"));
        var cLTb = relationalExpression(identifier("c"), OP.LT, identifier("b"));
        var expected = cond(andCondition(negated(aGTb), cLTb), "b");
        assertEquals(actualCondition, expected);
    }

    @Test
    @DisplayName("if (a || b) then c;")
    void parseSimpleOr() {
        final String simpleCondition = "if (a || b) then c ;";
        var actualCondition = parse(simpleCondition);

        var expected = cond(orCondition(identifier("a"), identifier("b")), "c");
        assertEquals(actualCondition, expected);
    }

    //

    @Test
    @DisplayName("if (!a || !b) then c")
    void parseNegatedSimpleOr() {
        final String simpleCondition = "if (!a || !b) then c ;";
        var actualCondition = parse(simpleCondition);

        var expected = cond(orCondition(negated("a"), negated("b")), "c");
        assertEquals(actualCondition, expected);
    }

    @Test
    @DisplayName("if(a && b) then c")
    void parseSimpleAnd() {
        final String simpleCondition = "if (a && b) then c ;";
        var actualCondition = parse(simpleCondition);

        var expected = cond(andCondition(identifier("a"), identifier("b")), "c");
        assertEquals(actualCondition, expected);
    }


    @Test
    @DisplayName("if (a == 1 && b == 2) then c")
    void parseComparisonAnd() {
        final String simpleCondition = "if (a == 1 && b == 2) then c ;";
        var actualCondition = parse(simpleCondition);

        var firstStm = eq(identifier("a"), numeric(1));
        var secondStm = eq(identifier("b"), numeric(2));
        var expected = cond(andCondition(firstStm, secondStm), "c");
        assertEquals(actualCondition, expected);
    }

    @Test
    @DisplayName("syntax error")
    void syntaxError() {
        var parsed = parse("if -syntax_error;");
        assertThat(parsed, emptyCollectionOf(IfThen.class));
    }

    @Test
    @DisplayName("Parse complex condition with probabilities")
    void probabilities() {
        var condition = "IF (cloud_coverage > 10.5) && (daytime > 3.0) && (cloud_coverage <= 56.5) && (freeflow_speed <= 132.5) THEN class: angry (prob: 76.15%) | based on 1,248 samples;";
        var actualCondition = parse(condition);

        var cloud = gt(identifier("cloud_coverage"), numeric(10.5));
        var dayTime = gt(identifier("daytime"), numeric(3.0));
        var cloudCoverageLT = Expr.lteq(identifier("cloud_coverage"), numeric(56.5));
        var freeFlow = lteq(identifier("freeflow_speed"), numeric(132.5));

        var condCloudDaytime = andCondition(cloud, dayTime);
        var cloudDaytimeCloudCov = andCondition(condCloudDaytime, cloudCoverageLT);
        var all = andCondition(cloudDaytimeCloudCov, freeFlow);

        var expected = cond(all, Expr.action("class", Expr.identifier("angry"), 76.15));
        assertEquals(actualCondition, expected);
    }


    private static List<IfThen> parse(String simpleCondition) {

        return ParserBuilder.of(simpleCondition).parse();
    }


}
