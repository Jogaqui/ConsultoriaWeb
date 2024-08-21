package com.jpconsultoria.ingweb.Repositorios;

import com.jpconsultoria.ingweb.Entidades.Advisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvisorRepository extends JpaRepository<Advisor, Long> {
}