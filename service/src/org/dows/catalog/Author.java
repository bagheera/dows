package org.dows.catalog;

public class Author {
    private String name;
    public static final Author NONE = new Author("none");

    public Author(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public boolean matches(String authorName) {
        return name.toLowerCase().contains(authorName.toLowerCase());
    }
}
