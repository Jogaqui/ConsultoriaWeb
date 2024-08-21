package com.jpconsultoria.ingweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpconsultoria.ingweb.Entidades.Event;
import com.jpconsultoria.ingweb.Servicios.EventServiceImpl;

@Controller
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventServiceImpl eventService;

    @GetMapping("/lista")
    public String listEvents(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "events/index";
    }

    @GetMapping("/crear")
    public String createEventForm(Model model) {
        model.addAttribute("event", new Event());
        return "events/create";
    }

    @PostMapping("/save")
    public String saveEvent(@ModelAttribute Event event) {
        eventService.createEvent(event);
        return "redirect:/events/lista";
    }

    @GetMapping("/editar/{id}")
    public String editEventForm(@PathVariable("id") Long id, Model model) {
        Event event = eventService.getEventById(id);
        if (event != null) {
            model.addAttribute("event", event);
            return "events/edit";
        }
        return "redirect:/events/lista";
    }

    @PostMapping("/update/{id}")
    public String updateEvent(@PathVariable("id") Long id, @ModelAttribute Event event) {
        eventService.updateEvent(id, event);
        return "redirect:/events/lista";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteEvent(@PathVariable("id") Long id) {
        eventService.deleteEvent(id);
        return "redirect:/events/lista";
    }
}

