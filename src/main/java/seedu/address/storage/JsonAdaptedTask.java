package seedu.address.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.task.Task;

public class JsonAdaptedTask {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Task's %s field is missing!";

    private final String description;
    private final String deadline;

    @JsonCreator
    public JsonAdaptedTask(@JsonProperty("description") String description, @JsonProperty("deadline") String deadline) {
        this.description = description;
        this.deadline = deadline;
    }

    public JsonAdaptedTask(Task source) {
        description = source.getDescription();
        deadline = source.getDeadline();
    }

    public Task toModelType() throws IllegalValueException {
        if (description == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "description"));
        }

        final String modelDescription = description;

        if (deadline == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "deadline"));
        }

        final String modelDeadline = deadline;

        return new Task(modelDescription, modelDeadline);
    }
}
