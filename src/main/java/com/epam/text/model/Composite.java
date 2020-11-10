package com.epam.text.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Composite implements Component {

    private final List<Component> components;

    public Composite(List<Component> components){
        this.components = components;
    }

    @Override
    public List<Component> getChildren() {
        return new ArrayList<>(components);
    }

    @Override
    public String toString() {
        return "Composite{" + "components" + components + '}' + '\n';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }

        Composite composite = (Composite) obj;

        return Objects.equals(components, composite.components);
    }
}
