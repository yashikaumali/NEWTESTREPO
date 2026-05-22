package com.example.demo.controller;

import com.example.demo.request.UserTaskRequest;
import com.example.demo.response.UserTaskResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTaskControllerTest {

    private UserTaskController userTaskController;
    private UserTaskRequest userTaskRequest;

    @BeforeEach
    void setUp() {
        userTaskController = new UserTaskController();

        userTaskRequest = new UserTaskRequest();
        userTaskRequest.setUserId("1");
        userTaskRequest.setTaskId("1");
        userTaskRequest.setTaskStatus("PENDING");
    }

    @Test
    void testCreateUserTaskRequestNotNull() {
        assertNotNull(userTaskRequest);
        assertEquals("1", userTaskRequest.getUserId());
        assertEquals("1", userTaskRequest.getTaskId());
        assertEquals("PENDING", userTaskRequest.getTaskStatus());
    }

    @Test
    void testUserTaskRequestSetters() {
        UserTaskRequest request = new UserTaskRequest();
        request.setUserId("2");
        request.setTaskId("3");
        request.setTaskStatus("COMPLETED");

        assertEquals("2", request.getUserId());
        assertEquals("3", request.getTaskId());
        assertEquals("COMPLETED", request.getTaskStatus());
    }

    @Test
    void testUserTaskResponseNotNull() {
        UserTaskResponse response = new UserTaskResponse();
        assertNotNull(response);
    }

    @Test
    void testCreateUserTaskRequestWithNullUserId() {
        UserTaskRequest request = new UserTaskRequest();
        request.setUserId(null);
        request.setTaskId("1");
        request.setTaskStatus("PENDING");

        assertNull(request.getUserId());
        assertEquals("1", request.getTaskId());
        assertEquals("PENDING", request.getTaskStatus());
    }

}