package model;

public abstract class Person {
    private String name;
    private String surName;

    protected Person(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    protected String getName() {
        return name;
    }

    protected String getSurName() {
        return surName;
    }
}
