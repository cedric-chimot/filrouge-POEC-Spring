package fr.equipefilrouge.filrougeSpring.controller;

import fr.equipefilrouge.filrougeSpring.entity.Users;
import fr.equipefilrouge.filrougeSpring.enums.UserRole;
import fr.equipefilrouge.filrougeSpring.services.UsersService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
     * Création d'une liste de formations
     * @param users la liste des utilisateurs à créer
     * @return la liste des utilisateurs nouvellement créée
     */
    @PostMapping("/createUsers")
    public List<Users> listUsers(@RequestBody List<Users> users) {
        return usersService.createListe(users);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> identifiants) {
        // Extraire l'e-mail et le mot de passe à partir du corps de la requête
        String email = identifiants.get("email");
        String mdp = identifiants.get("mdp");

        // Vérifier les informations d'identification
        if (usersService.areIdsValid(email, mdp)) {
            System.out.println("connexion réussie !");
            // Si les informations d'identification sont valides, renvoyer une réponse 200 OK avec un message de succès
            return ResponseEntity.ok("Connexion réussie !");
        } else {
            System.out.println("connexion impossible !");
            // Si les informations d'identification ne sont pas valides, renvoyer une réponse 401 Unauthorized avec un message d'erreur
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Identifiants incorrects !");
        }
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
    public Users getUserById(@PathVariable Long id) {
        return usersService.findById(id);
    }

    /**
     * Méthode pour trouver un user selon son rôle
     * @param role le rôle recherché
     * @return l'utilisateur ayant le rôle demandé
     */
    @GetMapping("/role/{role}")
    public Users getUserByRole(@PathVariable UserRole role) {
        return usersService.findByRole(role);
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
