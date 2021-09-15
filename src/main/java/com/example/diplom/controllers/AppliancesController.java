package com.example.diplom.controllers;

import com.example.diplom.dto.ApplianceDto;
import com.example.diplom.entities.ApplianceEntity;

import com.example.diplom.repositories.ApplianceRepo;
import com.example.diplom.services.ApplianceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/appliance")
public class AppliancesController {

    private final ApplianceService applianceService;


    @GetMapping("/all")
    public List<ApplianceEntity> getAllAppliance() {
        return applianceService.getAllAppliance();
    }

    @GetMapping("/{id}")
    public ApplianceEntity getById(@PathVariable Long id) {

        return applianceService.findById(id);
    }

    @GetMapping("/query")
    public List<ApplianceEntity> getByParam(@RequestParam(value = "model", required = false) String model,
                                            @RequestParam(value = "type", required = false) String type) {

        return applianceService.getByQuery(model, type);
    }

    @PostMapping("/new")
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
