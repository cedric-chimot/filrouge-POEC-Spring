package com.filrouge.filrouge.service;

import com.filrouge.filrouge.entity.CentreFormation;
import com.filrouge.filrouge.repository.CentreFormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CentreFormationService {

    private final CentreFormationRepository centreFormationRepository;

    @Autowired
    public CentreFormationService(CentreFormationRepository centreFormationRepository) {
        this.centreFormationRepository = centreFormationRepository;
    }

    @Transactional
    public CentreFormation centreSave(CentreFormation centreFormation) {
        return centreFormationRepository.save(centreFormation);
    }

    public Optional<CentreFormation> findById(Long id) {
        return centreFormationRepository.findById(id);
    }
}
