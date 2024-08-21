package com.jpconsultoria.ingweb.Servicios;

import com.jpconsultoria.ingweb.Entidades.Area;
import com.jpconsultoria.ingweb.Repositorios.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public List<Area> getAllAreas() {
        return areaRepository.findAll();
    }

    @Override
    public Area getAreaById(Long id) {
        return areaRepository.findById(id).orElse(null);
    }

    @Override
    public Area createArea(Area area) {
        return areaRepository.save(area);
    }

    @Override
    public Area updateArea(Long id, Area area) {
        if (areaRepository.existsById(id)) {
            area.setId(id);
            return areaRepository.save(area);
        }
        return null;
    }

    @Override
    public void deleteArea(Long id) {
        areaRepository.deleteById(id);
    }
}