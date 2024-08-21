package com.jpconsultoria.ingweb.Servicios;

import com.jpconsultoria.ingweb.Entidades.Institution;
import java.util.List;

public interface InstitutionService {
    List<Institution> getAllInstitutions();
    Institution getInstitutionById(Long id);
    Institution createInstitution(Institution institution);
    Institution updateInstitution(Long id, Institution institution);
    void deleteInstitution(Long id);
}