package net.atos.suiviproduction.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import net.atos.suiviproduction.model.Astreinte;

@Component
public class AstreinteValidator implements Validator {

	private final static String ASTREINTES_REFERENCE = "reference";
	private final static String ASTREINTES_DATE = "date";
	private final static String ASTREINTES_NOMBRE_HEURES = "nombreHeures";
	private final static String ASTREINTES_TYPE = "type";

	@Override
	public boolean supports(Class<?> clazz) {
		return Astreinte.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Astreinte astreinte = (Astreinte) target;

		Double nombreHeures = astreinte.getNombreHeures();

		ValidationUtils.rejectIfEmpty(errors, ASTREINTES_REFERENCE, "astreinte.reference.empty");
		ValidationUtils.rejectIfEmpty(errors, ASTREINTES_DATE, "astreinte.date.empty");
		ValidationUtils.rejectIfEmpty(errors, ASTREINTES_NOMBRE_HEURES, "astreinte.nombreHeures.empty");
		ValidationUtils.rejectIfEmpty(errors, ASTREINTES_TYPE, "astreinte.type.empty");

		if (nombreHeures != null && nombreHeures < 0.5)
			errors.rejectValue(ASTREINTES_NOMBRE_HEURES, "astreinte.nombreHeures.lessThanHalf");

	}

}
