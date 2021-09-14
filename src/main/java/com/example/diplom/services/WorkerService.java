package com.example.diplom.services;

import com.example.diplom.dto.WorkerDto;
import com.example.diplom.entities.CustomerEntity;
import com.example.diplom.entities.WorkerEntity;
import com.example.diplom.exceptions.PrivateException;
import com.example.diplom.repositories.WorkerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final String NOT_BE_NULL = "Id must be greater than null";
    private final String NOT_BE_EMPTY = "This values must not be empty";
    private final String NO_SUCH_WORKER = "There is no such worker";

    private final WorkerRepo workerRepo;

    public List<WorkerEntity> getAllWorkers() {
        return workerRepo.findAll();
    }


    public Optional<WorkerEntity> getById(Long id) {
        if (id <= 0) {
            throw new PrivateException(NOT_BE_NULL);
        } else {
            return workerRepo.findById(id);
        }
    }

    public void init(String workerName, String position, String phoneNumber) {
        if (workerName.isEmpty() || position.isEmpty() || phoneNumber.isEmpty()) {
            throw new PrivateException(NOT_BE_EMPTY);
        } else {
            WorkerEntity workerEntity = new WorkerEntity();
            workerEntity.setName(workerName);
            workerEntity.setPosition(position);
            workerEntity.setPhoneNumber(phoneNumber);
            workerRepo.save(workerEntity);
        }
    }

    public List<WorkerEntity> getByName(String name) {
        if (name.isEmpty()) {
            throw new PrivateException(NOT_BE_EMPTY);
        } else {
            return workerRepo.findByName(name);
        }
    }

    public List<WorkerEntity> getByPhone(String phone) {
        if (phone.isEmpty()) {
            throw new PrivateException(NOT_BE_EMPTY);
        } else {
            return workerRepo.findByPhoneNumber(phone);
        }
    }

    public void create(WorkerDto workerDto) {
        if (workerRepo.findByPhoneNumber(workerDto.getPhoneNumber()).isEmpty()) {
            init(workerDto.getName(), workerDto.getPosition(), workerDto.getPhoneNumber());
        } else {
            throw new PrivateException("such a phoneNumber already exists ");
        }
    }

    public void deleteWorker(Long id) {
        workerRepo.findById(id).orElseThrow(() -> new PrivateException(NO_SUCH_WORKER));
        workerRepo.deleteById(id);
    }

    public void updateWorker(Long workerId, String name, String position, String phoneNumber) {
        if (name.isEmpty() && position.isEmpty() && phoneNumber.isEmpty()) {
            throw new PrivateException(NOT_BE_EMPTY);
        } else if (workerId <= 0) {
            throw new PrivateException(NOT_BE_NULL);
        } else {
            WorkerEntity workerEntity = workerRepo.findById(workerId).orElseThrow(() -> new PrivateException(NO_SUCH_WORKER));
            workerEntity.setName(name);
            workerEntity.setPosition(position);
            workerEntity.setPhoneNumber(phoneNumber);
            workerRepo.save(workerEntity);
        }
    }

    public List<WorkerEntity> getByQuery(String name, String phone) {
        if (name != null) {
            return getByName(name);
        } else if (phone != null) {
            return getByPhone(phone);
        } else {
            return new ArrayList<>();
        }
    }
}
