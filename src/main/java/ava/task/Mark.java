package ava.task;

import ava.Ui;
import ava.processor.Storage;
import ava.processor.TaskList;

/**
 * Class to represent "Mark" tasks.
 */
public class Mark extends Task {
    private int num;

    /**
     * The constructor for Mark task.
     *
     * @param num Index of the specified task.
     */
    public Mark(int num) {
        super("mark", false);
        this.num = num;
    }

    /**
     * Executes process to mark done the given task.
     *
     * @param tasks TaskList.
     * @param ui Class to print the ui.
     * @param storage Class to read/write to file.
     * @return The response of the command.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.markDone(num);
        storage.write(tasks.getTasks());
        return ui.showDoneTask(tasks, num);
    }
}