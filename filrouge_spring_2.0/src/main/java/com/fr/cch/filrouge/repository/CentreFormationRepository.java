package com.fr.cch.filrouge.repository;

import com.fr.cch.filrouge.entity.CentreFormation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Le repository qui répertorie toutes les méthodes du CRUD pour un centre de formation
 */
public interface CentreFormationRepository extends JpaRepository<CentreFormation, Long> {
}
