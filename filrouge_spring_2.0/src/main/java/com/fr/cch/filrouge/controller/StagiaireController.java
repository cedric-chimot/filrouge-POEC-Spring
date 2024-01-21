package com.fr.cch.filrouge.controller;

import com.fr.cch.filrouge.entity.Stagiaire;
import com.fr.cch.filrouge.services.StagiaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stagiaires")
public class StagiaireController {

    public final StagiaireService stagiaireService;

    @Autowired
    public StagiaireController(StagiaireService stagiaireService) {
        this.stagiaireService = stagiaireService;
    }

    @PostMapping("/create")
    public Stagiaire createStagiaire(@RequestBody Stagiaire stagiaire) {
        return stagiaireService.createStagiaire(stagiaire);
    }

}
