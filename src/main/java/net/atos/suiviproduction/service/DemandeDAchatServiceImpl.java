package net.atos.suiviproduction.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.atos.suiviproduction.exception.DemandeDAchatNotFound;
import net.atos.suiviproduction.model.DemandeDAchat;
import net.atos.suiviproduction.repository.DemandeDAchatRepository;

@Service
public class DemandeDAchatServiceImpl implements DemandeDAchatService {

	@Resource
	private DemandeDAchatRepository demandeDAchatRepository;

	@Override
	@Transactional
	public DemandeDAchat create(DemandeDAchat demandeDAchat) {

		if (demandeDAchat.getId() == null)
			return demandeDAchatRepository.save(demandeDAchat);
		else {
			return demandeDAchatRepository.findOne(demandeDAchat.getId());
		}

	}

	@Override
	@Transactional
	public DemandeDAchat delete(int id) throws DemandeDAchatNotFound {

		DemandeDAchat deletedDemandeDAchat = demandeDAchatRepository.findOne(id);

		if (deletedDemandeDAchat == null)
			throw new DemandeDAchatNotFound();

		demandeDAchatRepository.delete(deletedDemandeDAchat);
		return deletedDemandeDAchat;

	}

	@Override
	public List<DemandeDAchat> findAll() {
		return demandeDAchatRepository.findAll();
	}

	@Override
	public DemandeDAchat findById(int id) {
		return demandeDAchatRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor = DemandeDAchatNotFound.class)
	public DemandeDAchat update(DemandeDAchat demandeDAchat) throws DemandeDAchatNotFound {
		DemandeDAchat updatedDemandeDAchat = demandeDAchatRepository.findOne(demandeDAchat.getId());

		if (updatedDemandeDAchat == null)
			throw new DemandeDAchatNotFound();

		updatedDemandeDAchat.setDate(demandeDAchat.getDate());
		updatedDemandeDAchat.setNumero(demandeDAchat.getNumero());
		updatedDemandeDAchat.setNumeroDeBonDeCommande(demandeDAchat.getNumeroDeBonDeCommande());
		updatedDemandeDAchat.setStatut(demandeDAchat.getStatut());
		updatedDemandeDAchat.setCollaborateur(demandeDAchat.getCollaborateur());

		return updatedDemandeDAchat;
	}

}
