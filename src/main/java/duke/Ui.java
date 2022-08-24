package duke;

import duke.processor.TaskList;
import duke.task.Task;

/**
 * Class to represent the user interfaces
 */
public class Ui {
    private final static String underline = "____________________________________________________________";
    private final static String indentation = "  ";

    /**
     * Method to show Welcome message at the start.
     */
    public void printGreetings() {
        System.out.println(indentation + underline);
        System.out.println(indentation + "Hello! I'm Duke\n" +
                indentation + "What can I do for you?");
        System.out.println(indentation + underline);
    }

    /**
     * Method to show Exit message at finish.
     */
    public void exit() {
        System.out.println(indentation + underline);
        System.out.println(indentation + "Bye! Hope to see you again soon!");
        System.out.println(indentation + underline);
    }

    /**
     * The method to show added task.
     * @param task
     */
    public void showAddOnTask(TaskList task, int numOfTask) {
        System.out.println(indentation + underline);
        System.out.println(indentation + "I've added this task:");
        System.out.println(indentation + task.get(numOfTask));
        System.out.println(indentation + "Now you have " + (numOfTask + 1) + " tasks in the list.");
        System.out.println(indentation + underline);
    }

    /**
     * The method to show added task.
     * @param task
     */
    public void showDeleteTask(TaskList task, Task taskDeleted) {
        System.out.println(indentation + underline);
        System.out.println(indentation + "Noted. I've removed this task:");
        System.out.println(indentation + taskDeleted);
        System.out.println(indentation + "Now you have " + task.size() + " tasks in the list.");
        System.out.println(indentation + underline);
    }

    /**
     * The method to show task being done.
     * @param task
     */
    public void showDoneTask(TaskList task, int num) {
        System.out.println(indentation + underline);
        System.out.println(indentation + "Nice! I've marked this task as done:");
        System.out.println(indentation + task.get(num));
        System.out.println(indentation + underline);
    }

    /**
     * The method to show task being undone.
     * @param task
     */
    public void showUndoneTask(TaskList task, int num) {
        System.out.println(indentation + underline);
        System.out.println(indentation + "OK, I've marked this task as not done yet:");
        System.out.println(indentation + task.get(num));
        System.out.println(indentation + underline);
    }

    /**
     * The method to show list of added tasks.
     * @param task
     */
    public void showListDetails(TaskList task) {
        System.out.println(indentation + underline);
        System.out.println(indentation + "Here are the tasks in your list:");
        for (int i = 0; i < task.size(); i ++) {
            System.out.println(indentation + (i + 1) + "." + indentation + task.get(i));
        }
        System.out.println(indentation + underline);
    }

    /**
     * Shows the find details.
     * @param tasks TaskList.
     * @param description Find target.
     */
    public void showFindDetails(TaskList tasks, String description) {
        System.out.println(indentation + underline);
        System.out.println(indentation + "Here are the matching tasks in your list:");
        int increment = 1;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getDescription().contains(description)) {
                System.out.println(indentation + (increment) + "." + indentation + tasks.get(i));
                increment++;
            }
        }
        System.out.println(indentation + underline);
    }
}
