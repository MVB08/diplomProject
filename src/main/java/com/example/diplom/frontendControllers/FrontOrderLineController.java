package com.example.diplom.frontendControllers;

import com.example.diplom.dto.CustomerDto;
import com.example.diplom.dto.OrderLineDto;
import com.example.diplom.entities.CustomerEntity;
import com.example.diplom.repositories.CustomerRepo;
import com.example.diplom.repositories.OrderLineRepo;
import com.example.diplom.services.ApplianceService;
import com.example.diplom.services.CustomerService;
import com.example.diplom.services.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/orderLineWeb")
public class FrontOrderLineController {

    private final OrderLineDto orderLineDto;
    private final OrderLineService orderLineService;
    private final OrderLineRepo orderLineRepo;

    @Autowired
    public FrontOrderLineController(OrderLineRepo orderLineRepo, OrderLineService orderLineService, OrderLineDto orderLineDto) {
        this.orderLineRepo = orderLineRepo;
        this.orderLineService = orderLineService;
        this.orderLineDto = orderLineDto;
    }


    @GetMapping("/all")
    public String getOrderLines(Model model) {
        model.addAttribute("allOrderLine", orderLineService.getAllOrderLines());
        return "getOrderLine";
    }

    @GetMapping("/{id}")
    public String showOrderLine(@PathVariable Long id, Model model) {
        ApplianceService applianceService;
        model.addAttribute("orderLine", orderLineService.getById(id));

        return "showOrderLine";
    }

//    @GetMapping("/new")
//    public String newCustomer(Model model) {
//        model.addAttribute("customer", new CustomerDto());
//        return "newCustomer";
//    }
//
//    @PostMapping()
//    public String createCustomer(@ModelAttribute("customer") @Valid CustomerDto customer) {
//
//        customerService.create(customer);
//        return "redirect:/customerWeb/all";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String editCustomer(Model model, @PathVariable Long id) {
//        model.addAttribute("customer", customerService.findById(id));
//        return "editCustomer";
//    }
//
//    @PatchMapping("/edit/{id}")
//    public String updateCustomer(@ModelAttribute("customer") @Valid CustomerEntity customer,
//                                 @PathVariable Long id) {
//
//        customerService.updateCustomer(id, customer.getName(), customer.getPhoneNumber());
//        return "redirect:/customerWeb/all";
//    }

}
