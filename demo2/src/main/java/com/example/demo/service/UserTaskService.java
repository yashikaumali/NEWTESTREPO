package com.example.demo.service;

import com.example.demo.request.UserTaskRequest;
import com.example.demo.response.UserTaskResponse;

public interface UserTaskService {


    UserTaskResponse createUseTask(UserTaskRequest userTaskRequest);
}
