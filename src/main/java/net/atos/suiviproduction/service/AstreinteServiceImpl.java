package net.atos.suiviproduction.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.atos.suiviproduction.exception.AstreinteNotFound;
import net.atos.suiviproduction.exception.CollaborateurNotFound;
import net.atos.suiviproduction.model.Astreinte;
import net.atos.suiviproduction.repository.AstreinteRepository;

@Service
public class AstreinteServiceImpl implements AstreinteService {

	@Resource
	private AstreinteRepository astreinteRepository;

	@Override
	@Transactional
	public Astreinte create(Astreinte astreinte) {

		if (astreinte.getId() == null)
			return astreinteRepository.save(astreinte);
		else {
			return astreinteRepository.findOne(astreinte.getId());
		}

	}

	@Override
	@Transactional
	public Astreinte delete(int id) throws AstreinteNotFound {
		Astreinte deletedAstreinte = astreinteRepository.findOne(id);

		if (deletedAstreinte == null)
			throw new AstreinteNotFound();

		astreinteRepository.delete(deletedAstreinte);
		return deletedAstreinte;
	}

	@Override
	public List<Astreinte> findAll() {
		return astreinteRepository.findAll();
	}

	@Override
	public Astreinte findById(int id) {
		return astreinteRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor = CollaborateurNotFound.class)
	public Astreinte update(Astreinte astreinte) throws AstreinteNotFound {
		Astreinte updatedAstreinte = astreinteRepository.findOne(astreinte.getId());

		if (updatedAstreinte == null)
			throw new AstreinteNotFound();

		updatedAstreinte.setReference(astreinte.getReference());
		updatedAstreinte.setDate(astreinte.getDate());
		updatedAstreinte.setNombreHeures(astreinte.getNombreHeures());
		updatedAstreinte.setType(astreinte.getType());
		return updatedAstreinte;
	}

}
