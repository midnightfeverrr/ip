package Duke.Task;

import Duke.Processor.Storage;
import Duke.Processor.TaskList;
import Duke.UI;

/**
 * Class to represent "Todo" tasks.
 */
public class Todo extends Task {
    /**
     * The constructor for Duke.Task.Todo task.
     *
     * @param description Task description.
     * @param isDone Task state.
     */
    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    /**
     * Marks done a Todo task.
     *
     * @return Duke.Task.Todo object.
     */
    @Override
    public Todo markDone() {
        super.markDone();
        return this;
    }

    /**
     * Marks undone a Todo task.
     *
     * @return Duke.Task.Todo object.
     */
    @Override
    public Todo markUndone() {
        super.markUndone();
        return this;
    }

    /**
     * Changes the format of Task to write to the file.
     *
     * @return String format to write to file.
     */
    public String formatChange() {
        String mark = isDone ? "1" : "0";
        return "T | " + mark + " | " + this.description;
    }

    /**
     * Overridden toString method for Duke.Task.Todo task details.
     *
     * @return String.
     */
    @Override
    public String toString() {
        return "[T]"  + super.toString();
    }

    /**
     * Execute process of given Todo task.
     *
     * @param tasks TaskList.
     * @param ui Class to print the ui.
     */
    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) {
        tasks.add(this);
        ui.showAddOnTask(tasks, (tasks.size() - 1));
        storage.write(tasks.getTasks());
    }
}
