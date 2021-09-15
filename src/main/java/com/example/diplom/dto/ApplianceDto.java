package com.example.diplom.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ApplianceDto {

   private Long id;
   private String type;
   private String model;



}
