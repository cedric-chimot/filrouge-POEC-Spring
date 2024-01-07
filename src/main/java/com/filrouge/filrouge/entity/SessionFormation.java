package com.filrouge.filrouge.entity;
import jakarta.persistence.*;
import lombok.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "session")
public class SessionFormation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSession")
    private Long idSession;

    @Column(name = "date_debut", nullable = false)
    //@Temporal : Pour spécifier si un champ de type "Date" doit être mappé en tant que date
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Column(name = "date_fin", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @Column(name = "statut", nullable = false)
    private String statut;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idFormation", nullable = false)
    private Formations formation;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idCentre", nullable = true)
    private CentreFormation centreFormation;

    @OneToMany(mappedBy = "session")
    private List<Participation> participations;

    public SessionFormation(String dateDebut, String dateFin, String statut, Formations idFormation,
                            CentreFormation idCentre) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            this.dateDebut = dateFormat.parse(dateDebut);
            this.dateFin = dateFormat.parse(dateFin);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.statut = statut;
        this.formation = idFormation;
        this.centreFormation = idCentre;
    }

    @Override
    public String toString() {
        return "SessionFormation{" +
                "idSession=" + idSession +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", statut='" + statut + '\'' +
                ", formation=" + formation +
                ", centreFormation=" + centreFormation +
                '}';
    }
}
