package net.javaguides.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springmvc.entity.CompteRemunere;
import net.javaguides.springmvc.exception.ResourceNotFoundException;
import net.javaguides.springmvc.repository.CompteRemunereRepository;

@Service
public class CompteRemunereServiceImpl implements CompteRemunereService {

	@Autowired
	private CompteRemunereRepository compteRemunereRepository;
	
	@Override
	@Transactional
	public List<CompteRemunere> getCompteRemuneres() {
		return compteRemunereRepository.findAll();
	}

	@Override
	@Transactional
	public void saveCompteRemunere(CompteRemunere theCompteRemunere) {
		compteRemunereRepository.save(theCompteRemunere);
	}

	@Override
	@Transactional
	public CompteRemunere getCompteRemunere(int id) throws ResourceNotFoundException {
		return compteRemunereRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(id));
	}

	@Override
	@Transactional
	public void deleteCompteRemunere(int theId) {
		compteRemunereRepository.deleteById(theId);
	}
}





