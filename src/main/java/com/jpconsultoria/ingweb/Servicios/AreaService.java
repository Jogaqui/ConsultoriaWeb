package com.jpconsultoria.ingweb.Servicios;

import com.jpconsultoria.ingweb.Entidades.Area;
import java.util.List;

public interface AreaService {
    List<Area> getAllAreas();
    Area getAreaById(Long id);
    Area createArea(Area area);
    Area updateArea(Long id, Area area);
    void deleteArea(Long id);
}