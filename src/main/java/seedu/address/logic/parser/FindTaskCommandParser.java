package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.FindTaskCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class FindTaskCommandParser implements Parser<FindTaskCommand> {

        /**
         * Parses the given {@code String} of argument in the context of the FindTaskCommand
         * and returns a FindTaskCommand object for execution.
         * @throws ParseException if the user input does not conform to the expected format
         */
        public FindTaskCommand parse(String args) throws ParseException {
                requireNonNull(args);
                return new FindTaskCommand(args);
            }

        }

