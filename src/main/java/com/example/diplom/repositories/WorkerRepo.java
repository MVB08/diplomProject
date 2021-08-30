package com.example.diplom.repositories;

import com.example.diplom.entities.CustomerEntity;
import com.example.diplom.entities.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerRepo extends JpaRepository<WorkerEntity,Long> {
    List<WorkerEntity> findByName(String name);
    List<WorkerEntity> findByPhoneNumber(Long phone);

}
