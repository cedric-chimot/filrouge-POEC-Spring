package com.fr.cch.filrouge.services.impl;

import com.fr.cch.filrouge.entity.Stagiaire;
import com.fr.cch.filrouge.exceptions.CustomException;
import com.fr.cch.filrouge.repository.StagiaireRepository;
import com.fr.cch.filrouge.services.AllServices;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StagiaireServiceImpl implements AllServices<Stagiaire, Long> {

    private final StagiaireRepository stagiaireRepository;

    public StagiaireServiceImpl(StagiaireRepository stagiaireRepository) {
        this.stagiaireRepository = stagiaireRepository;
    }

    /**
     * @return tous les stagiaires
     */
    @Override
    public List<Stagiaire> findAll() {
        return stagiaireRepository.findAll();
    }

    /**
     * @param id l'identifiant recherché
     * @return le stagiaire correspondant
     */
    @Override
    public Stagiaire findById(Long id) {
        return stagiaireRepository.findById(id).orElse(null);
    }

    /**
     * @param newObj le nouvel objet stagiaire
     * @return le stagiaire nouvellement créé
     */
    @Override
    public Stagiaire create(Stagiaire newObj) {
        return stagiaireRepository.save(newObj);
    }

    /**
     * @param stagiaire l'objet stagiaire à mettre à jour
     */
    @Override
    public Stagiaire update(Stagiaire stagiaire) {
        if (!stagiaireRepository.existsById(stagiaire.getId())) {
            throw new CustomException("Stagiaire", "id", stagiaire.getId());
        }
        stagiaireRepository.save(stagiaire);
        return stagiaire;
    }

    /**
     * @param id l'identifiant recherché
     * @return le stagiaire à supprimer
     */
    @Override
    public Stagiaire delete(Long id) {
        Stagiaire stagiaire = findById(id);
        if (stagiaire == null) {
            throw new CustomException("Stagiaire", "id", id);
        }
        stagiaireRepository.deleteById(id);
        return stagiaire;
    }

}
