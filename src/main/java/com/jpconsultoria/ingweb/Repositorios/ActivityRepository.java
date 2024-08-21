package com.jpconsultoria.ingweb.Repositorios;

import com.jpconsultoria.ingweb.Entidades.Activity;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findByProjectId(Long projectId);
}
