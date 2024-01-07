package com.filrouge.filrouge.data;

import com.filrouge.filrouge.entity.*;
import com.filrouge.filrouge.enums.UserRole;
import com.filrouge.filrouge.service.*;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class DataCreate {
    private final UsersService usersService;
    private final FormationsService formationsService;
    private final CentreFormationService centreFormationService;
    private final SessionFormationService sessionFormationService;
    private final ParticipationService participationService;
    private final FormateurService formateurService;
    private final SousThemesService sousThemesService;

    @Autowired
    public DataCreate(
            UsersService usersService,
            FormationsService formationsService,
            CentreFormationService centreFormationService,
            SessionFormationService sessionFormationService,
            ParticipationService participationService,
            FormateurService formateurService,
            SousThemesService sousThemesService) {
        this.usersService = usersService;
        this.formationsService = formationsService;
        this.centreFormationService = centreFormationService;
        this.sessionFormationService = sessionFormationService;
        this.participationService = participationService;
        this.formateurService = formateurService;
        this.sousThemesService = sousThemesService;;
    }

    @Transactional
    public void newData() {

        Users users = new Users("Chimot", "Cedric", "01/01/01/01/01", "cedric02@hotmail.fr",
                "ced02830", "ced02830", UserRole.CANDIDAT);
        usersService.userSave(users);
        System.out.println(users);

        Formations formations = new Formations("Java JEE", 3500,
                "Formation au langage Java et au framework Spring");
        formationsService.formationsSave(formations);
        System.out.println(formations);

        CentreFormation centreFormation = new CentreFormation("IbCegos",
                "Gare Lille Flandres 59000 Lille");
        centreFormationService.centreSave(centreFormation);
        System.out.println(centreFormation);

        Optional<Formations> formationsPersist = formationsService.findById(1L);
        Optional<CentreFormation> centrePersist = centreFormationService.findById(1L);
        if (formationsPersist.isPresent() && centrePersist.isPresent()) {
            SessionFormation sessionFormation = new SessionFormation("03-01-2024", "02-02-2024",
                    "en_attente", formationsPersist.get(), centrePersist.get());
            sessionFormationService.sessionSave(sessionFormation);
            System.out.println(sessionFormation);
        }

        Formateurs formateurs = new Formateurs("Toto", "2 ans d'expérience en JAVA JEE",
                4.5);
        formateurService.formateurSave(formateurs);
        System.out.println(formateurs);

        Optional<SessionFormation> sessionPersist = sessionFormationService.findById(1L);
        Optional<Formateurs> formateursPersist = formateurService.findById(1L);
        Optional<Users> usersPersist = usersService.findById(1L);
        if (sessionPersist.isPresent() && formateursPersist.isPresent() && usersPersist.isPresent()) {
            Participation participation = new Participation(sessionPersist.get(), usersPersist.get(),
                    formateursPersist.get(), 4, 4, true);
            participationService.participationSave(participation);
            System.out.println(participation);
        }

        SousThemes sousThemes = new SousThemes("Java JEE");
        SousThemes sousThemes1 = new SousThemes("C#");
        sousThemesService.sousThemesSave(sousThemes);
        sousThemesService.sousThemesSave(sousThemes1);
        System.out.println(sousThemes);
        System.out.println(sousThemes1);

        Optional<Formations> formationPersist = formationsService.findById(1L);
        Optional<SousThemes> sousThemesPersist = sousThemesService.findById(1L);
        if (formationsPersist.isPresent() && sousThemesPersist.isPresent()) {
            Formations formation = formationPersist.get();
            SousThemes sousTheme = sousThemesPersist.get();

            // Charger explicitement la collection de sousThemes à l'intérieur de la transaction
            Hibernate.initialize(formation.getSousThemes());

            if (formation.getSousThemes() == null) {
                formation.setSousThemes(new ArrayList<>());
            }

            // Ajouter le sous-thème à la liste de sous-thèmes de la formation
            formation.getSousThemes().add(sousTheme);
            formationsService.formationsSave(formation);

            // Charger explicitement la collection formations à l'intérieur de la transaction
            Hibernate.initialize(sousTheme.getFormations());

            if (sousTheme.getFormations() == null) {
                sousTheme.setFormations(new ArrayList<>());
            }

            // Ajouter la formation à la liste de formation du sous-thème
            sousTheme.getFormations().add(formation);
            sousThemesService.sousThemesSave(sousTheme);
        }

    }

}
