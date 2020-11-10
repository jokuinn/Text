package com.epam.text.logic.sorter;


import com.epam.text.data.ExpressionRecognizer;
import com.epam.text.logic.calculator.Interpreter;
import com.epam.text.model.Component;
import com.epam.text.model.Composite;
import com.epam.text.model.Leaf;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sorter {
    private static final int INDEX = 1;
    private static final char NEW_LINE = '\n';
    private final ExpressionRecognizer recognizer;
    private final Interpreter interpreter;

    public Sorter(ExpressionRecognizer recognizer, Interpreter interpreter) {
        this.recognizer = recognizer;
        this.interpreter = interpreter;
    }

    private String calculateExpression(String stringValue, Interpreter interpreter) {
        int stringLength = stringValue.length();
        String forCalculation = stringValue.substring(INDEX, stringLength - 1);
        return interpreter.calculate(forCalculation);
    }

    public Component calculateExpressions(Component component) {
        List<Component> components = new ArrayList<>();
        List<Component> children = component.getChildren();
        if (children.size() != 0) {
            for (Component child : children) {
                Component builtChild = calculateExpressions(child);
                components.add(builtChild);
            }
            return new Composite(components);
        } else {
            String stringValue = ((Leaf) component).getValue();
            if (recognizer.isExpression(stringValue)) {
                String parsed = calculateExpression(stringValue, interpreter);
                return Leaf.word(parsed);
            }
            return component;
        }
    }

    public Component sortParagraphsBySentenceLength(Component component) {
        List<Component> text = component.getChildren();
        text.sort(Comparator.comparingInt(sentence -> {
            List<Component> sentences = sentence.getChildren();
            return sentences.size();
        }));

        return new Composite(text);
    }

    private List<Component> getSortedLexemes(Component component){
        List<Component> lexemes = component.getChildren();
        lexemes.sort(Comparator.comparingInt(tempLexeme -> {
            String lexeme = ((Leaf) tempLexeme).getValue();
            return lexeme.length();
        }));
        return lexemes;
    }

    public Component sortSentencesByWordsLength(Component component){
        List<Component> paragraphs = new ArrayList<>();
        for (Component paragraph: component.getChildren()){
            List<Component> sentences = new ArrayList<>();
            for (Component sentence: paragraph.getChildren()){
                List<Component> words = getSortedLexemes(sentence);
                sentences.add(new Composite(words));
            }
            paragraphs.add(new Composite(sentences));
        }
        return new Composite(paragraphs);
    }

    public String restoreText(Component root) {
        StringBuilder text = new StringBuilder();
        for (Component paragraph : root.getChildren()) {
            for (Component sentence : paragraph.getChildren()) {
                for (Component lexeme : sentence.getChildren()) {
                    String lexemeValue = ((Leaf) lexeme).getValue();
                    text.append(lexemeValue);
                }
            }
            text.append(NEW_LINE);
        }
        return text.toString();
    }


}
