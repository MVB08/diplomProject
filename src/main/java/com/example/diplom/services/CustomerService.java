package com.example.diplom.services;

import com.example.diplom.dto.CustomerDto;
import com.example.diplom.entities.CustomerEntity;
import com.example.diplom.repositories.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo customerRepo;

    public List<CustomerEntity> getAllCustomers() {
        return customerRepo.findAll();
    }

    public List<CustomerEntity> getByPhone(Long phone) {
        return customerRepo.findByPhoneNumber(phone);
    }

    public void init(Long customerId, String customerName, Long phoneNumber) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customerId);
        customerEntity.setName(customerName);
        customerEntity.setPhoneNumber(phoneNumber);
        customerRepo.save(customerEntity);
    }

    public Optional<CustomerEntity> findById(Long id) {

        return customerRepo.findById(id);
    }

    public List<CustomerEntity> getByName(String name) {

        return customerRepo.findByName(name);
    }

    public void create(CustomerDto customerDto) {
        if (
                customerRepo.findByPhoneNumber(customerDto.getPhoneNumber()).isEmpty()) {
            init(customerDto.getId(), customerDto.getName(), customerDto.getPhoneNumber());
        } else {
            throw new RuntimeException("such a phoneNumber already exists ");
        }
    }

    public void deleteCustomer(Long id) {
        customerRepo.findById(id).orElseThrow(() -> new RuntimeException("There is no such customer"));
        customerRepo.deleteById(id);
    }

    public void updateCustomer(Long id, CustomerDto customerDto) {
        customerRepo.findById(id).orElseThrow(() -> new RuntimeException("There is no such customer"));
        create(customerDto);
    }
}
