package com.filrouge.filrouge.service;

import com.filrouge.filrouge.entity.Participation;
import com.filrouge.filrouge.entity.Users;
import com.filrouge.filrouge.enums.UserRole;
import com.filrouge.filrouge.repository.ParticipationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Gestion des participations aux sessions de formation.
 * Sauvegarde des participations à une session de formation
 * et met à jour le rôle de l'utilisateur en tant que stagiaire.
 *
 */
@Service
public class ParticipationService {

    private final ParticipationRepository participationRepository;
    private final UsersService usersService;

    /**
     * Constructeur
     *
     * @param participationRepository Le repository des participations.
     * @param usersService Le service utilisateurs avec les ses différentes méthodes.
     */
    @Autowired
    public ParticipationService(ParticipationRepository participationRepository, UsersService usersService) {
        this.participationRepository = participationRepository;
        this.usersService = usersService;
    }

    /**
     * Sauvegarde une participation et met à jour le rôle de l'utilisateur en tant que stagiaire.
     *
     * @param participation La participation à sauvegarder.
     * @return La participation sauvegardée.
     */
    @Transactional
    public Participation participationSave(Participation participation) {
        Participation newParticipation = participationRepository.save(participation);

        // Mise à jour du rôle de l'utilisateur en tant que stagiaire
        Users users = newParticipation.getUser();
        users.setRole(UserRole.STAGIAIRE);
        usersService.userSave(users);

        return newParticipation;
    }
}
