package com.jpconsultoria.ingweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpconsultoria.ingweb.Entidades.Profession;
import com.jpconsultoria.ingweb.Servicios.InstitutionServiceImpl;
import com.jpconsultoria.ingweb.Servicios.ProfessionServiceImpl;

@Controller
@RequestMapping("/professions")
public class ProfessionController {

    @Autowired
    private ProfessionServiceImpl professionService;

    @Autowired
    private InstitutionServiceImpl institutionService;

    @GetMapping("/lista")
    public String listProfessions(Model model) {
        model.addAttribute("professions", professionService.getAllProfessions());
        return "professions/index";
    }

    @GetMapping("/crear")
    public String createProfessionForm(Model model) {
        model.addAttribute("profession", new Profession());
        model.addAttribute("institutions", institutionService.getAllInstitutions());
        return "professions/create";
    }

    @PostMapping("/save")
    public String saveProfession(@ModelAttribute Profession profession) {
        professionService.createProfession(profession);
        return "redirect:/professions/lista";
    }

    @GetMapping("/editar/{id}")
    public String editProfessionForm(@PathVariable("id") Long id, Model model) {
        Profession profession = professionService.getProfessionById(id);
        if (profession != null) {
            model.addAttribute("profession", profession);
            model.addAttribute("institutions", institutionService.getAllInstitutions());
            return "professions/edit";
        }
        return "redirect:/professions/lista";
    }

    @PostMapping("/update/{id}")
    public String updateProfession(@PathVariable("id") Long id, @ModelAttribute Profession profession) {
        professionService.updateProfession(id, profession);
        return "redirect:/professions/lista";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteProfession(@PathVariable("id") Long id) {
        professionService.deleteProfession(id);
        return "redirect:/professions/lista";
    }
}

