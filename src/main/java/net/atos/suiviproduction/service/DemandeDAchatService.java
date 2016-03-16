package net.atos.suiviproduction.service;

import java.util.List;

import net.atos.suiviproduction.exception.DemandeDAchatNotFound;
import net.atos.suiviproduction.model.DemandeDAchat;

public interface DemandeDAchatService {

	public DemandeDAchat create(DemandeDAchat demandeDAchat);

	public DemandeDAchat delete(int id) throws DemandeDAchatNotFound;

	public List<DemandeDAchat> findAll();

	public DemandeDAchat findById(int id);

	public DemandeDAchat update(DemandeDAchat demandeDAchat) throws DemandeDAchatNotFound;

}
