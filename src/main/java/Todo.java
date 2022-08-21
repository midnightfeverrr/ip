/**
 * Class to represent "To Do" tasks.
 */
public class Todo extends Task {
    /**
     * The constructor for Todo task
     * @param description
     * @param isDone
     */
    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    /**
     * the method to mark as done the Todo task
     * @return Todo object
     */
    @Override
    public Todo markDone() {
        super.markDone();
        return this;
    }

    /**
     * the method to mark as undone the Todo task
     * @return Todo object
     */
    @Override
    public Todo markUndone() {
        super.markUndone();
        return this;
    }

    /**
     * The method to change the tasklist format to write in tasks.txt
     * @return String
     */
    public String formatChange() {
        String mark = isDone ? "1" : "0";
        return "T | " + mark + " | " + this.description;
    }

    /**
     * Overridden toString method for Todo task details
     * @return String
     */
    @Override
    public String toString() {
        return "[T]"  + super.toString();
    }

    /**
     * The execute version to process given Todo task
     * @param task
     * @param ui
     */
    @Override
    public void execute(TaskList task, UI ui, Storage storage) {
        task.add(this);
        ui.showAddOnTask(task, (task.size() - 1));
        storage.write(task.getTasks());
    }
}
