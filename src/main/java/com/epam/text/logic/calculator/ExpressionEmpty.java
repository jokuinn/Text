package com.epam.text.logic.calculator;

public class ExpressionEmpty extends AbstractExpression {

    private final int number;

    public ExpressionEmpty(int number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.push(number);
    }
}
