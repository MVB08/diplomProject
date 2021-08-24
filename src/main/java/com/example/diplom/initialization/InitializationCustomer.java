package com.example.diplom.initialization;

import com.example.diplom.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitializationCustomer {

   private final CustomerService customerService;

    public void initCustomer() {

        customerService.init("Roma", 123L, 1L);
        customerService.init("Roma", 321L, 2L);
        customerService.init("Roma", 222L, 3L);
    }
}
