package com.example.diplom.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class OrderLineDto {

    private Long numberOfLine;
}
