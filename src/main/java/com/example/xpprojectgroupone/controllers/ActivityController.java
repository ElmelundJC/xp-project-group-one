/*
USER STORIES: 1, 8, 2, 3

Controller til Activity DTO og DAO
Bruges til at sende informationer om activity til specifikke views

 */



package com.example.xpprojectgroupone.controllers;

import com.example.xpprojectgroupone.models.Activity;
import com.example.xpprojectgroupone.repositories.ActivityRepo;
import com.example.xpprojectgroupone.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ActivityController {
    private ActivityService activityService;
    private ActivityRepo activityRepo;
    @Autowired
    public ActivityController(){
        activityService = new ActivityService();
        activityRepo = new ActivityRepo();
    }
    @GetMapping("/indexActivity") //ændre til det rigtige getmapping navn når view er lavet
    public String activityList(Model model){
        model.addAttribute("activity", activityRepo.readAll());
        return "activity/activityIndex";
    }
    @GetMapping("/createActivity")
    public String createActivity(Model model){
        model.addAttribute("createActivity", new Activity());
        return "Activity/createActivity";
    }

    @PostMapping("/createActivity")
    public String createActivityToDB(@ModelAttribute Activity activity){
        activityRepo.create(activity);
        return "redirect:/indexActivity";
    }
    @GetMapping("updateActivity")
    public String updateActivityView(Model model, @RequestParam int id){
        model.addAttribute("activity", activityRepo.read(id));
        return "activity/updateActivityView";
    }
    @PostMapping("updatedActivity")
    public String updatedActivity(@ModelAttribute("activity") Activity activity) {
        activityRepo.update(activity);
        return "redirect:/indexActivity"; // ÆNDRES
    }

    @GetMapping("deleteActivity")
    public String deleteActivity(@RequestParam int id){
        activityRepo.delete(id);
        return "redirect:/indexActivity/"; // SKAL OGSÅ ÆNDRES NÅR VIEW ER KLAR
    }

    @GetMapping("home")
    public String returnHome(){
        return "home/index";
    }


}