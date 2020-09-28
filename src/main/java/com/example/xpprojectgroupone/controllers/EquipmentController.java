package com.example.xpprojectgroupone.controllers;


import com.example.xpprojectgroupone.models.Equipment;
import com.example.xpprojectgroupone.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = {"/equipment"})
public class EquipmentController {
    @Autowired
    EquipmentService equipmentService;

    @GetMapping("/create")
    public String createEquipment(Model model){
        model.addAttribute("equipment", new Equipment());
        return "/equipment/create";
    }

    @PostMapping("create")
    public String addEquipment(@ModelAttribute Equipment equipment, RedirectAttributes redirectAttributes){
        equipmentService.add(equipment);
        return "redirect:/equipment/create";
    }

}
