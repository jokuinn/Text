package com.epam.text.data.parser;


import com.epam.text.data.ExpressionRecognizer;
import com.epam.text.model.Component;
import com.epam.text.model.Leaf;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractParser {

    private static final String EXPRESSION_PATTERN = "([\\s.?!]\\w+|\\s|,|\\.|\\?)|(\\[(\\d+|\\s|\\+|\\*|-|\\\\)+])";
    private final ExpressionRecognizer recognizer;

    public SentenceParser(ExpressionRecognizer recognizer) {
        super(null);
        this.recognizer = recognizer;
    }

    @Override
    protected Pattern getPattern() {
        return Pattern.compile(EXPRESSION_PATTERN);
    }

    @Override
    protected void process(Matcher matcher, List<Component> sentences) {
        while (matcher.find()){
            String sentence = matcher.group();
            if (recognizer.isExpression(sentence)) {
                sentences.add(Leaf.expression(sentence));
            } else {
                sentences.add(Leaf.word(sentence));
            }
        }
    }
}
