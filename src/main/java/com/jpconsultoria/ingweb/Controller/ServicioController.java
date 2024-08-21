package com.jpconsultoria.ingweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpconsultoria.ingweb.Entidades.Servicio;
import com.jpconsultoria.ingweb.Servicios.ServicioServiceImpl;

@Controller
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private ServicioServiceImpl servicioService;

    @GetMapping("/lista")
    public String listServicios(Model model) {
        model.addAttribute("servicios", servicioService.getAllServices());
        return "servicios/index";
    }

    @GetMapping("/crear")
    public String createServicioForm(Model model) {
        model.addAttribute("servicio", new Servicio());
        return "servicios/create";
    }

    @PostMapping("/save")
    public String saveServicio(@ModelAttribute Servicio servicio) {
        servicioService.createService(servicio);
        return "redirect:/servicios/lista";
    }

    @GetMapping("/editar/{id}")
    public String editServicioForm(@PathVariable("id") Long id, Model model) {
        Servicio servicio = servicioService.getServiceById(id);
        if (servicio != null) {
            model.addAttribute("servicio", servicio);
            return "servicios/edit";
        }
        return "redirect:/servicios/lista";
    }

    @PostMapping("/update/{id}")
    public String updateServicio(@PathVariable("id") Long id, @ModelAttribute Servicio servicio) {
        servicioService.updateService(id, servicio);
        return "redirect:/servicios/lista";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteServicio(@PathVariable("id") Long id) {
        servicioService.deleteService(id);
        return "redirect:/servicios/lista";
    }
}
