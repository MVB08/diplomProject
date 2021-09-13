package com.example.diplom.services;


import com.example.diplom.dto.ApplianceDto;
import com.example.diplom.entities.ApplianceEntity;
import com.example.diplom.repositories.ApplianceRepo;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public List<ApplianceEntity> getByQuery(String model, String type){
    if (model!=null) {
        return getByModel(model);
    } else if (type!=null) {
        return getByType(type);
    } else {
        return new ArrayList<>();
    }
}
    public List<ApplianceEntity> getByType(String type) {
        return applianceRepo.findByType(type);
    }

    public void initApp( String type, String model) {

        ApplianceEntity applianceEntity = new ApplianceEntity();

        applianceEntity.setType(type);
        applianceEntity.setModel(model);
        applianceRepo.save(applianceEntity);
    }

    public void create(ApplianceDto applianceDto) {
        initApp( applianceDto.getType(), applianceDto.getModel());
    }

    public void deleteAppliance(Long id) {
        applianceRepo.findById(id).orElseThrow(() -> new RuntimeException("There is no such appliance"));
        applianceRepo.deleteById(id);
    }

    public void updateAppliance(Long applianceId, String applainceType, String applianceModel) {
        ApplianceEntity applianceEntity = applianceRepo.findById(applianceId).orElseThrow(() -> new RuntimeException("There is no such appliance"));
        applianceEntity.setType(applainceType);
        applianceEntity.setModel(applianceModel);
        applianceRepo.save(applianceEntity);
    }
}
