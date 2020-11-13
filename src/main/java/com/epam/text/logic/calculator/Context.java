package com.epam.text.logic.calculator;

import java.util.ArrayDeque;

public class Context {
    private final ArrayDeque<Integer> contextValues = new ArrayDeque<>();

    public Integer pop() {
        return contextValues.pop();
    }

    public void push(int value) {
        contextValues.push(value);
    }

}
