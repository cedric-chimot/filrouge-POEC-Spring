package fr.equipefilrouge.filrougeSpring.controller;

import fr.equipefilrouge.filrougeSpring.entity.Users;
import fr.equipefilrouge.filrougeSpring.enums.UserRole;
import fr.equipefilrouge.filrougeSpring.services.UsersService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    /**
     * Appelle le service users
     */
    public final UsersService usersService;
    /**
     * Constructeur
     * @param usersService le service users
     */
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    /**
     * Créer un stagiaire
     * @param user l'utilisateur à créer
     * @return l'utilisateur nouvellement créé
     */
    @PostMapping("/create")
    public Users createUser(@Valid @RequestBody Users user) {
        return usersService.create(user);
    }

    /**
     * Mettre à jour un stagiaire
     * @param stagiaire le stagiaire à mettre à jour
     * @return le stagiaire mis à jour
     */
    @PatchMapping("/update")
    public Users updateUser(@RequestBody Users stagiaire) {
        return usersService.update(stagiaire);
    }

    /**
     * Afficher tous les stagiaires
     * @return la liste de tous les stagiaires
     */
    @GetMapping("/all")
    public List<Users> getAllUsers() {
        return usersService.findAll();
    }

    /**
     * Afficher un stagiaire selon son id
     * @param id l'identifiant du stagiaire
     * @return le stagiaire recherché
     */
    @GetMapping("/{id}")
    public Users getStagiaireById(@PathVariable Long id) {
        return usersService.findById(id);
    }

    /**
     * Renvoyer le nombre de stagiaires en BDD
     * @return le nombre de stagiaire
     */
    @GetMapping("/nbStagiaires")
    public Long nbStagiaires() {
        return usersService.countUsersByRole(UserRole.STAGIAIRE);
    }

    /**
     * Renvoyer le nombre de candidats en BDD
     * @return le nombre de candidats
     */
    @GetMapping("/nbCandidats")
    public Long nbCandidats() {
        return usersService.countUsersByRole(UserRole.CANDIDAT);
    }

    /**
     * Supprimer un stagiaire selon son id
     * @param id l'identifiant du stagiaire
     * @return le stagiaire supprimé
     */
    @DeleteMapping("/delete/{id}")
    public Users deleteUserById(@PathVariable Long id) {
        return usersService.deleteById(id);
    }

    /**
     * Supprimer tous les stagiaires
     */
    @DeleteMapping("/delete/all")
    public void deleteAllUsers() {
        usersService.deleteAll();
    }
}
