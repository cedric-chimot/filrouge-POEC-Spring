package com.fr.cch.filrouge.services.impl;

import com.fr.cch.filrouge.entity.CentreFormation;
import com.fr.cch.filrouge.exceptions.CustomException;
import com.fr.cch.filrouge.repository.CentreFormationRepository;
import com.fr.cch.filrouge.services.AllServices;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CentreFormationServiceImpl implements AllServices<CentreFormation, Long> {

    /**
     * Le repository du centre de formation
     */
    private final CentreFormationRepository centreFormationRepository;

    /**
     * Le constructeur
     * @param centreFormationRepository le repository correspondant
     */
    public CentreFormationServiceImpl(CentreFormationRepository centreFormationRepository) {
        this.centreFormationRepository = centreFormationRepository;
    }

    /**
     * @return tous les objets existants
     */
    @Override
    public List<CentreFormation> findAll() {
        return centreFormationRepository.findAll();
    }

    /**
     * Méthode pour trouver un objet par son identifiant
     * @param id l'identifiant recherché
     * @return l'objet recherché
     */
    @Override
    public CentreFormation findById(Long id) {
        CentreFormation centreFormation = centreFormationRepository.findById(id).orElse(null);
        if (centreFormation == null) {
            throw new CustomException("CentreFormation", "id", id);
        }
        return centreFormation;
    }

    /**
     * Méthode pour créer un nouvel objet
     * @param newObj le nouvel objet
     * @return l'objet nouvellement créé
     */
    @Override
    public CentreFormation create(CentreFormation newObj) {
        return centreFormationRepository.save(newObj);
    }

    /**
     * @param centreFormation l'objet centre de formation à mettre à jour
     */
    @Override
    public CentreFormation update(CentreFormation centreFormation) {
        if (!centreFormationRepository.existsById(centreFormation.getId())) {
            throw new CustomException("CentreFormation", "id", centreFormation.getId());
        }
        centreFormationRepository.save(centreFormation);
        return centreFormation;
    }

    /**
     * @param id l'identifiant recherché
     * @return l'objet à supprimer
     */
    @Override
    public CentreFormation delete(Long id) {
        CentreFormation centreFormation = findById(id);
        if (centreFormation == null) {
            throw new CustomException("CentreFormation", "id", id);
        }
        centreFormationRepository.deleteById(id);
        return centreFormation;
    }
}
