package Duke.Task;

/**
 * Class to represent "Duke.Task.Bye" tasks.
 */
public class Bye extends Task {
    /**
     * The constructor for Exit task
     */
    public Bye() {
        super("bye", false);
        this.isBye = true;
    }
}