package com.example.demo.service.impl;

import com.example.demo.repository.TaskRepository;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl extends TaskService {

    @Autowired
    private TaskRepository repo;


}
