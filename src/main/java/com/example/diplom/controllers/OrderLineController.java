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

    @GetMapping("/all")
    public List<OrderLine> getAllOrderLines() {
        return orderLineService.getAllOrderLines();
    }

    @GetMapping("/{numberOfLine}")
    public Optional<OrderLine> getByLine(@PathVariable Long numberOfLine) {
        return orderLineService.getById(numberOfLine);
    }

    @PostMapping("/new/query")
    public String createOrderLine(@RequestParam(value = "orderId", required = false) Long orderId,
                                  @RequestParam(value = "applianceId", required = false) Long applianceId) {
        orderLineService.create(orderId, applianceId);
        return "OrderLine created";
    }

    @DeleteMapping("/delete/{numberOfLine}")
    public String deleteOrderLine(@PathVariable Long numberOfLine) {
        orderLineService.deleteOrderLine(numberOfLine);
        return "OrderLine deleted";
    }

}
