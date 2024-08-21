package com.jpconsultoria.ingweb.Servicios;

import com.jpconsultoria.ingweb.Entidades.Type;
import java.util.List;

public interface TypeService {
    List<Type> getAllTypes();
    Type getTypeById(Long id);
    void createType(Type type);
    void updateType(Long id, Type type);
    void deleteType(Long id);
}