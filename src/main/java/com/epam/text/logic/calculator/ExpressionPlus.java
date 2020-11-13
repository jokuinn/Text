package com.epam.text.logic.calculator;

public class ExpressionPlus extends AbstractExpression {
    @Override
    public void interpret(Context context) {
        context.push(context.pop() + context.pop());
    }
}