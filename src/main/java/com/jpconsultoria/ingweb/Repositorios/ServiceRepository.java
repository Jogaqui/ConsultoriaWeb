package com.jpconsultoria.ingweb.Repositorios;

import com.jpconsultoria.ingweb.Entidades.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Servicio, Long> {
}