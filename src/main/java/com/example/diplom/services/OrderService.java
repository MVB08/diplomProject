package com.example.diplom.services;


import com.example.diplom.dto.OrderDto;
import com.example.diplom.entities.*;
import com.example.diplom.exceptions.PrivateException;
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

    private final String NOT_BE_NULL = "Id must be greater than null";

    private final OrderRepo orderRepo;
    private final CustomerRepo customerRepo;
    private final WorkerRepo workerRepo;


    public List<OrderEntity> getAllOrders() {
        return orderRepo.findAll();
    }

    public Optional<OrderEntity> getById(Long id) {
        if (id <= 0) {
            throw new PrivateException(NOT_BE_NULL);
        } else {
            return orderRepo.findById(id);
        }
    }

    public void init(Long customerId, Long workerId) {
        if (customerId <= 0 || workerId <= 0) {
            throw new PrivateException(NOT_BE_NULL);
        } else {
        OrderEntity orderEntity = new OrderEntity();
        CustomerEntity customerEntity = customerRepo.findById(customerId).orElseThrow(() -> new PrivateException("no such customer"));
        orderEntity.setCustomerEntity(customerEntity);
        WorkerEntity workerEntity = workerRepo.findById(workerId).orElseThrow(() -> new PrivateException("no such worker"));
        orderEntity.setWorkerEntity(workerEntity);
        orderRepo.save(orderEntity);}
    }

    public void create(Long customerId, Long workerId) {
        if (customerRepo.findById(customerId).isPresent() &&
                workerRepo.findById(workerId).isPresent()) {
            init(customerId, workerId);
        } else {
            throw new PrivateException("enter the correct values");
        }
    }

    public void deleteOrder(Long id) {
        orderRepo.findById(id).orElseThrow(() -> new PrivateException("no such order"));
        orderRepo.deleteById(id);
    }
}
