package com.example.diplom.services;

import com.example.diplom.entities.CustomerEntity;
import com.example.diplom.entities.OrderEntity;
import com.example.diplom.entities.WorkerEntity;
import com.example.diplom.repositories.CustomerRepo;
import com.example.diplom.repositories.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo customerRepo;
    private final OrderRepo orderRepo;

    public List<CustomerEntity> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Optional<CustomerEntity> getByPhone(Long phone) {
        return customerRepo.findById(phone);
    }

    public void init(String customerName, Long phoneNumber) {
        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setName(customerName);
        customerEntity.setPhoneNumber(phoneNumber);

        customerRepo.save(customerEntity);
    }
}
