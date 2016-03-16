package net.atos.suiviproduction.service;

import java.util.List;

import net.atos.suiviproduction.exception.ValidationNotFound;
import net.atos.suiviproduction.model.Validation;

public interface ValidationService {

	public Validation create(Validation validation);

	public Validation delete(int id) throws ValidationNotFound;

	public List<Validation> findAll();

	public Validation findById(int id);

	public Validation update(Validation validation) throws ValidationNotFound;

}
