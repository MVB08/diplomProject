package com.example.diplom.services;

import com.example.diplom.entities.ApplianceEntity;
import com.example.diplom.entities.OrderEntity;
import com.example.diplom.entities.OrderLine;
import com.example.diplom.repositories.ApplianceRepo;
import com.example.diplom.repositories.OrderLineRepo;
import com.example.diplom.repositories.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineService {


    private final ApplianceRepo applianceRepo;
    private final OrderLineRepo orderLineRepo;
    private final OrderRepo orderRepo;

    public void init(Long orderId, Long applianceId) {
        ApplianceEntity applianceEntity = applianceRepo.findById(applianceId).orElseThrow(() -> new RuntimeException("No such appliance"));
        OrderLine orderLine = new OrderLine();
        orderLine.setApplianceEntity(applianceEntity);

        OrderEntity orderEntity = orderRepo.findById(orderId).orElseThrow(() -> new RuntimeException("No such order"));
        orderLine.setOrderEntity(orderEntity);
        orderLineRepo.save(orderLine);
    }

}
