package com.fr.cch.filrouge.services;

import com.fr.cch.filrouge.entity.Stagiaire;
import com.fr.cch.filrouge.repository.StagiaireRepository;
import jakarta.transaction.Transactional;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StagiaireService {

    private final StagiaireRepository stagiaireRepository;

    public StagiaireService(StagiaireRepository stagiaireRepository) {
        this.stagiaireRepository = stagiaireRepository;
    }

    public Stagiaire createStagiaire(Stagiaire stagiaire) {
        stagiaireRepository.save(stagiaire);
        return stagiaire;
    }

    /**
     * Définit le mot de passe haché pour l'utilisateur.
     * Utilise la bibliothèque BCrypt pour générer un sel aléatoire et hacher le mot de passe
     * avant de le stocker dans l'attribut 'mdp'.
     *
     * @param plainPassword Le mot de passe en clair à hasher et à définir pour l'utilisateur.
     */
    public static String hashMdp(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

}
