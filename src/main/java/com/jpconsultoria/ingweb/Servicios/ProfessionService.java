package com.jpconsultoria.ingweb.Servicios;

import com.jpconsultoria.ingweb.Entidades.Profession;
import java.util.List;

public interface ProfessionService {
    List<Profession> getAllProfessions();
    Profession getProfessionById(Long id);
    Profession createProfession(Profession profession);
    Profession updateProfession(Long id, Profession profession);
    void deleteProfession(Long id);
}