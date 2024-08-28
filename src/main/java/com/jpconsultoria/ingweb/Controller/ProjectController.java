package com.jpconsultoria.ingweb.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.jpconsultoria.ingweb.Entidades.Activity;
import com.jpconsultoria.ingweb.Entidades.Chapter;
import com.jpconsultoria.ingweb.Entidades.Customer;
import com.jpconsultoria.ingweb.Entidades.Area;
import com.jpconsultoria.ingweb.Entidades.Project;
import com.jpconsultoria.ingweb.Entidades.Type;
import com.jpconsultoria.ingweb.Servicios.ProjectServiceImpl;
import com.jpconsultoria.ingweb.Servicios.InstitutionServiceImpl;
import com.jpconsultoria.ingweb.Servicios.CustomerServiceImpl;
import com.jpconsultoria.ingweb.Servicios.ServicioServiceImpl;
import com.jpconsultoria.ingweb.Servicios.ActivityService;
import com.jpconsultoria.ingweb.Servicios.AreaServiceImpl;
import com.jpconsultoria.ingweb.Servicios.ProfessionServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectServiceImpl projectService;

    @Autowired
    private InstitutionServiceImpl institutionService;

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private ServicioServiceImpl serviceService;

    @Autowired
    private AreaServiceImpl areaService;

    @Autowired
    private ProfessionServiceImpl professionService;

     @Autowired
    private ActivityService activityService;

    // Método para mostrar la vista de bitácora de actividades
    @GetMapping("/{projectId}/activities")
    public String showActivities(@PathVariable Long projectId, Model model) {
        Project project = projectService.getProjectById(projectId);
        List<Activity> activities = activityService.findByProjectId(projectId);
        model.addAttribute("project", project);
        model.addAttribute("activities", activities);
        return "activities/list";
    }

    // Método para mostrar el formulario de nueva actividad
    @GetMapping("/{projectId}/activities/new")
    public String showNewActivityForm(@PathVariable Long projectId, Model model) {
        Activity activity = new Activity();
        List<Type> types = activityService.findAllTypes();
        List<Chapter> chapters = activityService.findAllChapters();
        model.addAttribute("activity", activity);
        model.addAttribute("types", types);
        model.addAttribute("chapters", chapters);
        model.addAttribute("projectId", projectId);
        return "activities/new";
    }

    // Método para guardar la nueva actividad
    @PostMapping("/{projectId}/activities/save")
    public String saveActivity(@PathVariable Long projectId, @ModelAttribute Activity activity) {
        Project project = projectService.getProjectById(projectId);
        activity.setProject(project);
        activityService.createActivity(activity);
        return "redirect:/projects/" + projectId + "/activities";
    }

    @GetMapping("/lista")
    public String listProjects(Model model,
                               @RequestParam(name = "institution", required = false) Long institutionId,
                               @RequestParam(name = "customer", required = false) Long customerId,
                               @RequestParam(name = "servicio", required = false) Long servicioId,
                               @RequestParam(name = "area", required = false) Long areaId,
                               @RequestParam(name = "profession", required = false) Long professionId,
                               @RequestParam(name = "dni", required = false) String dni) {
        model.addAttribute("projects", projectService.findFilteredProjects(institutionId, customerId, servicioId, areaId, professionId, dni));
        model.addAttribute("institutions", institutionService.getAllInstitutions());
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("services", serviceService.getAllServices());
        model.addAttribute("areas", areaService.getAllAreas());
        model.addAttribute("professions", professionService.getAllProfessions());
        return "projects/index";
    }

    @GetMapping("/crear")
    public String createProjectForm(Model model) {
        model.addAttribute("project", new Project());
        model.addAttribute("institutions", institutionService.getAllInstitutions());
        model.addAttribute("customers", customerService.getAllCustomers());
        List<Customer> customers = customerService.getAllCustomers();
        List<Area> areas = areaService.getAllAreas();
        System.out.println("Areas: " + areas);
        System.out.println("Customers: " + customers);
        model.addAttribute("services", serviceService.getAllServices());
        model.addAttribute("areas", areaService.getAllAreas());
        model.addAttribute("professions", professionService.getAllProfessions());
        return "projects/create";
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }



    @PostMapping("/guardar")
    public String saveProject(@ModelAttribute Project project,
                              @RequestParam(name = "institution.id") Long institutionId,
                              @RequestParam(name = "customer.id") Long customerId,
                              @RequestParam(name = "servicio.id") Long servicioId,
                              @RequestParam(name = "area.id") Long areaId,
                              @RequestParam(name = "profession.id") Long professionId){
                             
        // Asignar las entidades relacionadas al proyecto
        project.setInstitution(institutionService.getInstitutionById(institutionId));
        project.setCustomer(customerService.getCustomerById(customerId));
        project.setServicio(serviceService.getServiceById(servicioId));
        project.setArea(areaService.getAreaById(areaId));
        project.setProfession(professionService.getProfessionById(professionId));

        // Guardar el proyecto
        projectService.createProject(project);
        return "redirect:/projects/lista";
    }



    @GetMapping("/editar/{id}")
    public String editProjectForm(@PathVariable("id") Long id, Model model) {
        Project project = projectService.getProjectById(id);
        if (project != null) {
            model.addAttribute("project", project);
            model.addAttribute("institutions", institutionService.getAllInstitutions());
            model.addAttribute("customers", customerService.getAllCustomers());
            model.addAttribute("servicios", serviceService.getAllServices());
            model.addAttribute("areas", areaService.getAllAreas());
            model.addAttribute("professions", professionService.getAllProfessions());
            return "projects/edit";
        }
        return "redirect:/projects/lista";
    }

/*     @PostMapping("/actualizar/{id}")
public String updateProject(@PathVariable("id") Long id,
                            @ModelAttribute("project") Project project,
                            @RequestParam(name = "institution.id") Long institutionId,
                            @RequestParam(name = "customer.id") Long customerId,
                            @RequestParam(name = "servicio.id") Long servicioId,
                            @RequestParam(name = "area.id") Long areaId,
                            @RequestParam(name = "profession.id") Long professionId) {
    // Recuperar el proyecto existente
    Project existingProject = projectService.getProjectById(id);

    // Asignar las nuevas propiedades al proyecto existente
    existingProject.setPlan(project.getPlan());
    existingProject.setEstadoPago(project.getEstadoPago());
    existingProject.setEstadoTrabajo(project.getEstadoTrabajo());
    existingProject.setFechaInicio(project.getFechaInicio());
    existingProject.setFechaFin(project.getFechaFin());
    existingProject.setFechacontactoUltima(project.getFechacontactoUltima());
    existingProject.setLinkDrive(project.getLinkDrive());
    existingProject.setObservaciones(project.getObservaciones());

    // Asignar las entidades relacionadas
    existingProject.setInstitution(institutionService.getInstitutionById(institutionId));
    existingProject.setCustomer(customerService.getCustomerById(customerId));
    existingProject.setServicio(serviceService.getServiceById(servicioId));
    existingProject.setArea(areaService.getAreaById(areaId));
    existingProject.setProfession(professionService.getProfessionById(professionId));

    // Guardar los cambios
    projectService.updateProject(existingProject);

    return "redirect:/projects/lista";
} */


    @GetMapping("/eliminar/{id}")
    public String deleteProject(@PathVariable("id") Long id) {
        projectService.deleteProject(id);
        return "redirect:/projects/lista";
    }
}