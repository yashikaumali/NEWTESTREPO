package com.example.demo.service.impl;

import com.example.demo.entity.Task;
import com.example.demo.entity.User;
import com.example.demo.entity.UserTask;
import com.example.demo.enums.TaskStatusEnum;
import com.example.demo.exception.NotValidUserException;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserTaskRepository;
import com.example.demo.request.UserTaskRequest;
import com.example.demo.response.UserTaskResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserTaskServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private UserTaskRepository userTaskRepository;

    @InjectMocks
    private UserTaskServiceImpl userTaskService;

    private User user;
    private Task task;
    private UserTask userTask;
    private UserTaskRequest userTaskRequest;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1L);
        user.setName("John Doe");

        task = new Task();
        task.setId(1L);
        task.setName("Sample Task");

        userTask = new UserTask();
        userTask.setId(1L);
        userTask.setUser(user);
        userTask.setTask(task);
        userTask.setStatus(TaskStatusEnum.PENDING);

        userTaskRequest = new UserTaskRequest();
        userTaskRequest.setUserId("1");
        userTaskRequest.setTaskId("1");
        userTaskRequest.setTaskStatus("PENDING");
    }

    @Test
    void testCreateUserTaskSuccess() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
        when(userTaskRepository.save(any(UserTask.class))).thenReturn(userTask);

        UserTaskResponse response = userTaskService.createUseTask(userTaskRequest);

        assertNotNull(response);
    }

    @Test
    void testCreateUserTaskUserNotFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NotValidUserException.class, () -> {
            userTaskService.createUseTask(userTaskRequest);
        });
    }
}

