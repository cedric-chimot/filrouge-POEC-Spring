package com.fr.cch.filrouge.services.impl;

import com.fr.cch.filrouge.entity.Stagiaire;
import com.fr.cch.filrouge.entity.Users;
import com.fr.cch.filrouge.exceptions.CustomException;
import com.fr.cch.filrouge.exceptions.ExistException;
import com.fr.cch.filrouge.repository.StagiaireRepository;
import com.fr.cch.filrouge.repository.UsersRepository;
import com.fr.cch.filrouge.services.AllServices;
import com.fr.cch.filrouge.services.UsersService;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Email;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Service pour implémenter les méthodes du CRUD pour un stagiaire
 */
@Service
@Transactional
public class StagiaireServiceImpl implements AllServices<Stagiaire, Long> {

    /**
     * Le repository du stagiaire
     */
    private final StagiaireRepository stagiaireRepository;

    private final UsersService usersService;

    /**
     * Le constructeur du service
     * @param stagiaireRepository le repository correspondant
     */
    public StagiaireServiceImpl(StagiaireRepository stagiaireRepository, UsersService usersService) {
        this.stagiaireRepository = stagiaireRepository;
        this.usersService = usersService;
    }

    /**
     * @return tous les stagiaires
     */
    @Override
    public List<Stagiaire> findAll() {
        return stagiaireRepository.findAll();
    }

    /**
     * @param id l'identifiant recherché
     * @return le stagiaire correspondant
     */
    @Override
    public Stagiaire findById(Long id) {
        return stagiaireRepository.findById(id).orElse(null);
    }

    /**
     * Méthode de création d'un nouveau stagiaire
     * @param newObj le nouvel objet stagiaire
     * @return le stagiaire nouvellement créé
     */
    @Override
    public Stagiaire create(Stagiaire newObj) {
        String email = newObj.getEmail();
        Stagiaire newStagiaire;
        if (usersService.isEmailExist(email) && email != null) {
            throw new ExistException("User", "email", email);
        } else {
            newStagiaire = new Stagiaire(newObj.getNom(), newObj.getPrenom(), newObj.getTelephone(),
                    email, newObj.getPseudo(), usersService.hashMdp(newObj.getMdp()), newObj.getRole());
        }
        return stagiaireRepository.save(newStagiaire);
    }

    /**
     * @param stagiaire l'objet stagiaire à mettre à jour
     */
    @Override
    public Stagiaire update(Stagiaire stagiaire) {
        if (!stagiaireRepository.existsById(stagiaire.getId())) {
            throw new CustomException("Stagiaire", "id", stagiaire.getId());
        }
        stagiaireRepository.save(stagiaire);
        return stagiaire;
    }

    /**
     * @param id l'identifiant recherché
     * @return le stagiaire à supprimer
     */
    @Override
    public Stagiaire delete(Long id) {
        Stagiaire stagiaire = findById(id);
        if (stagiaire == null) {
            throw new CustomException("Stagiaire", "id", id);
        }
        stagiaireRepository.deleteById(id);
        return stagiaire;
    }

}
