package com.example.diplom.initialization;

import com.example.diplom.entities.ApplianceEntity;
import com.example.diplom.entities.OrderEntity;
import com.example.diplom.entities.OrderLine;
import com.example.diplom.repositories.ApplianceRepo;
import com.example.diplom.repositories.OrderLineRepo;
import com.example.diplom.repositories.OrderRepo;
import com.example.diplom.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class InitializationOrder {

private final OrderService orderService;
private final OrderRepo orderRepo;
private final ApplianceRepo applianceRepo;
private final OrderLineRepo orderLineRepo;

    public void initOrder() {

        orderService.init(1L, "Ivan", 1L);
        orderService.init(1L, "Alex", 3L);
        orderService.init(3L, "Inna", 4L);

    }
    @PostConstruct
    public void init(){
        OrderEntity orderEntity = new OrderEntity();
        ArrayList<OrderLine> orderLines = new ArrayList<>();
        OrderLine orderLine = new OrderLine();
        ApplianceEntity applianceEntity = new ApplianceEntity();
        applianceEntity.setType("Test type");
        applianceEntity.setModel("test Model");
        orderLine.setApplianceEntity(applianceEntity);
        orderLines.add(orderLine);
        orderEntity.setOrderLines(orderLines);
        applianceRepo.save(applianceEntity);
        orderLineRepo.save(orderLine);
        orderRepo.save(orderEntity);
    }
}
