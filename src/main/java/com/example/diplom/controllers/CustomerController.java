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

    @GetMapping("/all")
    public List<CustomerEntity> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Optional<CustomerEntity> getById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @GetMapping("/query")
    public List<CustomerEntity> getByParam(@RequestParam(value = "name", required = false) String name,
                                          @RequestParam(value = "phone", required = false) String phone) {

        return customerService.getByQuery(name, phone);
    }

    @PostMapping("/new")
    public String createCustomer(@RequestBody CustomerDto customerDto) {
        customerService.create(customerDto);
        return "Customer created";
    }

    @PutMapping("/update/{id}/{name}/{phoneNumber}")
    private String updateCustomer(@PathVariable Long id, @PathVariable String name, @PathVariable String phoneNumber) {
        customerService.updateCustomer(id, name, phoneNumber);
        return "Customer updating";
    }
}
