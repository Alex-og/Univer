package exceptions;

public class NoSuchDepartmentException extends Exception {

    public NoSuchDepartmentException(String message) {
        super(String.format("The Department %s does not exist.", message));
    }
}
