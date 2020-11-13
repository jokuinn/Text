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
    private static final String PARAGRAPH_SEPARATOR = System.lineSeparator();
    private final ExpressionRecognizer recognizer = new ExpressionRecognizer();
    private final Interpreter interpreter = new Interpreter();

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
        List<Component> sortedParagraphs = new ArrayList<>(component.getChildren());
        sortedParagraphs.sort(Comparator.comparingInt(sentence -> {
            List<Component> sentences = sentence.getChildren();
            return sentences.size();
        }));

        return new Composite(sortedParagraphs);
    }

    private void getSortedLexemes(List<Component> sortedLexemes){
        sortedLexemes.sort(Comparator.comparingInt(lexeme -> {
            String lexemeValue = ((Leaf) lexeme).getValue();
            return lexemeValue.length();
        }));
    }

    public Component sortSentencesByWordsLength(Component component){
        List<Component> paragraphs = new ArrayList<>();
        for (Component paragraph: component.getChildren()){
            List<Component> sentences = new ArrayList<>();
            for (Component sentence: paragraph.getChildren()){
                List<Component> sortedLexemes = new ArrayList<>(sentence.getChildren());
                getSortedLexemes(sortedLexemes);
                sentences.add(new Composite(sortedLexemes));
            }
            paragraphs.add(new Composite(sentences));
        }
        return new Composite(paragraphs);
    }

    public String restore(Component root) {
        StringBuilder text = new StringBuilder();
        for (Component paragraph : root.getChildren()) {
            for (Component sentence : paragraph.getChildren()) {
                for (Component lexeme : sentence.getChildren()) {
                    String lexemeValue = ((Leaf) lexeme).getValue();
                    text.append(lexemeValue);
                }
            }
            text.append(PARAGRAPH_SEPARATOR);
        }
        return text.toString().trim();
    }


}
