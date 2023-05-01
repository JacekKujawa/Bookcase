package com.isa.todo.model;

public enum Category {
    WORK("Praca"),
    HOME("Dom");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
