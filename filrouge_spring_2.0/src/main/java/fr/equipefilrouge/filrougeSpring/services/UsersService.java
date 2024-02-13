package fr.equipefilrouge.filrougeSpring.services;

import fr.equipefilrouge.filrougeSpring.entity.Users;
import fr.equipefilrouge.filrougeSpring.enums.UserRole;
import fr.equipefilrouge.filrougeSpring.exceptions.CustomException;
import fr.equipefilrouge.filrougeSpring.exceptions.ExistException;
import fr.equipefilrouge.filrougeSpring.repository.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UsersService implements AllServices<Users, Long> {

    private final UsersRepository usersRepository;

    private final JdbcTemplate jdbcTemplate;

    public UsersService(UsersRepository usersRepository, JdbcTemplate jdbcTemplate) {
        this.usersRepository = usersRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * @return tous les utilisateurs
     */
    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    /**
     * @param id l'identifiant recherché
     * @return l'utilisateur correspondant
     */
    @Override
    public Users findById(Long id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new CustomException("Users", "id", id));
    }

    /**
     * Méthode de création d'un nouvel utilisateur
     * @param newObj le nouvel objet utilisateur
     * @return l'utilisateur nouvellement créé
     */
    @Override
    public Users create(Users newObj) {
        String email = newObj.getEmail();
        if (isEmailExist(email) && email != null) {
            System.out.println("Email existant");
            throw new ExistException("User", "email", email);
        }
        UserRole role;
        if(newObj.getRole() != null) {
            role = newObj.getRole();
        } else {
            role = UserRole.CANDIDAT;
        }
        Users newUser = new Users(newObj.getNom(), newObj.getPrenom(), newObj.getTelephone(), email,
                newObj.getPseudo(), hashMdp(newObj.getMdp()), role, newObj.getNoteMoyenne());
        return usersRepository.save(newUser);
    }

    /**
     * Méthode pour ajouter une liste d'utilisateurs
     * @param users la liste des utilisateurs à ajouter
     * @return la liste des utilisateurs
     */
    public List<Users> createListe(List<Users> users) {
        List<Users> saveUsers = new ArrayList<>();
        for (Users user : users) {
            String email = user.getEmail();
            if (isEmailExist(email) && email != null) {
                System.out.println("Email existant");
                throw new ExistException("User", "email", email);
            }
            UserRole role;
            if(user.getRole() != null) {
                role = user.getRole();
            } else {
                role = UserRole.CANDIDAT;
            }
            saveUsers.add(new Users(user.getNom(), user.getPrenom(), user.getTelephone(), email, user.getPseudo(),
                    hashMdp(user.getMdp()), role, user.getNoteMoyenne()));
        }
        return usersRepository.saveAll(saveUsers);
    }

    /**
     * @param user l'objet utilisateur à mettre à jour
     */
    @Override
    public Users update(Users user) {
        if (user.getId() != null) {
            jdbcTemplate.update("UPDATE users SET role = ? WHERE id_user = ?",
                    user.getRole(), user.getId());
            usersRepository.save(user);
        } else {
            throw new CustomException("Candidat", "id", "Identifiant inconnu !");
        }
        return user;
    }

    /**
     * @param id l'identifiant recherché
     * @return le stagiaire à supprimer
     */
    @Override
    public Users deleteById(Long id) {
        Users user = findById(id);
        usersRepository.deleteById(id);
        return user;
    }

    /**
     * Méthode pour supprimer tous les stagiaires
     */
    @Override
    public void deleteAll() {
        usersRepository.deleteAll();
    }

    /**
     * Définit le mot de passe haché pour l'utilisateur.
     * Utilise la bibliothèque BCrypt pour générer un sel aléatoire et hacher le mot de passe
     * avant de le stocker dans l'attribut 'mdp'.
     *
     * @param password Le mot de passe en clair à hasher et à définir pour l'utilisateur.
     */
    public String hashMdp(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        System.out.println("Password hashed: " + hashedPassword);
        return hashedPassword;
    }

    /**
     * Méthode pour vérifier si le mail existe
     * @param email l'email à vérifier
     * @return l'utilisateur existant avec un email identique s'il y en a un
     */
    public boolean isEmailExist(String email) {
        Users userExist = usersRepository.findByEmail(email);
        return userExist != null;
    }

    public boolean areIdsValid(String email, String password) {
        // Récupération de l'utilisateur à partir d l'email fourni
        Users user = usersRepository.findByEmail(email);
        // Vérification de l'existence de l'utilisateur
        if (user != null) {
            // Utilisation de "BCryptPasswordEncoder" pour vérifier si le mdp fourni est identique à celui stocké en BDD
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            // Renvoie "true" si c'est le cas
            return passwordEncoder.matches(password, user.getMdp());
        }
        return false;
    }

    /**
     * Méthode pour trouver des utilisateurs par leur rôle
     * @param role le rôles recherché
     * @return le nombre d'utilisateurs avec le rôle correspondant
     */
    public Long countUsersByRole(UserRole role) {
        return usersRepository.countByRole(role);
    }

    public Users findByRole(UserRole role) {
        return usersRepository.findByRole(role);
    }

}
