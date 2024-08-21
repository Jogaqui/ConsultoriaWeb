package com.jpconsultoria.ingweb.Servicios;

import com.jpconsultoria.ingweb.Entidades.Advisor;
import java.util.List;

public interface AdvisorService {
    List<Advisor> getAllAdvisors();
    Advisor getAdvisorById(Long id);
    Advisor createAdvisor(Advisor advisor);
    Advisor updateAdvisor(Long id, Advisor advisor);
    void deleteAdvisor(Long id);
}