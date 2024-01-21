package com.fr.cch.filrouge.controller;

import com.fr.cch.filrouge.entity.Formation;
import com.fr.cch.filrouge.services.impl.FormationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller pour une formation
 */
@RestController
@RequestMapping("/formations")
public class FormationController {

    /**
     * Déclaration du service Formation
     */
    private final FormationServiceImpl formationServiceImpl;

    /**
     * Constructeur du controller Formation
     * @param formationServiceImpl le service de la formation
     */
    @Autowired
    public FormationController(FormationServiceImpl formationServiceImpl) {
        this.formationServiceImpl = formationServiceImpl;
    }

    /**
     * Méthode pour créer une nouvelle formation
     * @param formation La formation à créer
     * @return l formation nouvellement créée
     */
    @PostMapping("/create")
    public Formation createFormation(@RequestBody Formation formation) {
        return formationServiceImpl.create(formation);
    }

}
