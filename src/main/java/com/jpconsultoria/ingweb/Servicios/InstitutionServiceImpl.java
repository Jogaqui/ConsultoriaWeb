package com.jpconsultoria.ingweb.Servicios;

import com.jpconsultoria.ingweb.Entidades.Institution;
import com.jpconsultoria.ingweb.Repositorios.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitutionServiceImpl implements InstitutionService {

    @Autowired
    private InstitutionRepository institutionRepository;

    @Override
    public List<Institution> getAllInstitutions() {
        return institutionRepository.findAll();
    }

    @Override
    public Institution getInstitutionById(Long id) {
        return institutionRepository.findById(id).orElse(null);
    }

    @Override
    public Institution createInstitution(Institution institution) {
        return institutionRepository.save(institution);
    }

    @Override
    public Institution updateInstitution(Long id, Institution institution) {
        if (institutionRepository.existsById(id)) {
            institution.setId(id);
            return institutionRepository.save(institution);
        }
        return null;
    }

    @Override
    public void deleteInstitution(Long id) {
        institutionRepository.deleteById(id);
    }
}