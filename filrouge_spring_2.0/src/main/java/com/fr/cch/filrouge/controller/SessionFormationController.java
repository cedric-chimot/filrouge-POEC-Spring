package com.fr.cch.filrouge.controller;

import com.fr.cch.filrouge.entity.SessionFormation;
import com.fr.cch.filrouge.services.impl.SessionFormationServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller pour une session de formation
 */
@RestController
@RequestMapping("/sessionFormations")
public class SessionFormationController {

    /**
     * Appel du service session de formation
     */
    private final SessionFormationServiceImpl sessionFormationService;

    /**
     * Constructeur du controller
     * @param sessionFormationService le service de la session de formation
     */
    public SessionFormationController(SessionFormationServiceImpl sessionFormationService) {
        this.sessionFormationService = sessionFormationService;
    }

    /**
     * Méthode pour créer une session de formation
     * @param sessionFormation la session de formation à créer
     * @return la session de formation nouvellement créée
     */
    @PostMapping("/create")
    public SessionFormation createSession(@RequestBody SessionFormation sessionFormation) {
        return sessionFormationService.create(sessionFormation);
    }

}
