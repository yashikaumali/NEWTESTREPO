package com.example.demo.controller;

import com.example.demo.request.TaskCreateUpdateRequest;
import com.example.demo.response.TaskResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskControllerTest {

    private TaskCreateUpdateRequest taskCreateUpdateRequest;
    private TaskResponse taskResponse;

    @BeforeEach
    void setUp() {
        taskCreateUpdateRequest = new TaskCreateUpdateRequest();
        taskCreateUpdateRequest.setName("Sample Task");

        taskResponse = new TaskResponse();
        taskResponse.setId(1L);
        taskResponse.setName("Sample Task");
    }

    @Test
    void testTaskCreateUpdateRequestNotNull() {
        assertNotNull(taskCreateUpdateRequest);
        assertEquals("Sample Task", taskCreateUpdateRequest.getName());
    }

    @Test
    void testTaskResponseNotNull() {
        assertNotNull(taskResponse);
        assertEquals(1L, taskResponse.getId());
        assertEquals("Sample Task", taskResponse.getName());
    }

    @Test
    void testTaskResponseWithNullName() {
        TaskResponse response = new TaskResponse();
        response.setId(2L);
        response.setName(null);

        assertNotNull(response);
        assertEquals(2L, response.getId());
        assertNull(response.getName());
    }
}

