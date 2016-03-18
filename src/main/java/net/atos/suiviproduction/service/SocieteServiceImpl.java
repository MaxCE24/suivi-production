package net.atos.suiviproduction.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.atos.suiviproduction.exception.SocieteNotFound;
import net.atos.suiviproduction.model.Societe;
import net.atos.suiviproduction.repository.SocieteRepository;

@Service
public class SocieteServiceImpl implements SocieteService {

	@Resource
	private SocieteRepository societeRepository;

	@Override
	@Transactional
	public Societe create(Societe societe) {
		if (societe.getId() == null)
			return societeRepository.save(societe);
		else {
			return societeRepository.findOne(societe.getId());
		}
	}

	@Override
	@Transactional
	public Societe delete(int id) throws SocieteNotFound {
		Societe deletedSociete = societeRepository.findOne(id);

		if (deletedSociete == null)
			throw new SocieteNotFound();

		societeRepository.delete(deletedSociete);
		return deletedSociete;
	}

	@Override
	public List<Societe> findAll() {
		return societeRepository.findAll();
	}

	@Override
	public Societe findById(int id) {
		return societeRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor = SocieteNotFound.class)
	public Societe update(Societe societe) throws SocieteNotFound {
		Societe updatedSociete = societeRepository.findOne(societe.getId());

		if (updatedSociete == null)
			throw new SocieteNotFound();

		updatedSociete.setRaisonSociale(societe.getRaisonSociale());

		return updatedSociete;
	}

}
