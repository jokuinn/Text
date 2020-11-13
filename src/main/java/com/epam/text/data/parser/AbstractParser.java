package com.epam.text.data.parser;

import com.epam.text.model.Component;
import com.epam.text.model.Composite;

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public abstract class AbstractParser implements Parser {

    private final Parser successor;

    public AbstractParser(Parser successor) {
        this.successor = successor;
    }

    protected Parser getSuccessor() {
        return successor;
    }

    protected abstract Pattern getPattern();

    protected abstract void process(Matcher matcher, List<Component> childrenComponents);

    @Override
    public Component parse(String line) {
        Pattern pattern = getPattern();
        Matcher matcher = pattern.matcher(line);
        List<Component> childrenComponents = new ArrayList<>();
        process(matcher, childrenComponents);
        return new Composite(childrenComponents);
    }
}
