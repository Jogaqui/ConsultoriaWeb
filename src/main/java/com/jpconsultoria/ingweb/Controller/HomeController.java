package com.jpconsultoria.ingweb.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String goHome(Model model){
        model.addAttribute("titulo", "Bienvenido");
        return "plantilla/index";
    }

    @GetMapping("/logout")
    public String salir(){
        return "redirect:/logout";
    }

}
