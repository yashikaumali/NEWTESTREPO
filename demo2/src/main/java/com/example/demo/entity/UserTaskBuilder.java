package com.example.demo.entity;

import com.example.demo.enums.TaskStatusEnum;

public class UserTaskBuilder {
    private Long id;
    private User user;
    private Task task;
    private TaskStatusEnum status;

    public UserTaskBuilder() {
    }

    public UserTaskBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public UserTaskBuilder user(User user) {
        this.user = user;
        return this;
    }

    public UserTaskBuilder task(Task task) {
        this.task = task;
        return this;
    }

    public UserTaskBuilder status(TaskStatusEnum status) {
        this.status = status;
        return this;
    }

    public UserTask build() {
        UserTask userTask = new UserTask();
        userTask.setId(id);
        userTask.setUser(user);
        userTask.setTask(task);
        userTask.setStatus(status);
        return userTask;
    }

    public static UserTaskBuilder builder() {
        return new UserTaskBuilder();
    }
}

