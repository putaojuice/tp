package seedu.address.logic.commands;


import static java.util.Objects.requireNonNull;

import java.util.ArrayList;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.task.Task;

/**
 * finds a task to the system based on user input.
 */
public class FindTaskCommand extends Command {

    public static final String COMMAND_WORD = "findt";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": finds a task based on keywords. \n"
            + "Format: findt [INPUT] \n"
            + "Example: " + COMMAND_WORD + " " + "Swimming lessons";

    public static final String MESSAGE_ARGUMENTS = "Here are the matching tasks in the list:\n" + "%1$s";

    public static final String MESSAGE_NO_DESCRIPTION = "Unable to find any matching tasks due to empty keyword";

    public static final String MESSAGE_NO_MATCHING_TASK = "Unable to find any matching tasks based on input";

    private final String input;

    /**
     * Initializes a FindTaskCommand with the given input.
     */
    public FindTaskCommand(String input) {
        requireNonNull(input);
        this.input = input;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        if (this.input.equals("")) {
            throw new CommandException(MESSAGE_NO_DESCRIPTION + "\n" + MESSAGE_USAGE);
        }
        ArrayList<Task> matchingList = model.findTask(input);
        String output = getOutput(matchingList);

        if (matchingList.size() == 0) {
            throw new CommandException(MESSAGE_NO_MATCHING_TASK);
        }

        // Ensure that tasklist is not changed, to be deleted later
        System.out.println(model.findTask(input).toString());

        return new CommandResult(String.format(MESSAGE_ARGUMENTS, output));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FindTaskCommand)) {
            return false;
        }

        //state check
        FindTaskCommand e = (FindTaskCommand) other;
        return input.equals(e.input);
    }

    /**
     * Provides an ordered list of tasks that contains keyword.
     *
     * @param list - the list of tasks that matches keyword
     * @return String of ordered list of tasks.
     */
    private String getOutput(ArrayList<Task> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            int order = i + 1;
            if (i == list.size() - 1) {
                sb.append(order).append(". ").append(list.get(i).toString());
            } else {
                sb.append(order).append(". ").append(list.get(i).toString()).append("\n");
            }
        }
        return sb.toString();
    }
}

