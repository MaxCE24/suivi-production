package net.atos.suiviproduction.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import net.atos.suiviproduction.model.Equipe;

@Component
public class EquipeValidator implements Validator {

	private final static String EQUIPES_NOM = "nom";

	@Override
	public boolean supports(Class<?> clazz) {
		return Equipe.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, EQUIPES_NOM, "equipe.nom.empty");
	}

}
