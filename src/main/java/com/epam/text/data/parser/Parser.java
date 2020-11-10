package com.epam.text.data.parser;

import com.epam.text.model.Component;

public interface Parser {
    Component parse(String line);
}
