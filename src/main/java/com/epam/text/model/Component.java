package com.epam.text.model;

import java.util.List;

public interface Component {
    List<Component> getChildren();
}
