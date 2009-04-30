package org.dows.catalog;

public enum Rating {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5);
    private int value;

    Rating(int value) {
        this.value = value;
    }

    public String value() {
        return String.valueOf(value);
    }
}
