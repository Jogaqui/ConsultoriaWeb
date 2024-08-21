package com.jpconsultoria.ingweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpconsultoria.ingweb.Entidades.Role;
import com.jpconsultoria.ingweb.Servicios.RoleServiceImpl;

@Controller
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping("/lista")
    public String listRoles(Model model) {
        model.addAttribute("roles", roleService.getAllRoles());
        return "roles/index";
    }

    @GetMapping("/crear")
    public String createRoleForm(Model model) {
        model.addAttribute("role", new Role());
        return "roles/create";
    }

    @PostMapping("/save")
    public String saveRole(@ModelAttribute Role role) {
        roleService.createRole(role);
        return "redirect:/roles/lista";
    }

    @GetMapping("/editar/{id}")
    public String editRoleForm(@PathVariable("id") Long id, Model model) {
        Role role = roleService.getRoleById(id);
        if (role != null) {
            model.addAttribute("role", role);
            return "roles/edit";
        }
        return "redirect:/roles/lista";  // Redirect to list if not found
    }

    @PostMapping("/{id}")
    public String updateRole(@PathVariable("id") Long id, @ModelAttribute Role role) {
        Role updatedRole = roleService.updateRole(id, role);
        if (updatedRole != null) {
            return "redirect:/roles/lista";
        }
        return "redirect:/roles/lista";  // Redirect to list if update failed
    }

    @GetMapping("/eliminar/{id}")
    public String deleteRole(@PathVariable("id") Long id) {
        roleService.deleteRole(id);
        return "redirect:/roles/lista";
    }
}