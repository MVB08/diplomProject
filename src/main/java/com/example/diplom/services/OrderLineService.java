package com.example.diplom.services;

import com.example.diplom.dto.OrderLineDto;
import com.example.diplom.entities.ApplianceEntity;
import com.example.diplom.entities.OrderEntity;
import com.example.diplom.entities.OrderLine;
import com.example.diplom.repositories.ApplianceRepo;
import com.example.diplom.repositories.OrderLineRepo;
import com.example.diplom.repositories.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderLineService {

    private final ApplianceRepo applianceRepo;
    private final OrderLineRepo orderLineRepo;
    private final OrderRepo orderRepo;

    public void init(Long orderId, Long applianceId) {
        OrderLine orderLine = new OrderLine();
        ApplianceEntity applianceEntity = applianceRepo.findById(applianceId).orElseThrow(() -> new RuntimeException("No such appliance"));
        orderLine.setApplianceEntity(applianceEntity);
        OrderEntity orderEntity = orderRepo.findById(orderId).orElseThrow(() -> new RuntimeException("No such order"));
        orderLine.setOrderEntity(orderEntity);
        orderLineRepo.save(orderLine);
    }

    public List<OrderLine> getAllOrderLines() {
        return orderLineRepo.findAll();
    }

    public Optional<OrderLine> getById(Long numberOfLine) {
        return orderLineRepo.findById(numberOfLine);
    }

    public void create(Long orderId, Long applianceId) {
        if (orderRepo.findById(orderId).isPresent() &&
                applianceRepo.findById(applianceId).isPresent()) {
            init(orderId, applianceId);
        } else {
            throw new RuntimeException("enter the correct values");
        }
    }

    public void deleteOrderLine(Long numberOfLine) {
        orderLineRepo.findById(numberOfLine).orElseThrow(() -> new RuntimeException("No such line"));
        orderLineRepo.deleteById(numberOfLine);
    }
}
