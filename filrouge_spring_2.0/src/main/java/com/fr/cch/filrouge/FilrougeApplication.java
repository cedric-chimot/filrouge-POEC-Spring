package com.fr.cch.filrouge;

import com.fr.cch.filrouge.entity.CentreFormation;
import com.fr.cch.filrouge.entity.Formateur;
import com.fr.cch.filrouge.enums.UserRole;
import com.fr.cch.filrouge.services.CentreFormationService;
import com.fr.cch.filrouge.services.FormateurService;
import com.fr.cch.filrouge.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FilrougeApplication {

	private static FormateurService formateurService;
	private static CentreFormationService centreFormationService;
	private static UsersService usersService;

	@Autowired
	public FilrougeApplication(
			UsersService usersService,
			FormateurService formateurService,
			CentreFormationService centreFormationService){
		FilrougeApplication.usersService = usersService;
		FilrougeApplication.formateurService = formateurService;
		FilrougeApplication.centreFormationService = centreFormationService;
	}

	public static void main(String[] args) {
		SpringApplication.run(FilrougeApplication.class, args);

		Formateur formateur = new Formateur("Chimot", "Cedric", "01/01/01/01/01",  "cedric02@hotmail.fr",
				"ced02830", usersService.hashMdp("ced02830"), UserRole.FORMATEUR, 4.5 );
		formateurService.createFormateur(formateur);
		System.out.println(formateur);

		CentreFormation centreFormation = new CentreFormation("IBCegos", "Gare de Lille 59000");
		centreFormationService.createCentre(centreFormation);
		System.out.println(centreFormation);

	}
}
