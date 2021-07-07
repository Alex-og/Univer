package exceptions;

public class NoSuchSubjectException extends Exception {

    public NoSuchSubjectException(String name) {
        super(String.format("Subject %s not found", name));
    }
}
