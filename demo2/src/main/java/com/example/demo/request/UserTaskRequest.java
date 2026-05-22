package com.example.demo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserTaskRequest {

    @JsonProperty("user_id")
    @NotNull(message = "user_id cannot be null")
    @Schema( description = "required field")
    private String userId;

    @JsonProperty("task_id")
    @NotNull(message = "user_id cannot be null")
    @Schema( description = "required field")
    private String taskId;

    @JsonProperty("task_status")
    private String taskStatus;


}
