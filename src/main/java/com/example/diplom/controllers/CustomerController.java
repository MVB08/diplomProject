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


    @GetMapping("/getAll")
    public List<CustomerEntity> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/getById/{id}")
    public Optional<CustomerEntity> getById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @GetMapping("/getByName/{name}")
    public List<CustomerEntity> getByName(@PathVariable String name) {
        return customerService.getByName(name);
    }

    @GetMapping("/getByPhone/{phone}")
    public List<CustomerEntity> getByPhone(@PathVariable Long phone) {
        return customerService.getByPhone(phone);
    }

    @PostMapping("/create")
    public String createCustomer(@RequestBody CustomerDto customerDto) {
        customerService.create(customerDto);
        return "Customer created";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "Customer deleted";
    }

    @PutMapping("/update/{id}")
    private String updateCustomer(@PathVariable Long id, @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(id, customerDto);
        return "Appliance updating";
    }
}
