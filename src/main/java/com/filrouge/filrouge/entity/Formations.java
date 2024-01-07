package com.filrouge.filrouge.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "formations")
public class Formations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "idFormations")
    private Long idFormation;

    @Column(name = "nomFormation", nullable = false)
    private String nom;

    @Column(name = "prix", nullable = false)
    private int prix;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "formation")
    private List<SessionFormation> sessionsFormation;

    @ManyToMany
    @JoinTable(
            name = "formations_sous_themes",
            joinColumns = @JoinColumn(name = "formation_id"),
            inverseJoinColumns = @JoinColumn(name = "sousThemesId")
    )
    private List<SousThemes> sousThemes;

    public Formations(String nom, int prix, String description) {
        this.nom = nom;
        this.prix = prix;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Formations{" +
                "idFormation=" + idFormation +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                '}';
    }

}
