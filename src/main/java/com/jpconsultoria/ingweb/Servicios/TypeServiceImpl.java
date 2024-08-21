package com.jpconsultoria.ingweb.Servicios;

import com.jpconsultoria.ingweb.Entidades.Type;
import com.jpconsultoria.ingweb.Repositorios.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    @Override
    public Type getTypeById(Long id) {
        return typeRepository.findById(id).orElse(null);
    }

    @Override
    public void createType(Type type) {
        typeRepository.save(type);
    }

    @Override
    public void updateType(Long id, Type type) {
        if (typeRepository.existsById(id)) {
            type.setId(id);
            typeRepository.save(type);
        }
    }

    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }
}
