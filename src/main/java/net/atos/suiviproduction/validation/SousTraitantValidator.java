package net.atos.suiviproduction.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import net.atos.suiviproduction.model.SousTraitant;

@Component
public class SousTraitantValidator implements Validator {

	private final static String SOUS_TRAITANTS_NOM = "nom";
	private final static String SOUS_TRAITANTS_PRENOM = "prenom";
	private final static String SOUS_TRAITANTS_NUMERO_DE_TELEPHONE = "numeroDeTelephone";
	private final static String SOUS_TRAITANTS_DATE_RECRUTEMENT = "dateRecrutement";

	@Override
	public boolean supports(Class<?> clazz) {
		return SousTraitant.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, SOUS_TRAITANTS_NOM, "sousTraitant.nom.empty");
		ValidationUtils.rejectIfEmpty(errors, SOUS_TRAITANTS_PRENOM, "sousTraitant.prenom.empty");
		ValidationUtils.rejectIfEmpty(errors, SOUS_TRAITANTS_NUMERO_DE_TELEPHONE,
				"sousTraitant.numeroDeTelephone.empty");
		ValidationUtils.rejectIfEmpty(errors, SOUS_TRAITANTS_DATE_RECRUTEMENT, "sousTraitant.dateRecrutement.empty");

	}

}
