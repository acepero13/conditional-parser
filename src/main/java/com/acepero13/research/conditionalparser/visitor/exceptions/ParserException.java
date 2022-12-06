package com.acepero13.research.conditionalparser.visitor.exceptions;

public class ParserException extends RuntimeException {
    public ParserException(Throwable e) {
        super("Error parsing", e);
    }

    public ParserException(String message, Throwable e) {
        super(message, e);
    }

    public ParserException(String message) {
        super(message);
    }
}
