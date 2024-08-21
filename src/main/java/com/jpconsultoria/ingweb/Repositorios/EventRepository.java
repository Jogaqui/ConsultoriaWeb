package com.jpconsultoria.ingweb.Repositorios;

import com.jpconsultoria.ingweb.Entidades.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
