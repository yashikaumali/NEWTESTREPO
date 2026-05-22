package com.example.demo.controller;

import com.example.demo.request.UserTaskRequest;
import com.example.demo.response.UserTaskResponse;
import com.example.demo.service.UserTaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-tasks")
public class UserTaskController {

    @Autowired
    private UserTaskService userTaskService;

    @PostMapping
    public ResponseEntity<UserTaskResponse> createUserTask(
            @RequestBody @Valid UserTaskRequest userTaskRequest) {
        UserTaskResponse response = userTaskService.createUseTask(userTaskRequest);
        return ResponseEntity.ok(response);
    }
}

