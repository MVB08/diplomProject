package com.example.diplom.initialization;

import com.example.diplom.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class Initialization {

    private final OrderService orderService;
    private final CustomerService customerService;
    private final ApplianceService applianceService;
    private final OrderLineService orderLineService;
    private final WorkerService workerService;

    @PostConstruct
    public void init() {
        applianceService.initApp( "fridge", "Indesit");
        applianceService.initApp( "fridge", "Atlant");
        applianceService.initApp( "fridge", "Bosh");
        applianceService.initApp( "tv", "Samsung");
        applianceService.initApp( "tv", "LG");
        applianceService.initApp( "tv", "Bosh");
        applianceService.initApp( "teapot", "Redmond");
        applianceService.initApp( "teapot", "Tefal");
        applianceService.initApp( "teapot", "Bosh");
        applianceService.initApp( "washing machine", "Bosh");
        applianceService.initApp( "washing machine", "Samsung");
        applianceService.initApp( "washing machine", "LG");
        applianceService.initApp( "vacuum cleaner", "LG");
        applianceService.initApp( "vacuum cleaner", "Karcher");
        applianceService.initApp( "vacuum cleaner", "Polaris");
        applianceService.initApp( "iron", "Tefal");
        applianceService.initApp( "iron", "Karcher");
        applianceService.initApp( "iron", "Polaris");

        workerService.init( "Daniil", "Seller", 89037727272L);
        workerService.init( "Anna", "Seller", 89042662626L);
        workerService.init( "Valentin", "Seller", 89053211212L);

        customerService.init("Pavel", "89112343434");
        customerService.init("Goga", "89213010101");
        customerService.init( "Alex", "89400400044");
        customerService.init("Inna", "89215550404");

        orderService.init(1L, 1L);
        orderService.init( 1L, 2L);
        orderService.init( 1L, 2L);
        orderService.init( 4L, 3L);

        orderLineService.init( 1L, 1L);
        orderLineService.init(1L, 2L);
        orderLineService.init(2L, 2L);
        orderLineService.init(2L, 2L);
        orderLineService.init(2L, 2L);
        orderLineService.init(2L, 2L);
    }

}
