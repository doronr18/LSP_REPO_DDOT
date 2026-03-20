package org.howard.edu.lsp.midterm.crccards;

import java.util.*;

/**
 * Manages a collection of Task objects.
 * Provides methods to add tasks, find tasks by ID, and retrieve tasks by status.
 * Prevents duplicate task IDs.
 * 
 * Author: Doron Reid
 */

public class TaskManager {

    private Map<String, Task> tasks;

    /**
     * Constructs a TaskManager using a HashMap for efficient task storage.
     */
    public TaskManager() {
        tasks = new HashMap<>();
    }

    /**
     * Adds a new task to the manager.
     * Throws IllegalArgumentException if duplicate task ID exists.
     * @param task Task to add
     * @throws IllegalArgumentException if duplicate taskId
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Duplicate task ID");
        }
        tasks.put(task.getTaskId(), task);
    }

    /**
     * Finds a task by its ID.
     * @param taskId ID of the task to find
     * @return Task object with matching ID, or null if not found
     */
    public Task findTask(String taskId) {
        return tasks.getOrDefault(taskId, null);
    }

    /**
     * Returns a list of tasks matching the given status.
     * @param status the status to filter tasks by
     * @return List of tasks with the specified status
     */
    public List<Task> getTasksByStatus(String status) {
        List<Task> taskResult = new ArrayList<>();

        for (Task task : tasks.values()) {
            if (task.getStatus().equals(status)) {
                taskResult.add(task);
            }
        }

        return taskResult;
    }
} 


