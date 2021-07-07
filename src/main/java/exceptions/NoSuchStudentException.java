package exceptions;

public class NoSuchStudentException extends Exception {

    public NoSuchStudentException(int id) {
        super("Student not found for id: " + id);
    }

    public NoSuchStudentException(String name, String surName) {
        super(String.format("Student %s %s not found.", name, surName));
    }
}
