package com.fr.cch.filrouge.services;

import com.fr.cch.filrouge.entity.Stagiaire;
import com.fr.cch.filrouge.repository.StagiaireRepository;
import jakarta.transaction.Transactional;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StagiaireService {

    private final StagiaireRepository stagiaireRepository;

    public StagiaireService(StagiaireRepository stagiaireRepository) {
        this.stagiaireRepository = stagiaireRepository;
    }

    public Stagiaire createStagiaire(Stagiaire stagiaire) {
        stagiaireRepository.save(stagiaire);
        return stagiaire;
    }

}
