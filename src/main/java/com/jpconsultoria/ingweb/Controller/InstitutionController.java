package com.jpconsultoria.ingweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpconsultoria.ingweb.Entidades.Institution;
import com.jpconsultoria.ingweb.Servicios.InstitutionServiceImpl;

@Controller
@RequestMapping("/institutions")
public class InstitutionController {

    @Autowired
    private InstitutionServiceImpl institutionService;

    @GetMapping("/lista")
    public String listInstitutions(Model model) {
        model.addAttribute("institutions", institutionService.getAllInstitutions());
        return "institutions/index";
    }

    @GetMapping("/crear")
    public String createInstitutionForm(Model model) {
        model.addAttribute("institution", new Institution());
        return "institutions/create";
    }

    @PostMapping("/save")
    public String saveInstitution(@ModelAttribute Institution institution) {
        institutionService.createInstitution(institution);
        return "redirect:/institutions/lista";
    }

    @GetMapping("/editar/{id}")
    public String editInstitutionForm(@PathVariable("id") Long id, Model model) {
        Institution institution = institutionService.getInstitutionById(id);
        if (institution != null) {
            model.addAttribute("institution", institution);
            return "institutions/edit";
        }
        return "redirect:/institutions/lista";
    }

    @PostMapping("/update/{id}")
    public String updateInstitution(@PathVariable("id") Long id, @ModelAttribute Institution institution) {
        institutionService.updateInstitution(id, institution);
        return "redirect:/institutions/lista";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteInstitution(@PathVariable("id") Long id) {
        institutionService.deleteInstitution(id);
        return "redirect:/institutions/lista";
    }
}

