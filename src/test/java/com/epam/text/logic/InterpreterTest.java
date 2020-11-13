package com.epam.text.logic;

import com.epam.text.logic.calculator.Interpreter;
import org.junit.Assert;
import org.junit.Test;

public class InterpreterTest {

    private static final String MATH_EXPRESSION = "4 5 + 2 *";
    private static final String PLUS = "4 5 +";
    private static final String MINUS = "4 5 -";
    private static final String MULTIPLY = "4 5 *";
    private static final String DIVIDE = "2 6 /";

    @Test
    public void testCalculateShouldCalculate(){
        Interpreter interpreter = new Interpreter();

        String expected = interpreter.calculate(MATH_EXPRESSION);

        Assert.assertEquals("18", expected);
    }

    @Test
    public void testCalculateShouldReturnCorrectPlusAnswer(){
        Interpreter interpreter = new Interpreter();

        String expected = interpreter.calculate(PLUS);

        Assert.assertEquals("9", expected);
    }

    @Test
    public void testCalculateShouldReturnCorrectMinusAnswer(){
        Interpreter interpreter = new Interpreter();

        String expected = interpreter.calculate(MINUS);

        Assert.assertEquals("1", expected);
    }

    @Test
    public void testCalculateShouldReturnCorrectMultiplyAnswer(){
        Interpreter interpreter = new Interpreter();

        String expected = interpreter.calculate(MULTIPLY);

        Assert.assertEquals("20", expected);
    }

    @Test
    public void testCalculateShouldReturnCorrectDivideAnswer(){
        Interpreter interpreter = new Interpreter();

        String expected = interpreter.calculate(DIVIDE);

        Assert.assertEquals("3", expected);
    }
}
