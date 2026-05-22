package com.example.demo.service.impl;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.request.TaskCreateUpdateRequest;
import com.example.demo.response.TaskResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    private TaskCreateUpdateRequest taskCreateUpdateRequest;
    private Task task;

    @BeforeEach
    void setUp() {
        taskCreateUpdateRequest = new TaskCreateUpdateRequest();
        taskCreateUpdateRequest.setName("Test Task");

        task = new Task();
        task.setId(1L);
        task.setName("Test Task");
    }

    @Test
    void testCreateTaskSuccess() {
        when(taskRepository.save(any(Task.class))).thenReturn(task);

        TaskResponse response = taskService.createTask(taskCreateUpdateRequest);

        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals("Test Task", response.getName());
    }

    @Test
    void testCreateTaskResponseNotNull() {
        when(taskRepository.save(any(Task.class))).thenReturn(task);

        TaskResponse response = taskService.createTask(taskCreateUpdateRequest);

        assertNotNull(response);
    }

    @Test
    void testCreateTaskNameMatch() {
        when(taskRepository.save(any(Task.class))).thenReturn(task);

        TaskResponse response = taskService.createTask(taskCreateUpdateRequest);

        assertEquals("Test Task", response.getName());
    }
}

