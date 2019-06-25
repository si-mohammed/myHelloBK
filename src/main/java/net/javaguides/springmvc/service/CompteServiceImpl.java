package net.javaguides.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springmvc.entity.Compte;
import net.javaguides.springmvc.exception.ResourceNotFoundException;
import net.javaguides.springmvc.repository.CompteRepository;

@Service
public class CompteServiceImpl implements CompteService {

	@Autowired
	private CompteRepository compteRepository;
	
	@Override
	@Transactional
	public List<Compte> getComptes() {
		return compteRepository.findAll();
	}

	@Override
	@Transactional
	public void saveCompte(Compte theCompte) {
		compteRepository.save(theCompte);
	}

	@Override
	@Transactional
	public Compte getCompte(int id) throws ResourceNotFoundException {
		return compteRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(id));
	}

	@Override
	@Transactional
	public void deleteCompte(int theId) {
		compteRepository.deleteById(theId);
	}
}





