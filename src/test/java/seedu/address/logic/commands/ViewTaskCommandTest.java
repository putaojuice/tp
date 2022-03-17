package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.ViewTaskCommand.MESSAGE_EMPTY_TASK_LIST;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;

public class ViewTaskCommandTest {
    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();

    @Test
    public void execute_viewTask_empty() {
        CommandResult expectedCommandResult = new CommandResult(MESSAGE_EMPTY_TASK_LIST);
        assertCommandSuccess(new ViewTaskCommand(), model, expectedCommandResult, expectedModel);
    }
}
