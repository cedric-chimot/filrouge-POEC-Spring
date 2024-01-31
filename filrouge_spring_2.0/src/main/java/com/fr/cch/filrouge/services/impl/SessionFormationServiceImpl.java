package com.fr.cch.filrouge.services.impl;

import com.fr.cch.filrouge.entity.SessionFormation;
import com.fr.cch.filrouge.exceptions.CustomException;
import com.fr.cch.filrouge.repository.SessionFormationRepository;
import com.fr.cch.filrouge.services.AllServices;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service pour implémenter les méthodes du CRUD pour une session de formation
 */
@Service
@Transactional
public class SessionFormationServiceImpl implements AllServices<SessionFormation, Long> {

    /**
     * Le repository de la session de formation
     */
    private final SessionFormationRepository sessionFormationRepository;

    /**
     * Le constructeur du service
     * @param sessionFormationRepository le repository correspondant
     */
    public SessionFormationServiceImpl(SessionFormationRepository sessionFormationRepository) {
        this.sessionFormationRepository = sessionFormationRepository;
    }

    /**
     * @return la liste des sessions de formation
     */
    @Override
    public List<SessionFormation> findAll() {
        return sessionFormationRepository.findAll();
    }

    /**
     * @param id l'identifiant recherché
     * @return la session de formation correspondante
     */
    @Override
    public SessionFormation findById(Long id) {
        return sessionFormationRepository.findById(id)
                .orElseThrow(() -> new CustomException("SessionFormation", "id", id));
    }

    /**
     * @param newObj le nouvel objet session de formation
     * @return la session de formation nouvellement créée
     */
    @Override
    public SessionFormation create(SessionFormation newObj) {
        return sessionFormationRepository.save(newObj);
    }

    /**
     * Méthode pour mettre à jour une session de formation selon l'id recherché
     * @param sessionFormation l'objet à mettre à jour
     * @return la session mise à jour
     */
    @Override
    public SessionFormation update(SessionFormation sessionFormation) {
        if (!sessionFormationRepository.existsById(sessionFormation.getId())) {
            throw new CustomException("SessionFormation", "id", sessionFormation.getId());
        }
        sessionFormationRepository.save(sessionFormation);
        return sessionFormation;
    }

    /**
     * Méthode pour supprimer une  session de formation selon l'id recherché
     * @param id l'identifiant recherché
     * @return la session de formation à supprimer
     */
    @Override
    public SessionFormation deleteById(Long id) {
        SessionFormation sessionFormation = findById(id);
        sessionFormationRepository.deleteById(id);
        return sessionFormation;
    }

    /**
     * Méthode pour supprimer toutes les sessions de formation
     */
    @Override
    public void deleteAll() {
        sessionFormationRepository.deleteAll();
    }

}
