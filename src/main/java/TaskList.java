import java.util.ArrayList;

/**
 * Class to represent the task lists.
 */
public class TaskList {
    private static ArrayList<Task> task;

    /**
     * The constructor for no input
     */
    public TaskList() {
        this.task = new ArrayList<Task>();
    }

    /**
     * The constructor with input ArrayList
     * @param task
     */
    public TaskList(ArrayList<Task> task) {
        this.task = task;
    }

    /**
     * Method to add a task.
     * @param t
     */
    public void add(Task t) {
        task.add(t);
    }

    /**
     * Method to remove a task.
     * @param i
     * @return Task taskDeleted
     */
    public Task delete(int i) {
        return task.remove(i);
    }

    /**
     * Method to mark a task as done.
     * @param i
     */
    public void markDone(int i) {
        task.get(i).markDone();
    }

    /**
     * Method to mark a task as undone.
     * @param i
     */
    public void markUndone(int i) {
        task.get(i).markUndone();
    }

    /**
     * Method to return the number of tasks.
     * @return int
     */
    public int size() {
        return task.size();
    }

    /**
     * Method to get a specific task.
     * @param i
     * @return Task object
     */
    public Task get(int i) {
        return task.get(i);
    }

    /**
     * Method to get the list of tasks.
     * @return Arraylist
     */
    public ArrayList<Task> getTasks() {
        return this.task;
    }
}
