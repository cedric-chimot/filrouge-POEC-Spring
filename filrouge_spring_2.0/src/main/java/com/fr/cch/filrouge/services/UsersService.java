package com.fr.cch.filrouge.services;

import jakarta.transaction.Transactional;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsersService {

    /**
     * Définit le mot de passe haché pour l'utilisateur.
     * Utilise la bibliothèque BCrypt pour générer un sel aléatoire et hacher le mot de passe
     * avant de le stocker dans l'attribut 'mdp'.
     *
     * @param plainPassword Le mot de passe en clair à hasher et à définir pour l'utilisateur.
     */
    public String hashMdp(String plainPassword) {
        String hashedPassword = BCrypt.hashpw(plainPassword, BCrypt.gensalt());
        System.out.println("Password hashed: " + hashedPassword);
        return hashedPassword;
    }

}
