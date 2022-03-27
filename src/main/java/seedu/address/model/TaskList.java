package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.task.Task;

public class TaskList implements ReadOnlyTaskList {
    private final ArrayList<Task> taskList;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        taskList = new ArrayList<>();
    }

    public TaskList() {}

    /**
     * Creates a TaskList using the Tasks in the {@code toBeCopied}
     */
    public TaskList(ReadOnlyTaskList toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    /**
     * Resets the existing data of this {@code TaskList} with {@code newData}.
     */
    public void resetData(ReadOnlyTaskList newData) {
        requireNonNull(newData);

        setTaskList(newData.getObservableTaskList());
    }

    public void setTaskList(List<Task> tasks) {
        this.taskList.addAll(tasks);
    }

    /**
     * Add a task to the taskList.
     *
     * @param task the Task to be added which must not be null
     */
    public void addTask(Task task) {
        requireNonNull(task);
        this.taskList.add(task);
    }

    /**
     * Returns the taskList.
     *
     * @return the taskList with all the tasks contained
     */
    public ArrayList<Task> getTaskList() {
        return this.taskList;
    }

    public int size() {
        return this.taskList.size();
    }

    public void deleteTask(Integer taskNumber) {
        taskList.remove(taskNumber - 1); // to convert to zero-based indexing
    }

    /**
     * Returns an ArrayList of matching tasks based on keyword.
     *
     * @param input the keyword input by user
     * @return the list of ordered tasks that contain the keyword
     */
    public String findTask(String input) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        for (int i = 0; i < this.taskList.size(); i++) {
            Task curr = this.taskList.get(i);
            if (curr.toString().matches("(?i).*" + input + ".*")) { //bypass case sensitivity with regex
                matchingTasks.add(curr);
            }
        }
        String orderedList = getOutput(matchingTasks);
        return orderedList;
    }

    /**
     * Returns a String of all tasks.
     *
     * @return the list of ordered tasks
     */
    public String viewTask() {
        String orderedList = getOutput(taskList);
        return orderedList;
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

    @Override
    public ObservableList<Task> getObservableTaskList() {
        ObservableList<Task> taskObservableList = FXCollections.observableArrayList(taskList);
        return taskObservableList;
    }
}


