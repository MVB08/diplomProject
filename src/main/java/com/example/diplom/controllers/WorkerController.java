package com.example.diplom.controllers;


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


}
