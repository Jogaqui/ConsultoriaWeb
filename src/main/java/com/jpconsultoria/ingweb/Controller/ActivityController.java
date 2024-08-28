package com.jpconsultoria.ingweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jpconsultoria.ingweb.Entidades.Activity;
import com.jpconsultoria.ingweb.Servicios.ActivityService;
import com.jpconsultoria.ingweb.Servicios.ChapterService;
import com.jpconsultoria.ingweb.Servicios.ProjectService;
import com.jpconsultoria.ingweb.Servicios.TypeService;

@Controller
public class ActivityController {

     @Autowired
    private ProjectService projectService;
    
    @Autowired
    private ChapterService chapterService;
    
    @Autowired
    private TypeService typeService;
    
    @Autowired
    private ActivityService activityService;

 /*    @GetMapping("/projects/{projectId}/activities/new")
    public String showNewActivityForm(@RequestParam("projectId") Long projectId, Model model) {
        model.addAttribute("activity", new Activity());
        model.addAttribute("project", projectService.getProjectById(projectId));
        model.addAttribute("chapters", chapterService.getAllChapters());
        model.addAttribute("types", typeService.getAllTypes());
        return "activities/new";
    }

    @PostMapping("/activities/save")
    public String saveActivity(@ModelAttribute Activity activity) {
        activityService.createActivity(activity);
        return "redirect:/projects/" + activity.getProject().getId() + "/activities/list";
    } */
}
