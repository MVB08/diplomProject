package com.example.diplom.dto;

import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class WorkerDto {

    Long id;
    String name;
    String position;
    String phoneNumber;
}
