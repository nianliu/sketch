package reference;

import lombok.Getter;

@Getter
public abstract class Parent {

    private final String name;

    protected Parent(String name) {
        this.name = name;
    }
}
