package com.example.diplom.services;

import com.example.diplom.dto.CustomerDto;
import com.example.diplom.entities.CustomerEntity;
import com.example.diplom.exceptions.PrivateException;
import com.example.diplom.repositories.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final String NOT_BE_NULL = "Id must be greater than null";
    private final String NOT_BE_EMPTY = "This value must not be empty";

    private final CustomerRepo customerRepo;

    public List<CustomerEntity> getAllCustomers() {
        return customerRepo.findAll();
    }

    public List<CustomerEntity> getByPhone(String phone) {
        if (phone.isEmpty()) {
            throw new PrivateException(NOT_BE_EMPTY);
        } else {

            return customerRepo.findByPhoneNumber(phone);
        }
    }

    public void init(String customerName, String phoneNumber) {

        if (customerName.isEmpty() || phoneNumber.isEmpty()) {
            throw new PrivateException(NOT_BE_EMPTY);
        } else {
            CustomerEntity customerEntity = new CustomerEntity();
            customerEntity.setName(customerName);
            customerEntity.setPhoneNumber(phoneNumber);
            customerRepo.save(customerEntity);
        }
    }

    public CustomerEntity findById(Long id) {
        if (id <= 0) {
            throw new PrivateException(NOT_BE_NULL);
        } else {

            return customerRepo.findById(id).orElse(null);
        }
    }

    public List<CustomerEntity> getByName(String name) {
        if (name.isEmpty()) {
            throw new PrivateException(NOT_BE_EMPTY);
        } else {

            return customerRepo.findByName(name);
        }
    }

    public void create(CustomerDto customerDto) {
        if (customerDto.getPhoneNumber().isEmpty() || customerDto.getName().isEmpty()) {
            throw new PrivateException(NOT_BE_EMPTY);
        } else {
            init(customerDto.getName(), customerDto.getPhoneNumber());
        }
    }

    public void updateCustomer(Long customerId, String customerName, String phoneNumber) {
        if (customerId <= 0) {
            throw new PrivateException(NOT_BE_NULL);
        } else {
            CustomerEntity customerEntity = customerRepo.findById(customerId).orElseThrow(() -> new RuntimeException("There is no such customer"));
            customerEntity.setName(customerName);
            customerEntity.setPhoneNumber(phoneNumber);
            customerRepo.save(customerEntity);
        }

    }

    public List<CustomerEntity> getByQuery(String name, String phone) {
        if (phone != null) {
            return getByPhone(phone);
        } else if (name != null) {
            return getByName(name);
        } else {
            return new ArrayList<>();
        }
    }
}
