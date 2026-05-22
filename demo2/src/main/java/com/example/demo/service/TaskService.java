package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.request.TaskCreateUpdateRequest;
import com.example.demo.response.TaskResponse;

public interface TaskService {

    TaskResponse createTask(TaskCreateUpdateRequest taskCreateUpdateRequest);
}
