package com.jpconsultoria.ingweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.jpconsultoria.ingweb.Entidades.Customer;
import com.jpconsultoria.ingweb.Servicios.CustomerServiceImpl;

@Controller
@RequestMapping("/clientes")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    // GET: Obtener todos los clientes y mostrar la vista "index"
    @GetMapping("/lista")
    public String listCustomers(Model model) {
        model.addAttribute("clientes", customerService.getAllCustomers());
        return "clientes/lista"; // Vista que muestra la lista de clientes
    }

    // GET: Mostrar el formulario de creación de un nuevo cliente
    @GetMapping("/crear")
    public String createCustomerForm(Model model) {
        model.addAttribute("cliente", new Customer());
        return "clientes/formulario"; // Vista que contiene el formulario de creación
    }

    // POST: Guardar un nuevo cliente
    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute Customer customer) {
        customerService.createCustomer(customer);
        return "redirect:/clientes/lista"; // Redirigir a la lista de clientes después de guardar
    }

    // GET: Mostrar el formulario de edición para un cliente existente
    @GetMapping("/editar/{id}")
    public String editCustomerForm(@PathVariable("id") Long id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            model.addAttribute("cliente", customer);
            return "clientes/edit"; // Vista que contiene el formulario de edición
        }
        return "redirect:/clientes/lista"; // Redirigir a la lista si el cliente no existe
    }

    // POST: Actualizar un cliente existente
    @PostMapping("/update/{id}")
    public String updateCustomer(@PathVariable("id") Long id, @ModelAttribute Customer customer) {
        customerService.updateCustomer(id, customer);
        return "redirect:/clientes/lista"; // Redirigir a la lista de clientes después de actualizar
    }

    // GET: Eliminar un cliente por su ID
    @GetMapping("/eliminar/{id}")
    public String deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/clientes/lista"; // Redirigir a la lista de clientes después de eliminar
    }
}
