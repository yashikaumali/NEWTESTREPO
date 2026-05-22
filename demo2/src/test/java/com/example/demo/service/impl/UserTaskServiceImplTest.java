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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserTaskServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private UserTaskRepository userTaskRepository;

    @InjectMocks
    private UserTaskServiceImpl userTaskService;

    private UserTaskRequest userTaskRequest;
    private User user;
    private Task task;
    private UserTask userTask;

    @BeforeEach
    void setUp() {
        // Initialize test data
        user = new User();
        user.setId(1L);
        user.setName("John Doe");
        user.setEmail("john@example.com");
        user.setActive(true);

        task = new Task();
        task.setId(1L);
        task.setName("Sample Task");
        task.setActive(true);

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
        // Arrange
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
        when(userTaskRepository.save(any(UserTask.class))).thenReturn(userTask);

        // Act
        UserTaskResponse response = userTaskService.createUseTask(userTaskRequest);

        // Assert
        assertNotNull(response);
        verify(userRepository, times(1)).findById(1L);
        verify(taskRepository, times(1)).findById(1L);
        verify(userTaskRepository, times(1)).save(any(UserTask.class));
    }

    @Test
    void testCreateUserTaskWhenUserNotFound() {
        // Arrange
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotValidUserException.class, () -> {
            userTaskService.createUseTask(userTaskRequest);
        });

        verify(userRepository, times(1)).findById(1L);
        verify(taskRepository, never()).findById(anyLong());
        verify(userTaskRepository, never()).save(any(UserTask.class));
    }

    @Test
    void testCreateUserTaskWhenUserNotFoundWithMessage() {
        // Arrange
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        NotValidUserException exception = assertThrows(NotValidUserException.class, () -> {
            userTaskService.createUseTask(userTaskRequest);
        });

        assertTrue(exception.getMessage().contains("User not found with id: 1"));
    }
}

