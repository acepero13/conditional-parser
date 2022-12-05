package com.acepero13.research.conditionalparser.visitor;

import com.acepero13.research.conditional.ConditionalLexer;
import com.acepero13.research.conditional.ConditionalParser;
import com.acepero13.research.conditionalparser.model.IfThen;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Optional;

public class ParserBuilder {

    private final InputStream is;

    private ParserBuilder(InputStream is) {
        this.is = is;
    }

    public ParserBuilder of(String code) {
        return new ParserBuilder(str2Is(code));
    }

    public ParserBuilder of(InputStream is) {
        return new ParserBuilder(is);
    }

    private static ByteArrayInputStream str2Is(String code) {
        return new ByteArrayInputStream(code.getBytes());
    }

    // TODO: Several conditions
    public Optional<IfThen> parse() {
        ConditionalLexer lexer = buildLexer();

        CommonTokenStream tokens = new CommonTokenStream(Objects.requireNonNull(lexer, "lexer cannot be null"));

        ConditionalParser parser = new ConditionalParser(tokens);

        var result = parser.if_stat();

        var visitor = new ConditionalVisitor();
        visitor.visitIf_stat(result);

        return visitor.condition();
    }

    private ConditionalLexer buildLexer() {
        ConditionalLexer lexer = null;
        try {
            lexer = new ConditionalLexer(CharStreams.fromStream(is));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lexer;
    }
}
