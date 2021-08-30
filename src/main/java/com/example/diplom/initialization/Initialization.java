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
        applianceService.initApp(1L, "fridge", "Indesit");
        applianceService.initApp(2L, "fridge", "Atlant");
        applianceService.initApp(3L, "fridge", "Bosh");
        applianceService.initApp(4L, "tv", "Samsung");
        applianceService.initApp(5L, "tv", "LG");
        applianceService.initApp(6L, "tv", "Bosh");
        applianceService.initApp(7L, "teapot", "Redmond");
        applianceService.initApp(8L, "teapot", "Tefal");
        applianceService.initApp(9L, "teapot", "Bosh");
        applianceService.initApp(10L, "washing machine", "Bosh");
        applianceService.initApp(11L, "washing machine", "Samsung");
        applianceService.initApp(12L, "washing machine", "LG");
        applianceService.initApp(13L, "vacuum cleaner", "LG");
        applianceService.initApp(14L, "vacuum cleaner", "Karcher");
        applianceService.initApp(15L, "vacuum cleaner", "Polaris");
        applianceService.initApp(16L, "iron", "Tefal");
        applianceService.initApp(17L, "iron", "Karcher");
        applianceService.initApp(18L, "iron", "Polaris");

        workerService.init(1L, "Daniil", "Seller", 89037727272L);
        workerService.init(2L, "Anna", "Seller", 89042662626L);
        workerService.init(3L, "Valentin", "Seller", 89053211212L);

        customerService.init(1L,"Pavel", 89112343434L);
        customerService.init(2L,"Goga", 89213010101L);
        customerService.init(3L, "Alex", 89400400044L);
        customerService.init(4L,"Inna", 89215550404L);

        orderService.init(1L, 1L, 1L);
        orderService.init(2L, 1L, 2L);
        orderService.init(3L, 1L, 2L);
        orderService.init(4L, 4L, 3L);

        orderLineService.init(1L, 1L, 1L);
        orderLineService.init(2L,1L, 2L);
        orderLineService.init(3L,2L, 2L);
        orderLineService.init(4L,2L, 2L);
        orderLineService.init(5L,2L, 2L);
        orderLineService.init(6L,2L, 2L);
    }

}
