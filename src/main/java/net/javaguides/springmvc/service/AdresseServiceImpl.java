package net.javaguides.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springmvc.entity.Adresse;
import net.javaguides.springmvc.exception.ResourceNotFoundException;
import net.javaguides.springmvc.repository.AdresseRepository;
@Service
public class AdresseServiceImpl implements AdresseService {
	
	@Autowired
	private AdresseRepository adresseRepository;

	@Override
	@Transactional
	public List<Adresse> getAdresses() {
		return adresseRepository.findAll();
	}

	@Override
	@Transactional
	public void saveAdresse(Adresse theAdresse) {
		adresseRepository.save(theAdresse);

	}

	@Override
	@Transactional
	public Adresse getAdresse(int theId) throws ResourceNotFoundException {
		return adresseRepository.findById(theId).orElseThrow(
				() -> new ResourceNotFoundException(theId));
	}

	@Override
	@Transactional
	public void deleteAdresse(int theId) throws ResourceNotFoundException {
		adresseRepository.deleteById(theId);
	}

}
