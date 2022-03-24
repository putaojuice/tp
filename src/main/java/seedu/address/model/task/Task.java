package seedu.address.model.task;

import static java.util.Objects.requireNonNull;

public class Task {
    private final String description;
    private final String deadline;

    /**
     * Initializes a Task with a description and deadline.
     */
    public Task(String description, String deadline) {
        requireNonNull(description);
        requireNonNull(deadline);
        this.description = description;
        this.deadline = deadline;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDeadline() {
        return this.deadline;
    }

    @Override
    public String toString() {
        return "Task: " + this.description + " " + deadline;
    }
}
