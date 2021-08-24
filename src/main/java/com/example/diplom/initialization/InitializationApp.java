package com.example.diplom.initialization;


import com.example.diplom.services.ApplianceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitializationApp {

private final ApplianceService applianceService;

public void initAppliance(){
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

}


}
