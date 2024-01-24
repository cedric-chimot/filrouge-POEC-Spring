package com.fr.cch.filrouge.repository;

import com.fr.cch.filrouge.entity.Domaine;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Le repository qui répertorie toutes les méthodes du CRUD pour un domaine
 */
public interface DomaineRepository extends JpaRepository<Domaine, Long> {
}
