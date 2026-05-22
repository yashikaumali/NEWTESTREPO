package com.example.demo.service.impl;

import com.example.demo.entity.Task;
import com.example.demo.entity.User;
import com.example.demo.entity.UserTask;
import com.example.demo.entity.UserTaskBuilder;
import com.example.demo.enums.TaskStatusEnum;
import com.example.demo.exception.NotValidUserException;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserTaskRepository;
import com.example.demo.request.UserTaskRequest;
import com.example.demo.response.UserTaskResponse;
import com.example.demo.service.UserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserTaskServiceImpl implements UserTaskService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserTaskRepository userTaskRepository;

    @Override
    public UserTaskResponse createUseTask(UserTaskRequest userTaskRequest) {
        // Fetch user and task from repositories
        Optional<User> userOptional = userRepository.findById(Long.parseLong(userTaskRequest.getUserId()));

        if (!userOptional.isPresent()) {
            throw new NotValidUserException("User not found with id: " + userTaskRequest.getUserId());
        }

        User user = userOptional.get();
        Task task = taskRepository.findById(Long.parseLong(userTaskRequest.getTaskId())).orElse(null);

        // Build UserTask using the builder
        UserTask userTask = UserTaskBuilder.builder()
                .user(user)
                .task(task)
                .status(TaskStatusEnum.valueOf(userTaskRequest.getTaskStatus()))
                .build();

        // Save to database
        UserTask savedUserTask = userTaskRepository.save(userTask);

        // Create and return response
        UserTaskResponse response = new UserTaskResponse();
        return response;
    }
}
