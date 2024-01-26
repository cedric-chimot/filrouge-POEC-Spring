package com.fr.cch.filrouge.repository;

import com.fr.cch.filrouge.entity.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FormateurRepository extends JpaRepository<Formateur, Long> {}
