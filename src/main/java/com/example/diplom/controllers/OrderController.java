package com.example.diplom.controllers;


import com.example.diplom.dto.CustomerDto;
import com.example.diplom.dto.OrderDto;
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


    @GetMapping("/all")
    public List<OrderEntity> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Optional<OrderEntity> getById(@PathVariable Long id) {
        return orderService.getById(id);
    }

    @PostMapping("/new/{customerId}/{workerId}")
    public String createOrder(@PathVariable Long customerId, @PathVariable Long workerId) {
       orderService.create( customerId, workerId);
        return "Order created";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "Order deleted";
    }
}
