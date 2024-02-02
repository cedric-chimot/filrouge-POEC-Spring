package com.fr.cch.filrouge.services;

import com.fr.cch.filrouge.entity.Users;
import com.fr.cch.filrouge.repository.UsersRepository;
import jakarta.transaction.Transactional;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
@Transactional
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    /**
     * Définit le mot de passe haché pour l'utilisateur.
     * Utilise la bibliothèque BCrypt pour générer un sel aléatoire et hacher le mot de passe
     * avant de le stocker dans l'attribut 'mdp'.
     *
     * @param password Le mot de passe en clair à hasher et à définir pour l'utilisateur.
     */
    public String hashMdp(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        System.out.println("Password hashed: " + hashedPassword);
        return hashedPassword;
    }

    /**
     * Méthode pour vérifier si le mail existe
     * @param email l'email à vérifier
     * @return l'utilisateur existant avec un email identique s'il y en a un
     */
    public boolean isEmailExist(String email) {
        Users userExist = usersRepository.findByEmail(email);
        return userExist != null;
    }

}
