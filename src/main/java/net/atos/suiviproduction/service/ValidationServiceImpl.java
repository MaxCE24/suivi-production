package net.atos.suiviproduction.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.atos.suiviproduction.exception.ValidationNotFound;
import net.atos.suiviproduction.model.Validation;
import net.atos.suiviproduction.repository.ValidationRepository;

@Service
public class ValidationServiceImpl implements ValidationService {

	@Resource
	private ValidationRepository validationRepository;

	@Override
	@Transactional
	public Validation create(Validation validation) {

		if (validation.getId() == null)
			return validationRepository.save(validation);
		else {
			return validationRepository.findOne(validation.getId());
		}

	}

	@Override
	@Transactional
	public Validation delete(int id) throws ValidationNotFound {

		Validation deletedValidation = validationRepository.findOne(id);

		if (deletedValidation == null)
			throw new ValidationNotFound();

		validationRepository.delete(deletedValidation);
		return deletedValidation;

	}

	@Override
	public List<Validation> findAll() {
		return validationRepository.findAll();
	}

	@Override
	public Validation findById(int id) {
		return validationRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor = ValidationNotFound.class)
	public Validation update(Validation validation) throws ValidationNotFound {
		Validation updatedValidation = validationRepository.findOne(validation.getId());

		if (updatedValidation == null)
			throw new ValidationNotFound();

		updatedValidation.setDate(validation.getDate());
		updatedValidation.setDemandeDAchat(validation.getDemandeDAchat());
		updatedValidation.setValideur(validation.getValideur());

		return updatedValidation;
	}

}
