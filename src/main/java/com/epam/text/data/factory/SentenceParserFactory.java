package com.epam.text.data.factory;

import com.epam.text.data.ExpressionRecognizer;
import com.epam.text.data.parser.Parser;
import com.epam.text.data.parser.SentenceParser;

public class SentenceParserFactory implements ParserFactory{
    private final ExpressionRecognizer recognizer;

    public SentenceParserFactory(ExpressionRecognizer recognizer) {
        this.recognizer = recognizer;
    }

    @Override
    public Parser create() {
        return new SentenceParser(recognizer);
    }
}
