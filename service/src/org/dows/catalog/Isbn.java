package org.dows.catalog;

public class Isbn {
    String ibsnString;

    public Isbn(String ibsnString) {
        this.ibsnString = ibsnString;
    }

    public String value() {
        return ibsnString;
    }

    public boolean matches(String other) {
        return this.ibsnString.equalsIgnoreCase(other);
    }
}
