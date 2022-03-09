package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADD_TASK_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADD_TASK_DEADLINE;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.AddTaskCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new {@code AddTaskCommand} object
 */
public class AddTaskCommandParser implements Parser<AddTaskCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the {@code AddTaskCommand}
     * and returns a {@code AddTaskCommand} object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddTaskCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_ADD_TASK_DESCRIPTION, PREFIX_ADD_TASK_DEADLINE);

        String description = argMultimap.getValue(PREFIX_ADD_TASK_DESCRIPTION).orElse("");
        String deadline = argMultimap.getValue(PREFIX_ADD_TASK_DEADLINE).orElse("");

        if (deadline.equals("")) {
            // task without deadline set
            return new AddTaskCommand(description);
        } else {
            // task with deadline set
            return new AddTaskCommand(description, deadline);
        }
    }
}
