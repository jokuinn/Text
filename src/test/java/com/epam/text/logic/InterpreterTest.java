package com.epam.text.logic;

import com.epam.text.logic.calculator.Interpreter;
import org.junit.Assert;
import org.junit.Test;

public class InterpreterTest {

    private static final String MATH_EXPRESSION = "4 5 + 2 *";
    private static final String EXCEPTED = "18";

    @Test
    public void testCalculateShouldCalculate(){
        Interpreter interpreter = new Interpreter();

        String actual = interpreter.calculate(MATH_EXPRESSION);

        Assert.assertEquals(actual, EXCEPTED);
    }
}
