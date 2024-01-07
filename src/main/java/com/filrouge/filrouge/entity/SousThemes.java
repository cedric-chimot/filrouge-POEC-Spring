package com.filrouge.filrouge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sous_themes")
public class SousThemes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSousTheme")
    private Long id;

    @Column(name = "nomSousTheme")
    private String sousTheme;

    /*@OneToMany(mappedBy = "sousTheme")
    private List<Themes> themes;*/

    @ManyToMany(mappedBy = "sousThemes")
    private List<Formations> formations;

    public SousThemes(String sousTheme) {
        this.sousTheme = sousTheme;
    }

    @Override
    public String toString() {
        return "SousThemes{" +
                "id=" + id +
                ", sousTheme='" + sousTheme + '\'' +
                '}';
    }
}
