package net.atos.suiviproduction.service;

import java.util.List;

import net.atos.suiviproduction.exception.CollaborateurNotFound;
import net.atos.suiviproduction.model.Collaborateur;

public interface CollaborateurService {
	
	public Collaborateur create(Collaborateur collaborateur);

	public Collaborateur delete(int id) throws CollaborateurNotFound;

	public List<Collaborateur> findAll();

	public Collaborateur findById(int id);

	public Collaborateur update(Collaborateur collaborateur) throws CollaborateurNotFound;

}
