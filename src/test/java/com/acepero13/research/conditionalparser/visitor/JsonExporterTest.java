package com.acepero13.research.conditionalparser.visitor;

import com.acepero13.research.conditionalparser.model.Expr;
import com.acepero13.research.conditionalparser.model.OP;
import com.acepero13.research.conditionalparser.model.exporter.Exportable;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonExporterTest {
    private final Exportable jsonExport = new JsonExporter();

    @Test
    void exportSimpleAndToJson() {

        var condition = Expr.relationalExpression(Expr.identifier("a"), OP.GT, Expr.numeric(0.0));
        var actual = jsonExport.export(condition);
        assertEquals("{\"relationalCondition\":{\"left\":{\"identifier\":\"a\"},\"op\":\"GT\",\"right\":{\"number\":0.0}}}", actual.toString());
    }

    private static class JsonExporter implements Exportable {

        @Override
        public JsonObject and(Expr.AndExpr expr) {
            JsonObject result = new JsonObject();
            JsonObject andCondition = new JsonObject();
            andCondition.add("left", export(expr.getLeft()));
            andCondition.add("right", export(expr.getRight()));
            result.add("and", andCondition);
            return result;
        }

        @Override
        public <B> B or(Expr.OrExpr expr) {
            return null;
        }

        @Override
        public <C> C negation(Expr.NegationExpr expr) {
            return null;
        }

        @Override
        public JsonObject numeric(Expr.NumericExpr expr) {
            var result = new JsonObject();
            result.addProperty("number", expr.getValue());
            return result;
        }

        @Override
        public JsonObject identifier(Expr.IdentifierExpr expr) {
            var result = new JsonObject();
            result.addProperty("identifier", expr.getValue());
            return result;
        }

        @Override
        public <F> F eq(Expr.EqualityExpr expr) {
            return null;
        }

        @Override
        public <H> H action(Expr.Action expr) {
            return null;
        }

        @Override
        public JsonObject relational(Expr.RelationalExpr expr) {
            JsonObject result = new JsonObject();
            JsonObject relation = new JsonObject();
            relation.add("left", export(expr.getLeft()));
            relation.addProperty("op", expr.getOperator().toString());
            relation.add("right", export(expr.getRight()));
            result.add("relationalCondition", relation);
            return result;
        }
    }

}
