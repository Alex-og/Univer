package exceptions;

public class FullGroupException extends Exception {

    public FullGroupException(String message) {
        super("Cannot add " + message + " because the group is already full");
    }
}
