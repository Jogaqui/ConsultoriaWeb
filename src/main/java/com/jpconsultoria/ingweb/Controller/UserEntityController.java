package com.jpconsultoria.ingweb.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpconsultoria.ingweb.Entidades.UserEntity;
import com.jpconsultoria.ingweb.Servicios.RoleServiceImpl;
import com.jpconsultoria.ingweb.Servicios.UserServiceImpl;

@Controller
@RequestMapping("/users")
public class UserEntityController {

    @Autowired
    private UserServiceImpl userEntityService;

    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping("/lista")
    public String listUsers(Model model) {
        model.addAttribute("users", userEntityService.getAllUsers());
        return "users/index";
    }

    @GetMapping("/crear")
    public String createUserForm(Model model) {
        model.addAttribute("user", new UserEntity());
        model.addAttribute("roles", roleService.getAllRoles());  // Provide roles for the select dropdown
        return "users/create";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute UserEntity userEntity) {
        userEntityService.createUser(userEntity);
        return "redirect:/users/lista";
    }

    @GetMapping("/editar/{id}")
    public String editUserForm(@PathVariable("id") Long id, Model model) {
        UserEntity userEntity = userEntityService.getUserById(id);
        if (userEntity != null) {
            model.addAttribute("user", userEntity);
            model.addAttribute("roles", roleService.getAllRoles());  // Provide roles for the select dropdown
            return "users/edit";
        }
        return "redirect:/users/lista";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute UserEntity userEntity) {
        userEntityService.updateUser(id, userEntity);
        return "redirect:/users/lista";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userEntityService.deleteUser(id);
        return "redirect:/users/lista";
    }
}

