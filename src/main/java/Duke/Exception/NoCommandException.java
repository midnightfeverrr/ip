package Duke.Exception;

/**
 * Class to represent Duke.Exception.NoCommandException.
 */
public class NoCommandException extends Exception {
    /**
     * The Constructor for Duke.Exception.NoCommandException
     * @param message
     */
    public NoCommandException(String message) {
        super(String.format("☹ OOPS!!! I'm sorry, but I don't know what that means :-("));
    }
}