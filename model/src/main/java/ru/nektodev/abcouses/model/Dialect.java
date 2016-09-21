package ru.nektodev.abcouses.model;

/**
 * @author nektodev
 * @date 21/09/2016
 */
public enum Dialect {
    UK("BrE"),
    US("AmE");

    private final String name;

    Dialect(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
