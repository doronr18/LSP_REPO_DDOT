package org.howard.edu.lsp.midterm.crccards;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a task with a unique ID, description, and status.
 * Valid statuses are "OPEN", "IN_PROGRESS", and "COMPLETE".
 * If an invalid status is set, it defaults to "UNKNOWN".
 * 
 * Author: Doron Reid
 */

public class Task {

    private String taskId;
    private String description;
    private String status;

    private static final List<String> VALID_STATUSES = Arrays.asList("OPEN", "IN_PROGRESS", "COMPLETE");
    /**
     * Constructs a Task with status of OPEN as default.
     * @param taskId unique identifier for the task
     * @param description textual description of the task
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }

    /**
     * Returns the task ID.
     * @return task ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Returns the task description.
     * @return task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the task status.
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the task status: OPEN, IN_PROGRESS, COMPLETE.
     * Any invalid value sets status to UNKNOWN.
     * @param status new status for the task
     */
    public void setStatus(String status) {
        if (VALID_STATUSES.contains(status)) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }

    /**
     * Returns formatted string representation of the task.
     * Format: taskId description [status]
     * @return formatted task string
     */
    @Override
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}