package com.example.diplom.controllers;


import com.example.diplom.entities.OrderEntity;
;
import com.example.diplom.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;


    @GetMapping("/getAll")
    public List<OrderEntity> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/getById/{id}")
    public Optional<OrderEntity> getById(@PathVariable Long id) {
        return orderService.getById(id);
    }


}
