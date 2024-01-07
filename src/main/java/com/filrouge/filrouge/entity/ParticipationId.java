package com.filrouge.filrouge.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 * Représente la clé composite pour l'entité Participation.
 * Cette clé est intégrée à l'intérieur de l'entité Participation pour identifier de manière unique une participation.
 * La clé est composée de l'ID de session, de l'ID du formateur et de l'ID de l'utilisateur.
 *
 */
@Embeddable
public class ParticipationId implements Serializable {

    private Long session;
    private Long formateur;
    private Long user;

    public ParticipationId(){}

    public ParticipationId(Long session, Long formateur, Long user) {
        this.session = session;
        this.formateur = formateur;
        this.user = user;
    }

}
