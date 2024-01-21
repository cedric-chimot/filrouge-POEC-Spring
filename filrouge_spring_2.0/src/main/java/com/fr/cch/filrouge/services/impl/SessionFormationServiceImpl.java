package com.fr.cch.filrouge.services.impl;

import com.fr.cch.filrouge.entity.SessionFormation;
import com.fr.cch.filrouge.exceptions.CustomException;
import com.fr.cch.filrouge.repository.SessionFormationRepository;
import com.fr.cch.filrouge.services.AllServices;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SessionFormationServiceImpl implements AllServices<SessionFormation, Long> {

    private final SessionFormationRepository sessionFormationRepository;

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
        SessionFormation sessionFormation = sessionFormationRepository.findById(id).orElse(null);
        if (sessionFormation == null) {
            throw new CustomException("SessionFormation", "id", id);
        }
        return sessionFormation;
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
     * @param id l'identifiant recherché
     * @return la session de formation à supprimer
     */
    @Override
    public SessionFormation delete(Long id) {
        SessionFormation sessionFormation = findById(id);
        if (sessionFormation == null) {
            throw new CustomException("SessionFormation", "id", id);
        }
        sessionFormationRepository.deleteById(id);
        return sessionFormation;
    }
}
