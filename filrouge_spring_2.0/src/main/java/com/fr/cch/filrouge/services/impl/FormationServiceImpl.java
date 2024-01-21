package com.fr.cch.filrouge.services.impl;

import com.fr.cch.filrouge.entity.Formation;
import com.fr.cch.filrouge.exceptions.CustomException;
import com.fr.cch.filrouge.repository.FormationRepository;
import com.fr.cch.filrouge.services.AllServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FormationServiceImpl implements AllServices<Formation, Long> {

    private final FormationRepository formationRepository;

    @Autowired
    public FormationServiceImpl(FormationRepository formationRepository) {
        this.formationRepository = formationRepository;
    }

    /**
     * @return la liste des formations
     */
    @Override
    public List<Formation> findAll() {
        return formationRepository.findAll();
    }

    /**
     * Méthode pour trouver une formation par son id
     * @param id l'identifiant recherché
     * @return la formation trouvé
     */
    @Override
    public Formation findById(Long id) {
        Formation formation = formationRepository.findById(id).orElse(null);
        if(formation == null) {
            throw new CustomException("Formation", "id", id);
        }
        return formation;
    }

    /**
     * @param newObj le nouvel objet formation
     * @return la formation nouvellement créée
     */
    @Override
    public Formation create(Formation newObj) {
        return formationRepository.save(newObj);
    }

    /**
     * Méthode pour mettre à jou une formation
     * @param formation l'objet à mettre à jour
     * @return la formation mise à jour
     */
    @Override
    public Formation update(Formation formation) {
        if (!formationRepository.existsById(formation.getId())) {
            throw new CustomException("Formation", "id", formation.getId());
        }
        formationRepository.save(formation);
        return formation;
    }

    /**
     * @param id l'identifiant recherché
     * @return la formation à supprimer
     */
    @Override
    public Formation delete(Long id) {
        Formation formation = findById(id);
        if (formation == null) {
            throw new CustomException("Formation", "id", id);
        }
        formationRepository.deleteById(id);
        return formation;
    }
}
