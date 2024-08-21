package com.jpconsultoria.ingweb.Servicios;

import com.jpconsultoria.ingweb.Entidades.Profession;
import com.jpconsultoria.ingweb.Repositorios.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionServiceImpl implements ProfessionService {

    @Autowired
    private ProfessionRepository professionRepository;

    @Override
    public List<Profession> getAllProfessions() {
        return professionRepository.findAll();
    }

    @Override
    public Profession getProfessionById(Long id) {
        return professionRepository.findById(id).orElse(null);
    }

    @Override
    public Profession createProfession(Profession profession) {
        return professionRepository.save(profession);
    }

    @Override
    public Profession updateProfession(Long id, Profession profession) {
        if (professionRepository.existsById(id)) {
            profession.setId(id);
            return professionRepository.save(profession);
        }
        return null;
    }

    @Override
    public void deleteProfession(Long id) {
        professionRepository.deleteById(id);
    }
}