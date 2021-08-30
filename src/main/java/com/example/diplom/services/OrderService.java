package com.example.diplom.services;


import com.example.diplom.dto.OrderDto;
import com.example.diplom.entities.*;
import com.example.diplom.repositories.*;
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
    private final CustomerRepo customerRepo;
    private final WorkerRepo workerRepo;

    public List<OrderEntity> getAllOrders() {
        return orderRepo.findAll();
    }

    public Optional<OrderEntity> getById(Long id) {
        return orderRepo.findById(id);
    }


    public void init(Long orderId, Long customerId, Long workerId) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(orderId);

        CustomerEntity customerEntity = customerRepo.findById(customerId).orElseThrow(() -> new RuntimeException("no such customer"));
        orderEntity.setCustomerEntity(customerEntity);
        WorkerEntity workerEntity = workerRepo.findById(workerId).orElseThrow(() -> new RuntimeException("no such worker"));
        orderEntity.setWorkerEntity(workerEntity);
        orderRepo.save(orderEntity);
    }

    public void create(OrderDto orderDto, Long customerId, Long workerId) {
        if (
                orderRepo.findById(orderDto.getOrderId()).isEmpty() &&
                        customerRepo.findById(customerId).isPresent() &&
                        workerRepo.findById(workerId).isPresent()) {
            init(orderDto.getOrderId(), customerId, workerId);
        } else {
            throw new RuntimeException("enter the correct values");
        }
    }


    public void deleteOrder(Long id) {
        orderRepo.findById(id).orElseThrow(() -> new RuntimeException("no such order"));
        orderRepo.deleteById(id);
    }

    public void updateOrder(OrderDto orderDto, Long customerId, Long workerId) {
        orderRepo.findById(orderDto.getOrderId()).orElseThrow(() -> new RuntimeException(" no such order"));
        init(orderDto.getOrderId(), customerId, workerId);

    }
}
