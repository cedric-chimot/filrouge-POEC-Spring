package com.filrouge.filrouge.service;

import com.filrouge.filrouge.entity.Formations;
import com.filrouge.filrouge.repository.FormationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class FormationsService {

    private final FormationsRepository formationsRepository;

    @Autowired
    public FormationsService(FormationsRepository formationsRepository) {
        this.formationsRepository = formationsRepository;
    }

    @Transactional
    public Formations formationsSave(Formations formations) {
        return formationsRepository.save(formations);
    }

    public Optional<Formations> findById(Long id) {
        return formationsRepository.findById(id);
    }
}

