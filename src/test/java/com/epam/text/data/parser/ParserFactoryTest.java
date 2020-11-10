package com.epam.text.data.parser;


import com.epam.text.data.ExpressionRecognizer;
import com.epam.text.data.factory.ParagraphParserFactory;
import com.epam.text.data.factory.ParserFactory;
import com.epam.text.data.factory.SentenceParserFactory;
import com.epam.text.data.factory.TextParserFactory;
import org.junit.Assert;
import org.mockito.Mockito;

import org.junit.Test;

public class ParserFactoryTest {
    @Test
    public void testCreateShouldCreateTextParser(){
        Parser creator = Mockito.mock(Parser.class);
        ParserFactory factory = new TextParserFactory(creator);

        Parser textParser = factory.create();

        Assert.assertTrue(textParser instanceof TextParser);
    }

    @Test
    public void testCreateShouldCreateParagraphParser() {
        Parser successor = Mockito.mock(Parser.class);
        ParserFactory parserFactory = new ParagraphParserFactory(successor);

        Parser textParser = parserFactory.create();

        Assert.assertTrue(textParser instanceof ParagraphParser);
    }

    @Test
    public void testCreateShouldCreateSentenceParser() {
        ExpressionRecognizer recognizer = Mockito.mock(ExpressionRecognizer.class);
        ParserFactory parserFactory = new SentenceParserFactory(recognizer);

        Parser textParser = parserFactory.create();

        Assert.assertTrue(textParser instanceof SentenceParser);
    }
}
