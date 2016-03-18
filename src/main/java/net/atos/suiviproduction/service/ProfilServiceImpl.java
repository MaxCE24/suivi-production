package net.atos.suiviproduction.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.atos.suiviproduction.exception.ProfilNotFound;
import net.atos.suiviproduction.model.Profil;
import net.atos.suiviproduction.repository.ProfilRepository;

@Service
public class ProfilServiceImpl implements ProfilService {

	@Resource
	private ProfilRepository profilRepository;

	@Override
	@Transactional
	public Profil create(Profil profil) {
		if (profil.getId() == null)
			return profilRepository.save(profil);
		else {
			return profilRepository.findOne(profil.getId());
		}
	}

	@Override
	@Transactional
	public Profil delete(int id) throws ProfilNotFound {
		Profil deletedProfil = profilRepository.findOne(id);

		if (deletedProfil == null)
			throw new ProfilNotFound();

		profilRepository.delete(deletedProfil);
		return deletedProfil;
	}

	@Override
	public List<Profil> findAll() {
		return profilRepository.findAll();
	}

	@Override
	public Profil findById(int id) {
		return profilRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor = ProfilNotFound.class)
	public Profil update(Profil profil) throws ProfilNotFound {
		Profil updatedProfil = profilRepository.findOne(profil.getId());

		if (updatedProfil == null)
			throw new ProfilNotFound();

		updatedProfil.setLibelle(profil.getLibelle());

		return updatedProfil;
	}

}
