package com.example.diplom.initialization;

import com.example.diplom.services.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitializationWorker {

    private final WorkerService workerService;

    public void initWorker() {

        workerService.init(1L, "Daniil", "Seller", 11111L, 1L);
        workerService.init(2L, "Anna", "Seller", 22222L, 2L);
        workerService.init(3L, "Valentin", "Seller", 33333L, 3L);
    }
}
