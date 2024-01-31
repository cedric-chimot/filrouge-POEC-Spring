package com.fr.cch.filrouge.services.impl;

import com.fr.cch.filrouge.entity.Formation;
import com.fr.cch.filrouge.exceptions.CustomException;
import com.fr.cch.filrouge.repository.FormationRepository;
import com.fr.cch.filrouge.services.AllServices;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service pour implémenter les méthodes du CRUD pour une session de formation
 */
@Service
@Transactional
public class FormationServiceImpl implements AllServices<Formation, Long> {

    /**
     * Le repository Formation
     */
    private final FormationRepository formationRepository;

    /**
     * API pour gérer les opérations sur la BDD
     */
    private final JdbcTemplate jdbcTemplate;

    /**
     * Le constructeur du service
     * @param formationRepository le repository correspondant
     */
    public FormationServiceImpl(FormationRepository formationRepository, JdbcTemplate jdbcTemplate) {
        this.formationRepository = formationRepository;
        this.jdbcTemplate = jdbcTemplate;
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
        return formationRepository.findById(id)
                .orElseThrow(() -> new CustomException("Formation", "id", id));
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
        if (formation.getId() != null) {
            jdbcTemplate.update("UPDATE formation SET nom_formation = ?, prix = ?, description = ? WHERE id = ?",
                    formation.getNom(), formation.getPrix(), formation.getDescription(), formation.getId());
            formationRepository.save(formation);
        } else {
            throw new CustomException("Formation", "id", "Identifiant inconnu !");
        }
        return formation;
    }

    /**
     * @param id l'identifiant recherché
     * @return la formation à supprimer
     */
    @Override
    public Formation deleteById(Long id) {
        Formation formation = findById(id);
        formationRepository.deleteById(id);
        return formation;
    }

    /**
     * Méthode pour supprimer toutes les formations
     */
    @Override
    public void deleteAll() {
        formationRepository.deleteAll();
    }
}
