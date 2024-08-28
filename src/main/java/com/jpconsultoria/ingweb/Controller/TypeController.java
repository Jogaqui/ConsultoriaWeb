package com.jpconsultoria.ingweb.Controller;

import com.jpconsultoria.ingweb.Entidades.Type;
import com.jpconsultoria.ingweb.Servicios.TypeService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/types")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/lista")
    public String listTypes(Model model) {
        model.addAttribute("types", typeService.getAllTypes());
        return "types/index";
    }

    @GetMapping("/crear")
    public String createTypeForm(Model model) {
        model.addAttribute("type", new Type());
        return "types/create";
    }

    @PostMapping("/guardar")
    public String saveType(@ModelAttribute @Valid Type type, BindingResult result) {
        if (result.hasErrors()) {
            return "types/create";
        }
        typeService.createType(type);
        return "redirect:/types/lista";
    }

    @GetMapping("/editar/{id}")
    public String editTypeForm(@PathVariable("id") Long id, Model model) {
        Type type = typeService.getTypeById(id);
        if (type != null) {
            model.addAttribute("type", type);
            return "types/edit";
        }
        return "redirect:/types/lista";
    }

    @PostMapping("/actualizar/{id}")
    public String updateType(@PathVariable("id") Long id, @ModelAttribute Type type) {
        typeService.updateType(id, type);
        return "redirect:/types/lista";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteType(@PathVariable("id") Long id) {
        typeService.deleteType(id);
        return "redirect:/types/lista";
    }
}