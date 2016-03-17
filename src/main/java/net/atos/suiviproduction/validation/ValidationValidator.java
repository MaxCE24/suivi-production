package net.atos.suiviproduction.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import net.atos.suiviproduction.model.Validation;

@Component
public class ValidationValidator implements Validator {

	private final static String VALIDATIONS_DATE = "date";

	@Override
	public boolean supports(Class<?> clazz) {
		return Validation.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, VALIDATIONS_DATE, "validation.date.empty");

	}

}
