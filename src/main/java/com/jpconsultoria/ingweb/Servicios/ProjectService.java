package com.jpconsultoria.ingweb.Servicios;

import com.jpconsultoria.ingweb.Entidades.Project;
import java.util.List;

public interface ProjectService {
    List<Project> getAllProjects();
    Project getProjectById(Long id);
    Project createProject(Project project);
    // Método para actualizar un proyecto
    void updateProject(Long id, Project project);
    void deleteProject(Long id);
    List<Project> findFilteredProjects(Long institutionId, Long customerId, Long serviceId, Long areaId, Long professionId, String dni);
}

