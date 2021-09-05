package com.example.diplom.controllers;

import com.example.diplom.dto.ApplianceDto;
import com.example.diplom.entities.ApplianceEntity;

import com.example.diplom.services.ApplianceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/appliance")
public class AppliancesController {

    private final ApplianceService applianceService;


    @GetMapping("/getAll")
    public List<ApplianceEntity> getAllAppliance() {
        return applianceService.getAllAppliance();
    }

    @GetMapping("/getById/{id}")
    public Optional<ApplianceEntity> getById(@PathVariable Long id) {
        return applianceService.findById(id);
    }

    @GetMapping("/getByModel/{model}")
    public List<ApplianceEntity> getByModel(@PathVariable String model) {
        return applianceService.getByModel(model);
    }

    @GetMapping("/getByType/{type}")
    public List<ApplianceEntity> getByType(@PathVariable String type) {
        return applianceService.getByType(type);
    }

    @PostMapping("/create")
    public String createAppliance(@RequestBody ApplianceDto applianceDto) {
        applianceService.create(applianceDto);
        return "Appliance created";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAppliance(@PathVariable Long id) {
        applianceService.deleteAppliance(id);
        return "Appliance deleted";
    }

    @PutMapping("/update/{id}/{type}/{model}")
    private String updateAppliance(@PathVariable Long id, @PathVariable String type, @PathVariable String model) {
        applianceService.updateAppliance(id, type, model);
        return "Appliance updating";
    }


}
