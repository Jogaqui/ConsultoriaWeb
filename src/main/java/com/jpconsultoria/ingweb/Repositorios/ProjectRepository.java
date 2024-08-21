package com.jpconsultoria.ingweb.Repositorios;

import com.jpconsultoria.ingweb.Entidades.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p FROM Project p " +
           "WHERE (:institutionId IS NULL OR p.institution.id = :institutionId) " +
           "AND (:customerId IS NULL OR p.customer.id = :customerId) " +
           "AND (:serviceId IS NULL OR p.servicio.id = :serviceId) " +
           "AND (:areaId IS NULL OR p.area.id = :areaId) " +
           "AND (:professionId IS NULL OR p.profession.id = :professionId) " +
           "AND (:dni IS NULL OR p.customer.numDocumento = :dni)")
    List<Project> findFilteredProjects(
        @Param("institutionId") Long institutionId,
        @Param("customerId") Long customerId,
        @Param("serviceId") Long serviceId,
        @Param("areaId") Long areaId,
        @Param("professionId") Long professionId,
        @Param("dni") String dni
    );
}

