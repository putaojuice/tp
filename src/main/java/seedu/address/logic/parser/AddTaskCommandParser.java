package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADD_TASK_DEADLINE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADD_TASK_DESCRIPTION;

import java.util.List;

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
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_ADD_TASK_DESCRIPTION,
                PREFIX_ADD_TASK_DEADLINE);

        try {
            List<String> description = argMultimap.getAllValues(PREFIX_ADD_TASK_DESCRIPTION);
            List<String> deadline = argMultimap.getAllValues(PREFIX_ADD_TASK_DEADLINE);

            if (description.size() > 1 || deadline.size() > 1) {
                // more than 1 "d/" or "t/" prefix were used, meaning that it is wrong format
                throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddTaskCommand.MESSAGE_USAGE));
            }
        } catch (ParseException e) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddTaskCommand.MESSAGE_USAGE));
        }

        //TODO try-catch block for deadline input has to be formatted

        String description = argMultimap.getValue(PREFIX_ADD_TASK_DESCRIPTION).orElse("");
        String deadline = argMultimap.getValue(PREFIX_ADD_TASK_DEADLINE).orElse("");

        if (description.equals("")) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddTaskCommand.MESSAGE_USAGE));
        }

        if (deadline.equals("")) {
            // task without deadline set
            return new AddTaskCommand(description);
        } else {
            // task with deadline set
            return new AddTaskCommand(description, deadline);
        }
    }
}
