package com.example.diplom.frontendControllers;

import com.example.diplom.dto.WorkerDto;
import com.example.diplom.entities.CustomerEntity;
import com.example.diplom.entities.OrderEntity;
import com.example.diplom.entities.WorkerEntity;
import com.example.diplom.repositories.WorkerRepo;
import com.example.diplom.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/work")
public class FrontEndController {

    private final WorkerDto workerDto;
    private final WorkerService workerService;
    private final WorkerRepo workerRepo;

    @Autowired
    public FrontEndController(WorkerRepo workerRepo, WorkerService workerService, WorkerDto workerDto) {
        this.workerRepo = workerRepo;
        this.workerService = workerService;
        this.workerDto = workerDto;
    }


//    @GetMapping("/")
//    public String index(Model model){
//        model.addAttribute("worker", new WorkerEntity(1L, "qwe", "asd", "123",
//                List.of(new OrderEntity(1L, null, null),
//                new OrderEntity(2L, null, null)
//        )));
//        return "index";
//   }
//    @GetMapping("/createWorker")
//    public String worker(){
//        return "worker";
//    }
//    @GetMapping("/createCustomer")
//    public String customer(){
//        return "customer";
//    }

    @GetMapping("/workers")
    public String getWorker(Model model) {
        model.addAttribute("workers", workerService.getAllWorkers());
        return "getWorker";
    }

    @GetMapping("/{id}")
    public String showWorker(@PathVariable Long id, Model model) {
        model.addAttribute("worker", workerService.getById(id));
        return "showWorker";
    }

    @GetMapping("/new")
    public String newWorker(Model model) {
        model.addAttribute("worker", new WorkerDto());
        return "newWorker";
    }

    @PostMapping()
    public String createWorker(@ModelAttribute("worker") @Valid WorkerDto worker,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "newWorker";
        workerService.create(worker);
        return "redirect:/work/workers";
    }

    @GetMapping("/{id}/edit")
    public String editWorker(Model model, @PathVariable Long id) {
        model.addAttribute("worker", workerService.getById(id));
        return "editWorker";
    }

    @PatchMapping("/edit/{id}")
    public String updateWorker(@ModelAttribute("worker") @Valid WorkerEntity worker,
                               BindingResult bindingResult, @PathVariable Long id) {
        if (bindingResult.hasErrors())
            return "editWorker";
        workerService.updateWorker(id, worker.getName(), worker.getPosition(), worker.getPhoneNumber());
        return "redirect:/work/workers";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteWorker(@PathVariable Long id) {
        workerService.deleteWorker(id);
        return "redirect:/work/workers";
    }
}
