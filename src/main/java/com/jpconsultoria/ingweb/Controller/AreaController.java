package com.jpconsultoria.ingweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpconsultoria.ingweb.Entidades.Area;
import com.jpconsultoria.ingweb.Servicios.AreaServiceImpl;

@Controller
@RequestMapping("/areas")
public class AreaController {

    @Autowired
    private AreaServiceImpl areaService;

    @GetMapping("/lista")
    public String listAreas(Model model) {
        model.addAttribute("areas", areaService.getAllAreas());
        return "areas/index";
    }

    @GetMapping("/crear")
    public String createAreaForm(Model model) {
        model.addAttribute("area", new Area());
        return "areas/create";
    }

    @PostMapping("/save")
    public String saveArea(@ModelAttribute Area area) {
        areaService.createArea(area);
        return "redirect:/areas/lista";
    }

    @GetMapping("/editar/{id}")
    public String editAreaForm(@PathVariable("id") Long id, Model model) {
        Area area = areaService.getAreaById(id);
        if (area != null) {
            model.addAttribute("area", area);
            return "areas/edit";
        }
        return "redirect:/areas/lista";
    }

    @PostMapping("/update/{id}")
    public String updateArea(@PathVariable("id") Long id, @ModelAttribute Area area) {
        areaService.updateArea(id, area);
        return "redirect:/areas/lista";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteArea(@PathVariable("id") Long id) {
        areaService.deleteArea(id);
        return "redirect:/areas/lista";
    }
}