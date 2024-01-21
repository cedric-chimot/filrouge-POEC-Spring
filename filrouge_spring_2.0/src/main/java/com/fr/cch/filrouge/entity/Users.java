package com.fr.cch.filrouge.entity;

import com.fr.cch.filrouge.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.StringJoiner;

/**
 * Classe abstraite Users regroupant les données communes aux formateurs et aux stagiaires
 * qui vont en hériter
 */
@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private Long id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "telephone", nullable = false)
    private String telephone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "pseudo", nullable = false)
    private String pseudo;

    @Column(name = "mdp", nullable = false)
    private String mdp;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    /**
     * Constructeur d'un utilisateur
     * @param nom, som nom
     * @param prenom, son prénom
     * @param telephone, sont téléphone
     * @param email, son email,
     * @param pseudo, son pseudo
     * @param mdp, son mot de passe
     * @param role, son rôle
     */
    public Users(String nom, String prenom, String telephone, String email, String pseudo, String mdp, UserRole role) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.role = role;
    }

    /**
     * Méthode pour afficher un utilisateur
     * @return l'utilisateur
     */
    @Override
    public String toString() {
        return new StringJoiner(", ", Users.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nom='" + nom + "'")
                .add("prenom='" + prenom + "'")
                .add("telephone='" + telephone + "'")
                .add("email='" + email + "'")
                .add("pseudo='" + pseudo + "'")
                .add("mdp='" + mdp + "'")
                .add("role=" + role)
                .toString();
    }
}