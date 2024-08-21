package com.jpconsultoria.ingweb.Servicios;

import com.jpconsultoria.ingweb.Entidades.Servicio;
import java.util.List;

public interface ServicioService {
    List<Servicio> getAllServices();
    Servicio getServiceById(Long id);
    Servicio createService(Servicio service);
    Servicio updateService(Long id, Servicio service);
    void deleteService(Long id);
}
