package com.example.diplom.controllers;

import com.example.diplom.dto.ApplianceDto;
import com.example.diplom.dto.CustomerDto;
import com.example.diplom.entities.ApplianceEntity;
import com.example.diplom.entities.CustomerEntity;
import com.example.diplom.entities.OrderEntity;

import com.example.diplom.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {


    private final CustomerService customerService;

    // TODO: 07.09.2021 queryparam name, phone...
    @GetMapping("/all")
    public List<CustomerEntity> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Optional<CustomerEntity> getById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @GetMapping("/{name}")
    public List<CustomerEntity> getByName(@PathVariable String name) {
        return customerService.getByName(name);
    }

    @GetMapping("/{phone}")
    public List<CustomerEntity> getByPhone(@PathVariable String phone) {
        return customerService.getByPhone(phone);
    }

    @PostMapping("/new")
    public String createCustomer(@RequestBody CustomerDto customerDto) {
        customerService.create(customerDto);
        return "Customer created";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "Customer deleted";
    }

    @PutMapping("/update/{id}/{name}/{phoneNumber}")
    private String updateCustomer(@PathVariable Long id, @PathVariable String name, @PathVariable String phoneNumber) {
        customerService.updateCustomer(id, name, phoneNumber);
        return "Customer updating";
    }
}
