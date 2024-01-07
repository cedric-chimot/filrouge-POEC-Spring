package com.filrouge.filrouge.service;

import com.filrouge.filrouge.entity.SessionFormation;
import com.filrouge.filrouge.repository.SessionFormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SessionFormationService {

    private final SessionFormationRepository sessionFormationRepository;

    @Autowired
    public SessionFormationService(SessionFormationRepository sessionFormationRepository) {
        this.sessionFormationRepository = sessionFormationRepository;
    }

    @Transactional
    public SessionFormation sessionSave(SessionFormation sessionFormation) {
        return sessionFormationRepository.save(sessionFormation);
    }

    public Optional<SessionFormation> findById(Long id) {
        return sessionFormationRepository.findById(id);
    }

}
