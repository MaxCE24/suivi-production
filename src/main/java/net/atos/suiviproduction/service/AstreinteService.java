package net.atos.suiviproduction.service;

import java.util.List;

import net.atos.suiviproduction.exception.AstreinteNotFound;
import net.atos.suiviproduction.model.Astreinte;

public interface AstreinteService {

	public Astreinte create(Astreinte astreinte);

	public Astreinte delete(int id) throws AstreinteNotFound;

	public List<Astreinte> findAll();

	public Astreinte findById(int id);

	public Astreinte update(Astreinte astreinte) throws AstreinteNotFound;

}
