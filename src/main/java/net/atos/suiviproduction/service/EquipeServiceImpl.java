package net.atos.suiviproduction.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.atos.suiviproduction.exception.EquipeNotFound;
import net.atos.suiviproduction.model.Equipe;
import net.atos.suiviproduction.repository.EquipeRepository;

@Service
public class EquipeServiceImpl implements EquipeService {

	@Resource
	private EquipeRepository equipeRepository;

	@Override
	@Transactional
	public Equipe create(Equipe equipe) {
		if (equipe.getId() == null)
			return equipeRepository.save(equipe);
		else {
			return equipeRepository.findOne(equipe.getId());
		}
	}

	@Override
	@Transactional
	public Equipe delete(int id) throws EquipeNotFound {
		Equipe deletedEquipe = equipeRepository.findOne(id);

		if (deletedEquipe == null)
			throw new EquipeNotFound();

		equipeRepository.delete(deletedEquipe);
		return deletedEquipe;
	}

	@Override
	public List<Equipe> findAll() {
		return equipeRepository.findAll();
	}

	@Override
	public Equipe findById(int id) {
		return equipeRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor = EquipeNotFound.class)
	public Equipe update(Equipe equipe) throws EquipeNotFound {
		Equipe updatedEquipe = equipeRepository.findOne(equipe.getId());

		if (updatedEquipe == null)
			throw new EquipeNotFound();

		updatedEquipe.setNom(equipe.getNom());

		return updatedEquipe;
	}

}
