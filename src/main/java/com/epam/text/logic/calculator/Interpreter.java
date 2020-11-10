package com.epam.text.logic.calculator;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interpreter {
    private static final String SPACES = "\\s";
    private static final char MINUS = '-';
    private static final char PLUS = '+';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';

    private final List<AbstractExpression> listExpression = new ArrayList<>();

    private void parse(String expression){
        for (String lexeme: expression.split(SPACES)){
            if (lexeme.isEmpty()){
                continue;
            }
            char temp = lexeme.charAt(0);
            switch (temp){
                case MINUS:{
                    listExpression.add(new ExpressionMinus());
                    break;
                }
                case PLUS:{
                    listExpression.add(new ExpressionPlus());
                    break;
                }
                case MULTIPLY:{
                    listExpression.add(new ExpressionMultiply());
                    break;
                }
                case DIVIDE:{
                    listExpression.add(new ExpressionDivide());
                    break;
                }
                default:{
                    Scanner in = new Scanner(lexeme);
                    if (in.hasNextInt()){
                        listExpression.add(new ExpressionEmpty(in.nextInt()));
                    }
                }
            }
        }
    }

    public String calculate(String expression) {
        parse(expression);
        Context context = new Context();
        for (AbstractExpression terminal : listExpression) {
            terminal.interpret(context);
        }
        return context.pop().toString();
    }
}
