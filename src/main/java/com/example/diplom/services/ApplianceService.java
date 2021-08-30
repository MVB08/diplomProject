package com.example.diplom.services;


import com.example.diplom.dto.ApplianceDto;
import com.example.diplom.entities.ApplianceEntity;
import com.example.diplom.repositories.ApplianceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplianceService {

    private final ApplianceRepo applianceRepo;

    public List<ApplianceEntity> getAllAppliance() {
        return applianceRepo.findAll();
    }

    public Optional<ApplianceEntity> findById(Long id) {
        return applianceRepo.findById(id);
    }

    public List<ApplianceEntity> getByModel(String model) {
        return applianceRepo.findByModel(model);
    }

    public List<ApplianceEntity> getByType(String type) {
        return applianceRepo.findByType(type);
    }

    public void initApp(Long applianceId, String type, String model) {

        ApplianceEntity applianceEntity = new ApplianceEntity();
        applianceEntity.setId(applianceId);
        applianceEntity.setType(type);
        applianceEntity.setModel(model);
        applianceRepo.save(applianceEntity);
    }

    public void create(ApplianceDto applianceDto) {
        initApp(applianceDto.getId(), applianceDto.getType(), applianceDto.getModel());
    }

    public void deleteAppliance(Long id) {
        applianceRepo.findById(id).orElseThrow(() -> new RuntimeException("There is no such appliance"));
        applianceRepo.deleteById(id);
    }

    public void updateAppliance(Long id, ApplianceDto applianceDto) {
        applianceRepo.findById(id).orElseThrow(() -> new RuntimeException("There is no such appliance"));
        create(applianceDto);
    }
}
