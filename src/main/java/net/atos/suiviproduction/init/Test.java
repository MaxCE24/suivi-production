package net.atos.suiviproduction.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import net.atos.suiviproduction.model.Collaborateur;
import net.atos.suiviproduction.service.CollaborateurService;

@Component
public class Test {

	@Autowired
	private CollaborateurService collaborateurService;

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(WebAppConfig.class);

		Test test = ctx.getBean(Test.class);
		Collaborateur collaborateur = new Collaborateur();
		collaborateur.setNom("LATRACH");
		collaborateur.setPrenom("Omar3");
		collaborateur = test.save(collaborateur);

		System.out.println(collaborateur.getId());

	}

	public Collaborateur save(Collaborateur collaborateur) {

		return collaborateurService.create(collaborateur);
	}

}
