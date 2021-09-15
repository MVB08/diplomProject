package com.example.diplom.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Component
@Data
public class WorkerDto {

    Long id;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    String name;
    @NotEmpty(message = "Position should not be empty")
    String position;
    @NotEmpty(message = "Phone should not be empty")
    String phoneNumber;
}
