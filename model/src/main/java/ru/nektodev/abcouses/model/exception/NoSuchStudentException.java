package ru.nektodev.abcouses.model.exception;

import java.util.NoSuchElementException;

/**
 * @author nektodev
 * @date 22/09/2016
 */
public class NoSuchStudentException extends NoSuchElementException {
    public NoSuchStudentException() {
        super();
    }

    public NoSuchStudentException(String s) {
        super(s);
    }
}
