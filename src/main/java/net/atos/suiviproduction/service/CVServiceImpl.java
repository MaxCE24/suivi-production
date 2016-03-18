package net.atos.suiviproduction.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.atos.suiviproduction.exception.CVNotFound;
import net.atos.suiviproduction.model.CV;
import net.atos.suiviproduction.repository.CVRepository;

@Service
public class CVServiceImpl implements CVService {

	@Resource
	private CVRepository cVRepository;

	@Override
	@Transactional
	public CV create(CV cV) {
		if (cV.getId() == null)
			return cVRepository.save(cV);
		else {
			return cVRepository.findOne(cV.getId());
		}
	}

	@Override
	@Transactional
	public CV delete(int id) throws CVNotFound {
		CV deletedCV = cVRepository.findOne(id);

		if (deletedCV == null)
			throw new CVNotFound();

		cVRepository.delete(deletedCV);
		return deletedCV;
	}

	@Override
	public List<CV> findAll() {
		return cVRepository.findAll();
	}

	@Override
	public CV findById(int id) {
		return cVRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor = CVNotFound.class)
	public CV update(CV cV) throws CVNotFound {
		CV updatedCV = cVRepository.findOne(cV.getId());

		if (updatedCV == null)
			throw new CVNotFound();

		updatedCV.setcV(cV.getcV());

		return updatedCV;
	}

}
