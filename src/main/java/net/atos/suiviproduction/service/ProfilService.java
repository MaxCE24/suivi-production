package net.atos.suiviproduction.service;

import java.util.List;

import net.atos.suiviproduction.exception.ProfilNotFound;
import net.atos.suiviproduction.model.Profil;

public interface ProfilService {
	
	public Profil create(Profil profil);

	public Profil delete(int id) throws ProfilNotFound;

	public List<Profil> findAll();

	public Profil findById(int id);

	public Profil update(Profil profil) throws ProfilNotFound;

}
