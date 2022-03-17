package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * View all tasks currently in the task list.
 */
public class ViewTaskCommand extends Command {

    public static final String COMMAND_WORD = "viewt";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": View all tasks in the task list. \n"
            + "Format: viewt";

    public static final String MESSAGE_EMPTY_TASK_LIST = "You have no task in the task list.";

    private String result;

    /**
     * Initializes a ViewTaskCommand with result set to empty string.
     */
    public ViewTaskCommand() {
        this.result = "";
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireAllNonNull(model);

        this.result = model.viewTaskList();

        if (this.result.equals("")) {
            return new CommandResult(String.format(MESSAGE_EMPTY_TASK_LIST));
        }

        return new CommandResult(String.format(result));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ViewTaskCommand)) {
            return false;
        }

        // state check
        ViewTaskCommand e = (ViewTaskCommand) other;
        return result.equals(e.result);
    }
}
