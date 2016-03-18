package net.atos.suiviproduction.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.atos.suiviproduction.exception.SousTraitantNotFound;
import net.atos.suiviproduction.model.SousTraitant;
import net.atos.suiviproduction.repository.SousTraitantRepositoy;

@Service
public class SousTraitantServiceImpl implements SousTraitantService {

	@Resource
	private SousTraitantRepositoy sousTraitantRepository;

	@Override
	@Transactional
	public SousTraitant create(SousTraitant sousTraitant) {
		if (sousTraitant.getId() == null)
			return sousTraitantRepository.save(sousTraitant);
		else {
			return sousTraitantRepository.findOne(sousTraitant.getId());
		}
	}

	@Override
	@Transactional
	public SousTraitant delete(int id) throws SousTraitantNotFound {
		SousTraitant deletedSousTraitant = sousTraitantRepository.findOne(id);

		if (deletedSousTraitant == null)
			throw new SousTraitantNotFound();

		sousTraitantRepository.delete(deletedSousTraitant);
		return deletedSousTraitant;
	}

	@Override
	public List<SousTraitant> findAll() {
		return sousTraitantRepository.findAll();
	}

	@Override
	public SousTraitant findById(int id) {
		return sousTraitantRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor = SousTraitantNotFound.class)
	public SousTraitant update(SousTraitant sousTraitant) throws SousTraitantNotFound {
		SousTraitant updatedSousTraitant = sousTraitantRepository.findOne(sousTraitant.getId());

		if (updatedSousTraitant == null)
			throw new SousTraitantNotFound();

		updatedSousTraitant.setcV(sousTraitant.getcV());
		updatedSousTraitant.setDateRecrutement(sousTraitant.getDateRecrutement());
		updatedSousTraitant.setEquipe(sousTraitant.getEquipe());
		updatedSousTraitant.setNom(sousTraitant.getNom());
		updatedSousTraitant.setNumeroDeTelephone(sousTraitant.getNumeroDeTelephone());
		updatedSousTraitant.setPrenom(sousTraitant.getPrenom());
		updatedSousTraitant.setProfil(sousTraitant.getProfil());
		updatedSousTraitant.setSexe(sousTraitant.getSexe());
		updatedSousTraitant.setSociete(sousTraitant.getSociete());

		return updatedSousTraitant;
	}

}
