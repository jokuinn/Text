package com.epam.text.data;

import org.junit.Assert;
import org.junit.Test;

public class ExpressionRecognizerTest {
    private static final String EXPRESSION = "[4 5 +]";
    private static final String NOT_EXPRESSION = "Reut";

    @Test
    public void testIsExpressionShouldReturnTrueIfStringIsExpression(){
        ExpressionRecognizer recognizer = new ExpressionRecognizer();

        boolean expected = recognizer.isExpression(EXPRESSION);

        Assert.assertTrue(expected);
    }

    @Test
    public void testIsExpressionShouldReturnFalseIfStringIsNotExpression(){
        ExpressionRecognizer recognizer = new ExpressionRecognizer();

        boolean expected = recognizer.isExpression(NOT_EXPRESSION);

        Assert.assertFalse(expected);
    }
}
