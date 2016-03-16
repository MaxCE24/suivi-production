package net.atos.suiviproduction.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import net.atos.suiviproduction.model.DemandeDAchat;

public class DemandeDAchatValidator implements Validator {

	private final static String DEMANDES_D_ACHAT_NUMERO = "numero";
	private final static String DEMANDES_D_ACHAT_DATE = "date";
	private final static String DEMANDES_D_ACHAT_STATUT = "statut";
	private final static String DEMANDES_D_ACHAT_NUMERO_DE_BON_DE_COMMANDE = "numeroDeBonDeCommande";

	@Override
	public boolean supports(Class<?> clazz) {
		return DemandeDAchat.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		DemandeDAchat demandeDAchat = (DemandeDAchat) target;

		Integer numero = demandeDAchat.getNumero();
		Integer numeroDeBonDeCommande = demandeDAchat.getNumeroDeBonDeCommande();

		if (numero != null && numero < 1)
			errors.rejectValue(DEMANDES_D_ACHAT_NUMERO, "demandeDAchat.numero.lessThanOne");
		if (numeroDeBonDeCommande != null && numeroDeBonDeCommande < 1)
			errors.rejectValue(DEMANDES_D_ACHAT_NUMERO_DE_BON_DE_COMMANDE,
					"demandeDAchat.numeroDeBonDeCommande.lessThanOne");

		ValidationUtils.rejectIfEmpty(errors, DEMANDES_D_ACHAT_DATE, "demandeDAchat.date.empty");
		ValidationUtils.rejectIfEmpty(errors, DEMANDES_D_ACHAT_STATUT, "demandeDAchat.statut.empty");

	}

}
