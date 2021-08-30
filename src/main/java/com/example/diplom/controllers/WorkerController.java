package com.example.diplom.controllers;


import com.example.diplom.dto.CustomerDto;
import com.example.diplom.dto.WorkerDto;
import com.example.diplom.entities.CustomerEntity;
import com.example.diplom.entities.OrderEntity;
import com.example.diplom.entities.WorkerEntity;

import com.example.diplom.services.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/worker")
public class WorkerController {

    private final WorkerService workerService;


    @GetMapping("/getAll")
    public List<WorkerEntity> getAllWorkers() {
        return workerService.getAllWorkers();
    }

    @GetMapping("/getById/{id}")
    public Optional<WorkerEntity> getById(@PathVariable Long id) {
        return workerService.getById(id);
    }

    @GetMapping("/getByName/{name}")
    public List<WorkerEntity> getByName(@PathVariable String name) {
        return workerService.getByName(name);
    }

    @GetMapping("/getByPhone/{phone}")
    public List<WorkerEntity> getByPhone(@PathVariable Long phone) {
        return workerService.getByPhone(phone);
    }

    @PostMapping("/create")
    public String createWorker(@RequestBody WorkerDto workerDto) {
        workerService.create(workerDto);
        return "Worker created";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteWorker(@PathVariable Long id) {
        workerService.deleteWorker(id);
        return "Worker deleted";
    }

    @PutMapping("/update/{id}")
    private String updateWorker(@PathVariable Long id, @RequestBody WorkerDto workerDto) {
        workerService.updateWorker(id, workerDto);
        return "Worker updating";
    }

}
