package com.epam.text.data.factory;

import com.epam.text.data.parser.ParagraphParser;
import com.epam.text.data.parser.Parser;

public class ParagraphParserFactory implements ParserFactory {
    private final Parser successor;

    public ParagraphParserFactory(Parser successor) {
        this.successor = successor;
    }

    @Override
    public Parser create() {
        return new ParagraphParser(successor);
    }
}
