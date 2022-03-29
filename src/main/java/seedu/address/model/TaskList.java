package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;

import seedu.address.model.task.Task;

public class TaskList {
    private final ArrayList<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
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
     *  Add a task to the taskList at a specific index.
     *
     * @param task the Task to be added which must not be null
     * @param taskId the location to be added in which must not be null
     */
    public void addTask(Task task, Integer taskId) {
        requireNonNull(task);
        requireNonNull(taskId);
        this.taskList.add(taskId - 1, task); // to convert to zero-based indexing
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

    /**
     * Provides the task in the corresponding index
     * @param taskId task id of the task to be retrieved
     * @return task with the matching ID in task list
     */
    public Task getTask(Integer taskId) {
        return taskList.get(taskId - 1); // to convert to zero-based
    }
}


