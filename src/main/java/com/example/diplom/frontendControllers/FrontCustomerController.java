package com.example.diplom.frontendControllers;

import com.example.diplom.dto.ApplianceDto;
import com.example.diplom.dto.CustomerDto;
import com.example.diplom.entities.ApplianceEntity;
import com.example.diplom.entities.CustomerEntity;
import com.example.diplom.repositories.ApplianceRepo;
import com.example.diplom.repositories.CustomerRepo;
import com.example.diplom.services.ApplianceService;
import com.example.diplom.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/customerWeb")
public class FrontCustomerController {

    private final CustomerDto customerDto;
    private final CustomerService customerService;
    private final CustomerRepo customerRepo;

    @Autowired
    public FrontCustomerController(CustomerRepo customerRepo, CustomerService customerService, CustomerDto customerDto) {
        this.customerRepo = customerRepo;
        this.customerService = customerService;
        this.customerDto = customerDto;
    }


    @GetMapping("/all")
    public String getCustomers(Model model) {
        model.addAttribute("allCustomer", customerService.getAllCustomers());
        return "getCustomer";
    }

    @GetMapping("/{id}")
    public String showCustomer(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "showCustomer";
    }

    @GetMapping("/new")
    public String newCustomer(Model model) {
        model.addAttribute("customer", new CustomerDto());
        return "newCustomer";
    }

    @PostMapping()
    public String createCustomer(@ModelAttribute("customer") @Valid CustomerDto customer) {

        customerService.create(customer);
        return "redirect:/customerWeb/all";
    }

    @GetMapping("/{id}/edit")
    public String editCustomer(Model model, @PathVariable Long id) {
        model.addAttribute("customer", customerService.findById(id));
        return "editCustomer";
    }

    @PatchMapping("/edit/{id}")
    public String updateCustomer(@ModelAttribute("customer") @Valid CustomerEntity customer,
                                  @PathVariable Long id) {

        customerService.updateCustomer(id, customer.getName(), customer.getPhoneNumber());
        return "redirect:/customerWeb/all";
    }

}
