package net.atos.suiviproduction.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import net.atos.suiviproduction.model.CV;

@Component
public class CVValidator implements Validator {

	private final static String CVS_CV = "cV";

	@Override
	public boolean supports(Class<?> clazz) {
		return CV.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, CVS_CV, "cV.cV.empty");
	}

}
