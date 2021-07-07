package exceptions;

import java.util.NoSuchElementException;

public class NoSuchFacultyException extends Exception {

    public NoSuchFacultyException(String message) {
        super(String.format("Faculty %s does not exist", message));
    }
}
