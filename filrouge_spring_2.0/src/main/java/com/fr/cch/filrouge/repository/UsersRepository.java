package com.fr.cch.filrouge.repository;

import com.fr.cch.filrouge.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends JpaRepository<Users, Long> {
    /**
     * Requête pour vérifier l'existence de l'email en BDD
     * @param email l'email à vérifier
     * @return la vérification de l'email
     */
    @Query("SELECT u FROM Users u WHERE u.email = :email")
    Users findByEmail(@Param("email") String email);
}