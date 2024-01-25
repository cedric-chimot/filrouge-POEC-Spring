package com.fr.cch.filrouge;

import com.fr.cch.filrouge.entity.CentreFormation;
import com.fr.cch.filrouge.entity.Formateur;
import com.fr.cch.filrouge.entity.Formation;
import com.fr.cch.filrouge.entity.Stagiaire;
import com.fr.cch.filrouge.enums.UserRole;
import com.fr.cch.filrouge.services.impl.CentreFormationServiceImpl;
import com.fr.cch.filrouge.services.impl.FormateurServiceImpl;
import com.fr.cch.filrouge.services.impl.FormationServiceImpl;
import com.fr.cch.filrouge.services.UsersService;
import com.fr.cch.filrouge.services.impl.StagiaireServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FilrougeApplication {

	private static FormateurServiceImpl formateurService;
	private static StagiaireServiceImpl stagiaireService;
	private static CentreFormationServiceImpl centreFormationService;
	private static FormationServiceImpl formationService;
	private static UsersService usersService;

	@Autowired
	public FilrougeApplication(
			UsersService usersService,
			FormateurServiceImpl formateurService,
			CentreFormationServiceImpl centreFormationService,
			FormationServiceImpl formationService,
			StagiaireServiceImpl stagiaireService){
		FilrougeApplication.usersService = usersService;
		FilrougeApplication.formateurService = formateurService;
		FilrougeApplication.centreFormationService = centreFormationService;
		FilrougeApplication.formationService = formationService;
		FilrougeApplication.stagiaireService = stagiaireService;
	}

	public static void main(String[] args) {
		SpringApplication.run(FilrougeApplication.class, args);

		Formateur formateur = new Formateur("Chimot", "Cedric", "01/01/01/01/01",  "cedric02@hotmail.fr",
				"ced02830", usersService.hashMdp("ced02830"), UserRole.FORMATEUR, 4.5 );
		formateurService.create(formateur);
		System.out.println(formateur);

		Stagiaire stagiaire = new Stagiaire("Chimot", "Cedric", "01/01/01/01/01",  "cedric02@hotmail.fr",
				"ced02830", "ced02830", UserRole.CANDIDAT);
		stagiaireService.create(stagiaire);
		System.out.println(stagiaire);

		CentreFormation centreFormation = new CentreFormation("IBCegos", "Gare de Lille 59000");
		centreFormationService.create(centreFormation);
		System.out.println(centreFormation);

		Formation formation = new Formation("Java JEE", 3500, "Formation Java et au framework Spring");
		formationService.create(formation);
		System.out.println(formation);

		List<CentreFormation> centre = centreFormationService.findAll();
		System.out.println(centre);

	}
}
