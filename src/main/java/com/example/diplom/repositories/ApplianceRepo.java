package com.example.diplom.repositories;

import com.example.diplom.entities.ApplianceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplianceRepo extends JpaRepository<ApplianceEntity, Long> {
    List<ApplianceEntity> findByModel(String model);
    List<ApplianceEntity> findByType(String name);
}
