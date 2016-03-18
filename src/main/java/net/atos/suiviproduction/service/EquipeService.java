package net.atos.suiviproduction.service;

import java.util.List;

import net.atos.suiviproduction.exception.EquipeNotFound;
import net.atos.suiviproduction.model.Equipe;

public interface EquipeService {
	
	public Equipe create(Equipe equipe);

	public Equipe delete(int id) throws EquipeNotFound;

	public List<Equipe> findAll();

	public Equipe findById(int id);

	public Equipe update(Equipe equipe) throws EquipeNotFound;

}
