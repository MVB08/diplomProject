package com.example.diplom.controllers;


import com.example.diplom.dto.OrderDto;
import com.example.diplom.dto.OrderLineDto;
import com.example.diplom.entities.OrderEntity;
import com.example.diplom.entities.OrderLine;
import com.example.diplom.services.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orderLine")
public class OrderLineController {

    private final OrderLineService orderLineService;

    @GetMapping("/getAll")
    public List<OrderLine> getAllOrderLines() {
        return orderLineService.getAllOrderLines();
    }

    @GetMapping("/getByLine/{numberOfLine}")
    public Optional<OrderLine> getByLine(@PathVariable Long numberOfLine) {
        return orderLineService.getById(numberOfLine);
    }

    @PostMapping("/create/{orderId}/{applianceId}")
    public String createOrderLine(@RequestBody OrderLineDto orderLineDto, @PathVariable Long orderId, @PathVariable Long applianceId) {
        orderLineService.create(orderLineDto, orderId, applianceId);
        return "OrderLine created";
    }

    @DeleteMapping("/delete/{numberOfLine}")
    public String deleteOrderLine(@PathVariable Long numberOfLine) {
        orderLineService.deleteOrderLine(numberOfLine);
        return "OrderLine deleted";
    }

    @PutMapping("/update/{orderId}/{applianceId}")
    private String updateOrderLine(@RequestBody OrderLineDto orderLineDto, @PathVariable Long orderId, @PathVariable Long applianceId) {
        orderLineService.updateOrderLine(orderLineDto, orderId, applianceId);
        return "OrderLine updating";
    }

}
