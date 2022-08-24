package duke.task;

import duke.processor.Storage;
import duke.processor.TaskList;
import duke.Ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Class to represent "Deadline" tasks.
 */
public class Deadline extends Task {
    protected LocalDateTime time;

    /**
     * The constructor for Duke.Task.Deadline task.
     *
     * @param description Task description.
     * @param isDone Task state.
     */
    public Deadline(String description, boolean isDone, LocalDateTime time) {
        super(description, isDone);
        this.time = time;
    }

    /**
     * Marks done a Deadline task.
     *
     * @return Duke.Task.Deadline object.
     */
    @Override
    public Deadline markDone() {
        super.markDone();
        return this;
    }

    /**
     * Marks undone a Deadline task.
     *
     * @return Duke.Task.Deadline object.
     */
    @Override
    public Deadline markUndone() {
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
        return "D | " + mark + " | " + this.description + " | " +
                this.time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    /**
     * Overridden toString method for Duke.Task.Deadline task details.
     *
     * @return String.
     */
    @Override
    public String toString() {
        return "[D]"  + super.toString() +
                " (by: " + this.time.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm")) + ")";
    }

    /**
     * Executes process of given Deadline task.
     *
     * @param tasks TaskList.
     * @param ui Class to print the ui.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.add(this);
        ui.showAddOnTask(tasks, (tasks.size() - 1));
        storage.write(tasks.getTasks());
    }
}