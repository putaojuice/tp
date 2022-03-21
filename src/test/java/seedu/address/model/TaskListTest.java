package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import seedu.address.model.task.Task;

public class TaskListTest {
    private final TaskList taskList = new TaskList();

    @Test
    public void constructor() {
        assertEquals(Collections.emptyList(), taskList.getTaskList());
    }

    @Test
    public void addTask_success() {
        ArrayList<Task> stubTaskList = new ArrayList<>();
        stubTaskList.add(new Task("description", "2022"));
        taskList.addTask(new Task("description", "2022"));
        assertEquals(stubTaskList.toString(), taskList.getTaskList().toString());
    }

    @Test
    public void addTask_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> taskList.addTask(null));
    }
}
