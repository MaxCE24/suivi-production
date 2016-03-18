package net.atos.suiviproduction.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import net.atos.suiviproduction.model.Societe;

@Component
public class SocieteValidator implements Validator {

	private final static String SOCIETES_RAISON_SOCIALE = "raisonSociale";

	@Override
	public boolean supports(Class<?> clazz) {
		return Societe.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, SOCIETES_RAISON_SOCIALE, "societe.raisonSociale.empty");
	}

}
