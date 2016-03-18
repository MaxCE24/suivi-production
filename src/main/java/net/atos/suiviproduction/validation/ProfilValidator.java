package net.atos.suiviproduction.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import net.atos.suiviproduction.model.Profil;

@Component
public class ProfilValidator implements Validator {

	private final static String PROFILS_LIBELLE = "libelle";

	@Override
	public boolean supports(Class<?> clazz) {
		return Profil.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, PROFILS_LIBELLE, "profil.libelle.empty");
	}

}
