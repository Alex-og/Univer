package exceptions;

public class MaxCapacityException extends Exception {

    public MaxCapacityException(String clazz) {
        super(String.format("There is no way to add another %s, since the number is maximum", clazz));
    }
}
