package com.fr.cch.filrouge.controller;

import com.fr.cch.filrouge.dto.StagiaireCompletDTO;
import com.fr.cch.filrouge.dto.StagiaireReduitDTO;
import com.fr.cch.filrouge.entity.Stagiaire;
import com.fr.cch.filrouge.services.impl.StagiaireServiceImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller pour un stagiaire
 */
@RestController
@RequestMapping("/stagiaires")
@CrossOrigin
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
     * Créer un stagiaire
     * @param stagiaire le stagiaire à créer
     * @return le stagiaire nouvellement créé
     */
    @PostMapping("/create")
    public Stagiaire createStagiaire(@Valid @RequestBody Stagiaire stagiaire) {
        return stagiaireServiceImpl.create(stagiaire);
    }

    /**
     * Mettre à jour un stagiaire
     * @param stagiaire le stagiaire à mettre à jour
     * @return le stagiaire mis à jour
     */
    @PatchMapping("/update")
    public Stagiaire updateStagiaire(@RequestBody Stagiaire stagiaire) {
        return stagiaireServiceImpl.update(stagiaire);
    }

    /**
     * Afficher tous les stagiaires
     * @return la liste de tous les stagiaires
     */
    @GetMapping("/all")
    public List<StagiaireReduitDTO> getAllStagiaires() {
        return stagiaireServiceImpl.findAllStagiairesReduit();
    }

    /**
     * Afficher un stagiaire selon son id
     * @param id l'identifiant du stagiaire
     * @return le stagiaire recherché
     */
    @GetMapping("/{id}")
    public StagiaireCompletDTO getStagiaireById(@PathVariable Long id) {
        return stagiaireServiceImpl.stagiaireById(id);
    }

    /**
     * Supprimer un stagiaire selon son id
     * @param id l'identifiant du stagiaire
     * @return le stagiaire supprimé
     */
    @DeleteMapping("/delete/{id}")
    public Stagiaire deleteStagiaireById(@PathVariable Long id) {
        return stagiaireServiceImpl.deleteById(id);
    }

    /**
     * Supprimer tous les stagiaires
     */
    @DeleteMapping("/delete/all")
    public void deleteAllStagiaire() {
        stagiaireServiceImpl.deleteAll();
    }

}
