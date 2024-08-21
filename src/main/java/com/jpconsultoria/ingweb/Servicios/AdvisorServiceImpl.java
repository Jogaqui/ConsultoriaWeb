package com.jpconsultoria.ingweb.Servicios;

import com.jpconsultoria.ingweb.Entidades.Advisor;
import com.jpconsultoria.ingweb.Repositorios.AdvisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvisorServiceImpl implements AdvisorService {

    @Autowired
    private AdvisorRepository advisorRepository;

    @Override
    public List<Advisor> getAllAdvisors() {
        return advisorRepository.findAll();
    }

    @Override
    public Advisor getAdvisorById(Long id) {
        return advisorRepository.findById(id).orElse(null);
    }

    @Override
    public Advisor createAdvisor(Advisor advisor) {
        return advisorRepository.save(advisor);
    }

    @Override
    public Advisor updateAdvisor(Long id, Advisor advisor) {
        if (advisorRepository.existsById(id)) {
            advisor.setId(id);
            return advisorRepository.save(advisor);
        }
        return null;
    }

    @Override
    public void deleteAdvisor(Long id) {
        advisorRepository.deleteById(id);
    }
}
