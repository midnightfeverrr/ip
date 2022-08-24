package duke.processor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import duke.Ui;
import duke.exception.NoCommandException;
import duke.exception.NoDescriptionException;
import duke.exception.NoTimeException;
import duke.exception.WrongTimeFormatException;
import duke.task.Bye;
import duke.task.Deadline;
import duke.task.Delete;
import duke.task.Event;
import duke.task.List;
import duke.task.Mark;
import duke.task.Task;
import duke.task.Todo;
import duke.task.Unmark;

/**
 * Class to represent a parser.
 */
public class Parser {
    // usage of Enum
    private enum Commands {
        BYE, LIST, MARK, UNMARK, TODO, DEADLINE, EVENT, DELETE
    }
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static Ui ui = new Ui();

    /**
     * The method to mark done command task process
     * @param chat
     * @param tasklist
     * @return Duke.Task.Task object
     * @throws NoDescriptionException
     * @throws NoCommandException
     */
    public static Task mark(String chat, TaskList tasklist) throws NoDescriptionException, NoCommandException {
        int num = Integer.parseInt(chat.split(" ")[1]) - 1;
        return new Mark(num);
    }

    /**
     * The method to mark undone command task process
     * @param chat
     * @param tasklist
     * @return Duke.Task.Task object
     * @throws NoDescriptionException
     * @throws NoCommandException
     */
    public static Task unmark(String chat, TaskList tasklist) throws NoDescriptionException, NoCommandException {
        int num = Integer.parseInt(chat.split(" ")[1]) - 1;
        return new Unmark(num);
    }

    /**
     * The method for Duke.Task.Todo, Duke.Task.Deadline, Duke.Task.Event command task process
     * @param chat
     * @param tasklist
     * @return Duke.Task.Task object
     * @throws NoDescriptionException
     * @throws NoCommandException
     */
    public static Task addTask(String chat, TaskList tasklist) throws NoDescriptionException, NoCommandException,
            NoTimeException, WrongTimeFormatException {

        Commands command = Parser.Commands.valueOf(chat.toUpperCase().split(" ")[0]);
        if (chat.split(" ").length != 1) {
            switch (command) {
            case TODO:
                if (chat.split(" ").length == 1) {
                    throw new NoDescriptionException(command.name());
                } else {
                    return new Todo(chat.substring(5), false);
                }

            case DEADLINE:
                String subStringDeadline = chat.substring(9);
                if (subStringDeadline.split(" /by ").length == 1) {
                    throw new NoTimeException(command.name());
                } else {
                    try {
                        return new Deadline(subStringDeadline.split(" /by ")[0], false,
                                LocalDateTime.parse(subStringDeadline.split(" /by ")[1], TIME_FORMAT));
                    } catch (Exception e) {
                        throw new WrongTimeFormatException();
                    }
                }

            case EVENT:
                String subStringEvent = chat.substring(6);
                if (subStringEvent.split(" /at ").length == 1) {
                    throw new NoTimeException(command.name());
                } else {
                    try {
                        return new Event(subStringEvent.split(" /at ")[0], false,
                                LocalDateTime.parse(subStringEvent.split(" /at ")[1], TIME_FORMAT));
                    } catch (Exception e) {
                        throw new WrongTimeFormatException();
                    }
                }

            default:
                throw new NoCommandException(command.name());
            }
        } else {
            switch (command) {
            case TODO:
                throw new NoDescriptionException(command.name());
            case DEADLINE:
                throw new NoDescriptionException(command.name());
            case EVENT:
                throw new NoDescriptionException(command.name());
            default:
                throw new NoCommandException(command.name());
            }
        }
    }

    /**
     * The method to delete task.
     * @param tasklist
     * @param chat
     * @return Duke.Task.Task object
     * @throws NoDescriptionException
     * @throws NoCommandException
     */
    public static Task delete(String chat, TaskList tasklist) throws NoDescriptionException {

        int order = tasklist.size();
        if (chat.split(" ").length == 1) {
            throw new NoDescriptionException("Duke.Task.Delete");
        } else {
            int num = Integer.parseInt(chat.split(" ")[1]) - 1;
            return new Delete(num);
        }
    }

    /**
     * The method to parse the command.
     * @param chat
     * @param tasklist
     * @return Duke.Task.Task object
     */
    public static Task parse(String chat, TaskList tasklist) {

        Commands command;

        try {
            try {
                command = Parser.Commands.valueOf(chat.toUpperCase().split(" ")[0]);
            } catch (Exception e) {
                throw new NoCommandException(chat);
            }
            switch (command) {
            case BYE:
                return new Bye();

            case LIST:
                return new List();

            case UNMARK:
                return unmark(chat, tasklist);

            case MARK:
                return mark(chat, tasklist);

            case TODO:
                return addTask(chat, tasklist);

            case DEADLINE:
                return addTask(chat, tasklist);

            case EVENT:
                return addTask(chat, tasklist);

            case DELETE:
                return delete(chat, tasklist);

            default:
                throw new NoCommandException(chat);
            }

        } catch (NoDescriptionException | NoCommandException | NoTimeException | WrongTimeFormatException e) {
            e.printStackTrace();
            return null;
        }
    }
}
