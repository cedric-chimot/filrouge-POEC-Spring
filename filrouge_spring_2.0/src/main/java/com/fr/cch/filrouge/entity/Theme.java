package com.fr.cch.filrouge.entity;

import com.fr.cch.filrouge.enums.ThemesEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Classe Themes pour gérer les thèmes, les domaines et les sous-thèmes associés
 */
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "themes")
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "idTheme")
    private Long id;

    @Column(name = "nomTheme", nullable = false)
    @Enumerated(EnumType.STRING)
    private ThemesEnum theme;

    @ManyToOne
    @JoinColumn(name = "idSousTheme")
    private SousTheme sousTheme;

    @OneToMany(mappedBy = "theme")
    private List<DomaineTheme> domaineThemes;

    /**
     * Constructeur du thème
     * @param theme, le thème
     * @param sousTheme, le sous-thème associé
     */
    public Theme(ThemesEnum theme, SousTheme sousTheme) {
        this.theme = theme;
        this.sousTheme = sousTheme;
    }

    /**
     * Méthode pour afficher le thème
     * @return le thème
     */
    @Override
    public String toString() {
        return "Themes{" +
                "idTheme=" + id +
                ", nom='" + theme + '\'' +
                ", sousTheme=" + sousTheme +
                '}';
    }
}

