package com.filrouge.filrouge.service;

import com.filrouge.filrouge.entity.Formateurs;
import com.filrouge.filrouge.repository.FormateurRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FormateurService {

    private final FormateurRepository formateurRepository;

    @Autowired
    public FormateurService(FormateurRepository formateurRepository) {
        this.formateurRepository = formateurRepository;
    }

    @Transactional
    public Formateurs formateurSave(Formateurs formateurs) {
        return formateurRepository.save(formateurs);
    }

    public Optional<Formateurs> findById(Long id) {
        return formateurRepository.findById(id);
    }

}
