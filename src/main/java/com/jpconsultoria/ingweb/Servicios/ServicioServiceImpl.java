package com.jpconsultoria.ingweb.Servicios;

import com.jpconsultoria.ingweb.Entidades.Servicio;
import com.jpconsultoria.ingweb.Repositorios.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioServiceImpl implements ServicioService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<Servicio> getAllServices() {
        return serviceRepository.findAll();
    }

    @Override
    public Servicio getServiceById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public Servicio createService(Servicio service) {
        return serviceRepository.save(service);
    }

    @Override
    public Servicio updateService(Long id, Servicio service) {
        if (serviceRepository.existsById(id)) {
            service.setId(id);
            return serviceRepository.save(service);
        }
        return null;
    }

    @Override
    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
}
