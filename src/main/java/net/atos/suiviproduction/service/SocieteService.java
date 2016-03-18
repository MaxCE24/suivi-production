package net.atos.suiviproduction.service;

import java.util.List;

import net.atos.suiviproduction.exception.SocieteNotFound;
import net.atos.suiviproduction.model.Societe;

public interface SocieteService {
	
	public Societe create(Societe societe);

	public Societe delete(int id) throws SocieteNotFound;

	public List<Societe> findAll();

	public Societe findById(int id);

	public Societe update(Societe societe) throws SocieteNotFound;

}
