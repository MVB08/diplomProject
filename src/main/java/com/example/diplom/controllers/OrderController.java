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


    @GetMapping("/getAll")
    public List<OrderEntity> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/getById/{id}")
    public Optional<OrderEntity> getById(@PathVariable Long id) {
        return orderService.getById(id);
    }

    @PostMapping("/create/{customerId}/{workerId}")
    public String createOrder( @RequestBody OrderDto orderDto, @PathVariable Long customerId, @PathVariable Long workerId) {
       orderService.create(orderDto, customerId, workerId);
        return "Order created";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "Order deleted";
    }

    @PutMapping("/update/{customerId}/{workerId}")
    private String updateOrder(@RequestBody OrderDto orderDto, @PathVariable Long customerId, @PathVariable Long workerId) {
        orderService.updateOrder(orderDto, customerId, workerId);
        return "Order updating";
    }

}
