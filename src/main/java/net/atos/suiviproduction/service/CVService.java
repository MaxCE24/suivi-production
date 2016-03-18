package net.atos.suiviproduction.service;

import java.util.List;

import net.atos.suiviproduction.exception.CVNotFound;
import net.atos.suiviproduction.model.CV;

public interface CVService {
	public CV create(CV cV);

	public CV delete(int id) throws CVNotFound;

	public List<CV> findAll();

	public CV findById(int id);

	public CV update(CV cV) throws CVNotFound;
}
