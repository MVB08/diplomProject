package com.example.diplom.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CustomerDto {

    Long id;
    String name;
    String phoneNumber;

}
