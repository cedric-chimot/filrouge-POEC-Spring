package fr.equipefilrouge.filrougeSpring;

import fr.equipefilrouge.filrougeSpring.entity.*;
import fr.equipefilrouge.filrougeSpring.enums.UserRole;
import fr.equipefilrouge.filrougeSpring.services.UsersService;
import fr.equipefilrouge.filrougeSpring.services.impl.CentreFormationServiceImpl;
import fr.equipefilrouge.filrougeSpring.services.impl.FormationServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan
public class FilrougeApplication {

	private static UsersService usersService;
	private static CentreFormationServiceImpl centreFormationService;
	private static FormationServiceImpl formationService;

	public FilrougeApplication(
			UsersService usersService,
			CentreFormationServiceImpl centreFormationService,
			FormationServiceImpl formationService){
		FilrougeApplication.usersService = usersService;
		FilrougeApplication.centreFormationService = centreFormationService;
		FilrougeApplication.formationService = formationService;
	}

	public static void main(String[] args) {
		SpringApplication.run(FilrougeApplication.class, args);

		Users stagiaire = new Users("Chimot", "Cedric", "01/01/01/01/01", "cedric02@hotmail.com",
				"ced02830", "Ced@02830", UserRole.CANDIDAT, null);
		usersService.create(stagiaire);
		System.out.println("Stagiaire: " + stagiaire);

		Users formateur = new Users("Chimot", "Cedric", "01/01/01/01/01", "cedric02@hotmail.fr",
				"ced02830", "Ced@02830", UserRole.FORMATEUR, null);
		usersService.create(formateur);
		System.out.println("Formateur: " + formateur);

		CentreFormation centreFormation = new CentreFormation("IBCegos", "Gare de Lille 59000");
		centreFormationService.create(centreFormation);
		System.out.println("Centre de formation: " + centreFormation);

		Formation formation = new Formation("Java JEE", 3500, "Formation Java et au framework Spring");
		formationService.create(formation);
		System.out.println("Formation: " + formation);

		List<CentreFormation> centres = centreFormationService.findAll();
		System.out.println("Centres de formation: " + centres);
	}
}
