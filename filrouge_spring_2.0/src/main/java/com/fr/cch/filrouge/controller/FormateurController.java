package com.fr.cch.filrouge.controller;

import com.fr.cch.filrouge.entity.Formateur;
import com.fr.cch.filrouge.services.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller pour un formateur
 */
@RestController
@RequestMapping("/formateurs")
public class FormateurController {

    /**
     * Appel le service du formateur
     */
    public final FormateurService formateurService;

    /**
     * Constructeur
     * @param formateurService retourne le service formateur
     */
    @Autowired
    public FormateurController(FormateurService formateurService) {
        this.formateurService = formateurService;
    }

    /**
     * Méthode pour créer un formateur
     * @param formateur, le formateur à créer
     * @return le formateur nouvellement créé
     */
    @PostMapping("/create")
    public Formateur createFormateur(@RequestBody Formateur formateur) {
        return formateurService.createFormateur(formateur);
    }

}
