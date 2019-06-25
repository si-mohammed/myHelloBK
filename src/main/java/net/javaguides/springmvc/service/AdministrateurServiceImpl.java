package net.javaguides.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springmvc.entity.Administrateur;
import net.javaguides.springmvc.exception.ResourceNotFoundException;
import net.javaguides.springmvc.repository.AdministrateurRepository;

@Service
public class AdministrateurServiceImpl implements AdministrateurService {

	@Autowired
	private AdministrateurRepository administrateurRepository;
	
	@Override
	public List<Administrateur> getAdministrateurs() {
		return administrateurRepository.findAll();
	}

	@Override
	public void saveAdministrateur(Administrateur theAdministrateur) {
		administrateurRepository.save(theAdministrateur);
	}

	@Override
	public Administrateur getAdministrateur(int id) throws ResourceNotFoundException {
		return administrateurRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(id));
	}

	@Override
	public void deleteAdministrateur(int theId) throws ResourceNotFoundException {
		administrateurRepository.deleteById(theId);
	}

}
