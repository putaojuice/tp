package seedu.address.model.task;

import static java.util.Objects.requireNonNull;

public class Task {

    private String description;
    private String deadline;

    /**
     * Initializes a Task with a description and deadline.
     */
    public Task(String description, String deadline) {
        requireNonNull(description);
        requireNonNull(deadline);
        this.description = description;
        this.deadline = deadline;
    }

    /**
     * Updates description of task
     * @param newDescription new description of task
     */
    public void updateDescription(String newDescription) {
        this.description = newDescription;
    }

    /**
     * Updates deadline of task
     * @param newDeadline new deadline of task
     */
    public void updateDeadline(String newDeadline) {
        this.deadline = newDeadline;
    }

    /**
     * Getter to obtain description of task
     * @return Description of task
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Getter to obtain deadline of task if any
     * @return Deadline of task
     */
    public String getDeadline() {
        return this.deadline;
    }

    /**
     * Returns true if both task have the same description.
     * Weaker notion of equality between two tasks
     * @param otherTask Task object to be compared to
     * @return boolean if the tasks compared have the same description
     */
    public boolean isSameTask(Task otherTask) {
        if (otherTask == this) {
            return true;
        }
        return otherTask != null && otherTask.getDescription().equals(getDescription());
    }

    /**
     * Returns true if both task have the same description and deadline.
     *
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Task)) {
            return false;
        }

        Task otherTask = (Task) other;
        return otherTask.getDescription().equals(getDescription())
            && otherTask.getDeadline().equals(getDeadline());
    }

    @Override
    public String toString() {
        return "Task: " + this.description + " " + deadline;
    }
}
