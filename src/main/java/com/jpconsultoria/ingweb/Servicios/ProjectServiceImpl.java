package com.jpconsultoria.ingweb.Servicios;

import com.jpconsultoria.ingweb.Entidades.Project;
import com.jpconsultoria.ingweb.Repositorios.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private InstitutionService institutionService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ServicioService serviceService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private ProfessionService professionService;



    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void updateProject(Long id, Project project) {
        // Recuperar el proyecto existente
        Project existingProject = projectRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Project not found with id " + id));

        // Actualizar las propiedades del proyecto existente
        existingProject.setPlan(project.getPlan());
        existingProject.setEstadoPago(project.getEstadoPago());
        existingProject.setEstadoTrabajo(project.getEstadoTrabajo());
        existingProject.setFechaInicio(project.getFechaInicio());
        existingProject.setFechaFin(project.getFechaFin());
        existingProject.setFechacontactoUltima(project.getFechacontactoUltima());
        existingProject.setLinkDrive(project.getLinkDrive());
        existingProject.setObservaciones(project.getObservaciones());

        // Asignar las entidades relacionadas
        existingProject.setInstitution(institutionService.getInstitutionById(project.getInstitution().getId()));
        existingProject.setCustomer(customerService.getCustomerById(project.getCustomer().getId()));
        existingProject.setServicio(serviceService.getServiceById(project.getServicio().getId()));
        existingProject.setArea(areaService.getAreaById(project.getArea().getId()));
        existingProject.setProfession(professionService.getProfessionById(project.getProfession().getId()));

        // Guardar el proyecto actualizado
        projectRepository.save(existingProject);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public List<Project> findFilteredProjects(Long institutionId, Long customerId, Long serviceId, Long areaId, Long professionId, String dni) {
        return projectRepository.findFilteredProjects(institutionId, customerId, serviceId, areaId, professionId, dni);
    }
}
