package com.filrouge.filrouge.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "participer")
@IdClass(ParticipationId.class)
public class Participation implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    private SessionFormation session;

    @Id
    @ManyToOne
    @JoinColumn(name = "stagiaire_id", nullable = false)
    private Users user;

    @Id
    @ManyToOne
    @JoinColumn(name = "formateur_id", nullable = false)
    private Formateurs formateur;

    @Column(name = "noteSession", nullable = true)
    private int noteSession;

    @Column(name = "noteFormateur", nullable = true)
    private int noteFormateur;

    @Column(name = "recommandation", nullable = true)
    private Boolean recommandation;

    public Participation(SessionFormation session, Users user, Formateurs formateur, int noteFormateur,
                         int noteSession, Boolean recommandation) {
        this.session = session;
        this.user = user;
        this.formateur = formateur;
        this.noteFormateur = noteFormateur;
        this.noteSession = noteSession;
        this.recommandation = recommandation;
    }

    @Override
    public String toString() {
        return "Participation{" +
                "session=" + session +
                ", user=" + user +
                ", formateur=" + formateur +
                ", noteFormateur=" + noteFormateur +
                ", noteSession=" + noteSession +
                ", recommandation=" + recommandation +
                '}';
    }

}
