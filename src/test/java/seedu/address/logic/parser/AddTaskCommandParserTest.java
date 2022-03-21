package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.AddTaskCommand;

public class AddTaskCommandParserTest {
    private AddTaskCommandParser parser = new AddTaskCommandParser();

    @Test
    public void parse_allFieldPresent_success() {
        assertParseSuccess(parser, "addt d/description t/01/01/2022",
                new AddTaskCommand("description", "01/01/2022"));
    }

    @Test
    public void parse_optionalFieldsMissing_success() {
        assertParseSuccess(parser, "addt d/description",
                new AddTaskCommand("description"));
    }

    @Test
    public void parse_multipleDescriptions_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddTaskCommand.MESSAGE_USAGE);
        assertParseFailure(parser, "addt d/abc d/abc", expectedMessage);
    }

    @Test
    public void parse_multipleDeadline_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddTaskCommand.MESSAGE_USAGE);
        assertParseFailure(parser, "addt d/abc t/01/01/2022 t/01/01/2022", expectedMessage);
    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddTaskCommand.MESSAGE_USAGE);

        // has description prefix
        assertParseFailure(parser, "addt d/", expectedMessage);

        // has description prefix and deadline prefix
        assertParseFailure(parser, "addt d/ t/", expectedMessage);

        // no description prefix
        assertParseFailure(parser, "addt", expectedMessage);
    }

    @Test
    public void parse_deadlineFormat_success() {
        assertParseSuccess(parser, "addt d/description t/01/01/2022",
                new AddTaskCommand("description", "01/01/2022"));
    }

    @Test
    public void parse_deadlineFormat_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddTaskCommand.MESSAGE_USAGE);

        // no "/" between date, month, year
        assertParseFailure(parser, "addt d/description t/01012022", expectedMessage);

        // uses "-" between date, month, year
        assertParseFailure(parser, "addt d/description t/01-01-2022", expectedMessage);
    }

    @Test
    public void parse_deadlineFormatUseAlphabets_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddTaskCommand.MESSAGE_USAGE);

        assertParseFailure(parser, "addt d/description t/monday", expectedMessage);
        assertParseFailure(parser, "addt d/description t/o1/o1/2o22", expectedMessage);
    }

    @Test
    public void parse_deadlineFormatUseSymbols_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddTaskCommand.MESSAGE_USAGE);

        assertParseFailure(parser, "addt d/description t/!@#$%^&*(){}[]|~`", expectedMessage);
        assertParseFailure(parser, "addt d/description t/*10!2()22", expectedMessage);
    }
}
