package com.example.diplom.frontendControllers;

import com.example.diplom.dto.ApplianceDto;
import com.example.diplom.dto.WorkerDto;
import com.example.diplom.entities.ApplianceEntity;
import com.example.diplom.entities.WorkerEntity;
import com.example.diplom.repositories.ApplianceRepo;
import com.example.diplom.repositories.WorkerRepo;
import com.example.diplom.services.ApplianceService;
import com.example.diplom.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/applianceWeb")
public class FrontApplianceController {

    private final ApplianceDto applianceDto;
    private final ApplianceService applianceService;
    private final ApplianceRepo applianceRepo;

    @Autowired
    public FrontApplianceController(ApplianceRepo applianceRepo, ApplianceService applianceService, ApplianceDto applianceDto) {
        this.applianceRepo = applianceRepo;
        this.applianceService = applianceService;
        this.applianceDto = applianceDto;
    }


    @GetMapping("/all")
    public String getAppliances(Model model) {
        model.addAttribute("allAppliance", applianceService.getAllAppliance());
        return "getAppliance";
    }

    @GetMapping("/{id}")
    public String showAppliance(@PathVariable Long id, Model model) {
        model.addAttribute("appliance", applianceService.findById(id));
        return "showAppliance";
    }

    @GetMapping("/new")
    public String newAppliance(Model model) {
        model.addAttribute("appliance", new ApplianceDto());
        return "newAppliance";
    }

    @PostMapping()
    public String createAppliance(@ModelAttribute("appliance") @Valid ApplianceDto appliance) {

        applianceService.create(appliance);
        return "redirect:/applianceWeb/all";
    }

    @GetMapping("/{id}/edit")
    public String editAppliance(Model model, @PathVariable Long id) {
        model.addAttribute("appliance", applianceService.findById(id));
        return "editAppliance";
    }

    @PatchMapping("/edit/{id}")
    public String updateAppliance(@ModelAttribute("appliance") @Valid ApplianceEntity appliance,
                                  @PathVariable Long id) {

        applianceService.updateAppliance(id, appliance.getType(), appliance.getModel());
        return "redirect:/applianceWeb/all";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteAppliance(@PathVariable Long id) {
        applianceService.deleteAppliance(id);
        return "redirect:/applianceWeb/all";
    }
}
