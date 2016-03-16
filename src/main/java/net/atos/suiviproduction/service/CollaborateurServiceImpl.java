package net.atos.suiviproduction.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.atos.suiviproduction.exception.CollaborateurNotFound;
import net.atos.suiviproduction.model.Collaborateur;
import net.atos.suiviproduction.model.EmailAddress;
import net.atos.suiviproduction.repository.CollaborateurRepository;

@Service
public class CollaborateurServiceImpl implements CollaborateurService {

	@Resource
	private CollaborateurRepository collaborateurRepository;

	@Override
	@Transactional
	public Collaborateur create(Collaborateur collaborateur) {

		if (collaborateur.getId() == null) {
			collaborateur.setEmailAddress(new EmailAddress(collaborateur.getPrenom().toLowerCase() + "."
					+ collaborateur.getNom().toLowerCase() + "@atos.net"));
			return collaborateurRepository.save(collaborateur);
		} else
			return collaborateurRepository.findOne(collaborateur.getId());

	}

	@Override
	@Transactional
	public Collaborateur delete(int id) throws CollaborateurNotFound {
		Collaborateur deletedCollaborateur = collaborateurRepository.findOne(id);

		if (deletedCollaborateur == null)
			throw new CollaborateurNotFound();

		collaborateurRepository.delete(deletedCollaborateur);
		return deletedCollaborateur;
	}

	@Override
	public List<Collaborateur> findAll() {
		return collaborateurRepository.findAll();
	}

	@Override
	public Collaborateur findById(int id) {
		return collaborateurRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor = CollaborateurNotFound.class)
	public Collaborateur update(Collaborateur collaborateur) throws CollaborateurNotFound {
		System.out.println("UPDATE : COLLABORATEUR : ID : " + collaborateur.getId());
		Collaborateur updatedCollaborateur = collaborateurRepository.findOne(collaborateur.getId());

		if (updatedCollaborateur == null)
			throw new CollaborateurNotFound();

		updatedCollaborateur.setNom(collaborateur.getNom());
		updatedCollaborateur.setPrenom(collaborateur.getPrenom());
		return updatedCollaborateur;
	}

}
