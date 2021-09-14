package com.example.diplom.services;


import com.example.diplom.dto.ApplianceDto;
import com.example.diplom.entities.ApplianceEntity;
import com.example.diplom.exceptions.PrivateException;
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

    private final String NOT_BE_NULL = "Id must be greater than null";
    private final String NOT_BE_EMPTY = "This value must not be empty";
    private final String NO_SUCH_APPLIANCE = "There is no such appliance";


    private final ApplianceRepo applianceRepo;

    public List<ApplianceEntity> getAllAppliance() {
        return applianceRepo.findAll();
    }

    public Optional<ApplianceEntity> findById(Long id) {
        if (id <= 0) {
            throw new PrivateException(NOT_BE_NULL);
        } else {
            return applianceRepo.findById(id);
        }
    }

    public List<ApplianceEntity> getByModel(String model) {
        if (model.isEmpty()) {
            throw new PrivateException(NOT_BE_EMPTY);
        } else {
            return applianceRepo.findByModel(model);
        }
    }

    public List<ApplianceEntity> getByQuery(String model, String type) {
        if (model != null) {
            return getByModel(model);
        } else if (type != null) {
            return getByType(type);
        } else {
            return new ArrayList<>();
        }
    }

    public List<ApplianceEntity> getByType(String type) {
        if (type.isEmpty()) {
            throw new PrivateException(NOT_BE_EMPTY);
        } else {
            return applianceRepo.findByType(type);
        }
    }

    public void initApp(String type, String model) {
        if (type.isEmpty() || model.isEmpty()) {
            throw new PrivateException(NOT_BE_EMPTY);
        } else {
            ApplianceEntity applianceEntity = new ApplianceEntity();

            applianceEntity.setType(type);
            applianceEntity.setModel(model);
            applianceRepo.save(applianceEntity);
        }
    }

    public void create(ApplianceDto applianceDto) {
        if (applianceDto.getModel().isEmpty() || applianceDto.getType().isEmpty()) {
            throw new PrivateException(NOT_BE_EMPTY);
        } else {
            initApp(applianceDto.getType(), applianceDto.getModel());
        }
    }

    public void deleteAppliance(Long id) {
        if (id <= 0) {
            throw new PrivateException(NOT_BE_NULL);
        } else {
            applianceRepo.findById(id).orElseThrow(() -> new PrivateException(NO_SUCH_APPLIANCE));
            applianceRepo.deleteById(id);
        }
    }

    public void updateAppliance(Long applianceId, String applainceType, String applianceModel) {
        if (applianceId <= 0) {
            throw new PrivateException(NOT_BE_NULL);
        } else {
            ApplianceEntity applianceEntity = applianceRepo.findById(applianceId).orElseThrow(() -> new PrivateException(NO_SUCH_APPLIANCE));
            applianceEntity.setType(applainceType);
            applianceEntity.setModel(applianceModel);
            applianceRepo.save(applianceEntity);
        }
    }
}
