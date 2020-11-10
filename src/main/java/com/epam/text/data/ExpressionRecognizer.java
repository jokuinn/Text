package com.epam.text.data;

public class ExpressionRecognizer {
    public static final String PREFIX = "[";

    public boolean isExpression(String lexeme) {
        return lexeme.startsWith(PREFIX);
    }
}
