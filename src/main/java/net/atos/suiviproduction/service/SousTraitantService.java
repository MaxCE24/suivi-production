package net.atos.suiviproduction.service;

import java.util.List;

import net.atos.suiviproduction.exception.SousTraitantNotFound;
import net.atos.suiviproduction.model.SousTraitant;

public interface SousTraitantService {

	public SousTraitant create(SousTraitant sousTraitant);

	public SousTraitant delete(int id) throws SousTraitantNotFound;

	public List<SousTraitant> findAll();

	public SousTraitant findById(int id);

	public SousTraitant update(SousTraitant sousTraitant) throws SousTraitantNotFound;

}
