package com.example.diplom.services;

import com.example.diplom.entities.ApplianceEntity;
import com.example.diplom.entities.OrderEntity;
import com.example.diplom.entities.WorkerEntity;
import com.example.diplom.repositories.OrderRepo;
import com.example.diplom.repositories.WorkerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final WorkerRepo workerRepo;
    private final OrderRepo orderRepo;

    public List<WorkerEntity> getAllWorkers() {
        return workerRepo.findAll();
    }


    public Optional<WorkerEntity> getById(Long id) {
        return workerRepo.findById(id);
    }

    public void init(Long workerId, String workerName, String position, Long phoneNumber) {
        WorkerEntity workerEntity = new WorkerEntity();
        workerEntity.setId(workerId);
        workerEntity.setName(workerName);
        workerEntity.setPosition(position);
        workerEntity.setPhoneNumber(phoneNumber);

        workerRepo.save(workerEntity);
    }
}
