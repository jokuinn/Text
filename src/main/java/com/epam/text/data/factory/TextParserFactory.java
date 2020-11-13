package com.epam.text.data.factory;

import com.epam.text.data.parser.Parser;
import com.epam.text.data.parser.TextParser;

public class TextParserFactory implements ParserFactory {

    private final Parser successor;

    public TextParserFactory(Parser successor) {
        this.successor = successor;
    }

    @Override
    public Parser create() {
        return new TextParser(successor);
    }
}
