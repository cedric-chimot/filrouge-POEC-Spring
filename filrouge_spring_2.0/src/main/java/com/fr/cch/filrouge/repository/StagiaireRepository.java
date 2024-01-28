package com.fr.cch.filrouge.repository;

import com.fr.cch.filrouge.entity.Stagiaire;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Le repository du stagiaire
 */
public interface StagiaireRepository extends JpaRepository<Stagiaire, Long> {}
