package com.epam.text.data.parser;

import com.epam.text.model.Composite;
import com.epam.text.model.Component;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends AbstractParser{

    private static final String SENTENCE_PATTERN = ".*?[.!?]";

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    protected Pattern getPattern() {
        return Pattern.compile(SENTENCE_PATTERN);
    }

    @Override
    protected void process(Matcher matcher, List<Component> paragraphs) {
        while (matcher.find()){
            String paragraph = matcher.group();
            Parser parser = getSuccessor();
            Component parsed = parser.parse(paragraph);
            paragraphs.add(parsed);
        }
    }
}
