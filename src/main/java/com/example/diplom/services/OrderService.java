package com.example.diplom.services;


import com.example.diplom.entities.ApplianceEntity;
import com.example.diplom.entities.OrderEntity;
import com.example.diplom.repositories.ApplianceRepo;
import com.example.diplom.repositories.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepo orderRepo;
    private final ApplianceRepo applianceRepo;

    public List<OrderEntity> getAllOrders() {
        return orderRepo.findAll();
    }

    public Optional<OrderEntity> getById(Long id) {
        return orderRepo.findById(id);
    }


    public void init(Long orderId, String customerName, Long applId) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(orderId);
        orderEntity.setCustomerName(customerName);

        ApplianceEntity applianceEntity = applianceRepo.findById(applId).orElse(null);
//        orderEntity.setApplianceEntityList(Arrays.asList(applianceEntity));
        orderRepo.save(orderEntity);
    }

}
