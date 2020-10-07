package com.example.xpprojectgroupone.controllers;

import com.example.xpprojectgroupone.models.Reservation;
import com.example.xpprojectgroupone.repositories.ActivityRepo;
import com.example.xpprojectgroupone.repositories.EquipmentRepo;
import com.example.xpprojectgroupone.repositories.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/reservations")
@Controller
public class ReservationController {
    @Autowired
    ReservationRepo rr;
    @Autowired
    ActivityRepo ar;
    @Autowired
    EquipmentRepo er;


    //Til jer der laver front-end, går jeg ud fra I ændrer nogle ting her
    //Men en skabelon om ikke andet, om hvordan det hænger sammen
    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("reservations", rr.fetchAll());
        return "reservation/display-reservations";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("reservation", new Reservation());
        model.addAttribute("activities", ar.readAll());
        model.addAttribute("equipment", er.readAll());
        System.out.println(er.readAll().size());
        return "reservation/create-reservation";
    }

    @PostMapping("/create")
    public String add(@ModelAttribute Reservation reservation){
        rr.add(reservation);
        return "redirect:/reservations/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id){
        return "reservation/edit-reservation";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Reservation reservation){
        //rp.edit(reservation);
        return "redirect:display-reservations";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        //rp.delete(id);
        return "redirect:display-reservations";
    }

}
