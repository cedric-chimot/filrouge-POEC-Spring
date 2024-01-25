package com.fr.cch.filrouge.repository;

import com.fr.cch.filrouge.entity.Stagiaire;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Le repository du stagiaire
 */
public interface StagiaireRepository  extends JpaRepository<Stagiaire, Long> {
    /**
     * Vérification de l'existence de l'email
     * @param email l'email à vérifier
     * @return si oui ou non l'email existe en BDD
     */
    boolean isEmailExist(String email);
}
