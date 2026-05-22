package com.example.demo.service.impl;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.request.TaskCreateUpdateRequest;
import com.example.demo.response.TaskResponse;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repo;


    @Override
    public TaskResponse createTask(TaskCreateUpdateRequest taskCreateUpdateRequest) {
        Task task = new Task();
        task.setName(taskCreateUpdateRequest.getName());
        repo.save(task);

        TaskResponse response = new TaskResponse();
        response.setId(task.getId());
        response.setName(task.getName());
        return response;
    }
}
