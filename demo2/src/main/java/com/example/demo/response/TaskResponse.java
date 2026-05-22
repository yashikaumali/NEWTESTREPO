package com.example.demo.response;

import lombok.Data;

@Data
public class TaskResponse {
    private Long id;
    private String name;
    private Boolean active;
}
