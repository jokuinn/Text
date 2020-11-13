package com.epam.text.data.parser;

public class ChainBuilder {
    public Parser build() {
        SentenceParser sentenceParser = new SentenceParser(null);
        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);
        return new TextParser(paragraphParser);
    }
}
