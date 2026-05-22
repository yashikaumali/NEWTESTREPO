package com.example.demo.controller;

import com.example.demo.entity.Task;
import com.example.demo.request.TaskCreateUpdateRequest;
import com.example.demo.response.TaskResponse;
import com.example.demo.service.TaskService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(
        @RequestBody @Valid TaskCreateUpdateRequest taskCreateUpdateRequest){
        TaskResponse response = null;
        response = this.taskService.createTask(taskCreateUpdateRequest);
        return ResponseEntity.ok(response);
    }

//    @GetMapping(value = UserURIVariable.ADDRESS+UserURI.GET_ADDRESS)
//    public ResponseEntity<Task> readById(
//            @RequestHeader String appCode,
//            @RequestHeader String tenantCode,
//            @PathVariable UUID id){
//        String response = null;
//        response = this.taskService.readByUuid(id);
//        return ResponseEntity.ok(response);
//    }
}
