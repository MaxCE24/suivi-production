package net.atos.suiviproduction.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import net.atos.suiviproduction.model.Collaborateur;

@Component
public class CollaborateurValidator implements Validator {

	private final static String COLLABORATEURS_NOM = "nom";
	private final static String COLLABORATEURS_PRENOM = "prenom";

	@Override
	public boolean supports(Class<?> clazz) {
		return Collaborateur.class.isAssignableFrom(clazz);
	}

	@SuppressWarnings("unused")
	@Override
	public void validate(Object target, Errors errors) {
		Collaborateur collaborateur = (Collaborateur) target;

		ValidationUtils.rejectIfEmpty(errors, COLLABORATEURS_NOM, "collaborateur.nom.empty");
		ValidationUtils.rejectIfEmpty(errors, COLLABORATEURS_PRENOM, "collaborateur.prenom.empty");

	}

}
