package fr.equipefilrouge.filrougeSpring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.StringJoiner;

/**
 * Classe Participation pour gérer les participations aux sessions de formation
 */
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "participationFormation")
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    private SessionFormation session;

    @ManyToOne
    @JoinColumn(name = "stagiaire_id", nullable = false)
    private Users stagiaire;

    @ManyToOne
    @JoinColumn(name = "formateur_id", nullable = false)
    private Users animateur;

    @Column(name = "noteFormateur")
    private int noteFormateur;

    @Column(name = "noteSession")
    private int noteSession;

    @Column(name = "recommandation")
    private Boolean recommandation;

    /**
     * Constructeur d'une participation à une formation
     * @param session, la session de formation
     * @param stagiaire, le stagiaire inscrit à la session
     * @param animateur, le formateur qui va animer la formation
     * @param noteFormateur, la note du formateur par les stagiaires
     * @param noteSession, la note de la session de formation par les stagiaires
     * @param recommandation, renseigne si le stagiaire recommande la formation
     */
    public Participation(SessionFormation session, Users stagiaire, Users animateur, int noteFormateur,
                         int noteSession, Boolean recommandation) {
        this.session = session;
        this.stagiaire = stagiaire;
        this.animateur = animateur;
        this.noteFormateur = noteFormateur;
        this.noteSession = noteSession;
        this.recommandation = recommandation;
    }

    /**
     * Méthode pour afficher une participation à une formation ainsi que le stagiaire
     * le formateur et la formation concernée
     * @return une participation à une formation
     */
    @Override
    public String toString() {
        return new StringJoiner(", ", Participation.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("session=" + session)
                .add("user=" + stagiaire)
                .add("animateur=" + animateur)
                .add("noteFormateur=" + noteFormateur)
                .add("noteSession=" + noteSession)
                .add("recommandation=" + recommandation)
                .toString();
    }
}
