package com.fr.cch.filrouge.controller;

import com.fr.cch.filrouge.entity.Stagiaire;
import com.fr.cch.filrouge.services.impl.StagiaireServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller pour un stagiaire
 */
@RestController
@RequestMapping("/stagiaires")
public class StagiaireController {

    /**
     * Appelle le service du stagiaire
     */
    public final StagiaireServiceImpl stagiaireServiceImpl;

    /**
     * Constructeur
     * @param stagiaireServiceImpl le service Stagiaire
     */
    public StagiaireController(StagiaireServiceImpl stagiaireServiceImpl) {
        this.stagiaireServiceImpl = stagiaireServiceImpl;
    }

    /**
     * Méthode pour créer un stagiaire
     * @param stagiaire le stagiaire à créer
     * @return le stagiaire nouvellement créé
     */
    @PostMapping("/create")
    public Stagiaire createStagiaire(@RequestBody Stagiaire stagiaire) {
        return stagiaireServiceImpl.create(stagiaire);
    }

}
