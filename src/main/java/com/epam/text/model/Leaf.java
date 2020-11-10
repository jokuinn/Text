package com.epam.text.model;

import java.util.ArrayList;
import java.util.List;

public class Leaf implements Component {
    private final LeafType type;
    private final String value;

    private Leaf(LeafType type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public List<Component> getChildren() {
        return new ArrayList<>();
    }

    @Override
    public String toString()     {
        return "Leaf{" + "type=" + type + ", value='" + value + '\'' + '}';
    }

    public static Leaf word(String value) {
        return new Leaf(LeafType.WORD, value);
    }

    public static Leaf expression(String value) {
        return new Leaf(LeafType.CALCULATE_EXPRESSION, value);
    }

    public LeafType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
