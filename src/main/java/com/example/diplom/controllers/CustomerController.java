package com.example.diplom.controllers;

import com.example.diplom.entities.CustomerEntity;
import com.example.diplom.entities.OrderEntity;
import com.example.diplom.initialization.InitializationCustomer;
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
    private final InitializationCustomer initializationCustomer;

    @GetMapping("/getAll")
    public List<CustomerEntity> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/getByPhone/{phone}")
    public Optional<CustomerEntity> getByPhone(@PathVariable Long phone){
        return customerService.getByPhone(phone);
    }

    @PostMapping("/init")
    public String initOrder(){
        initializationCustomer.initCustomer();
        return "Customer initialized";
    }
}
