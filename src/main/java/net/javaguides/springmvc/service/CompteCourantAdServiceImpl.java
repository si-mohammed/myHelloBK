package net.javaguides.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springmvc.entity.CompteCourantAd;
import net.javaguides.springmvc.exception.ResourceNotFoundException;
import net.javaguides.springmvc.repository.CompteCourantAdRepository;

@Service
public class CompteCourantAdServiceImpl implements CompteCourantAdService {

	@Autowired
	private CompteCourantAdRepository compteCourantAdRepository;
	
	@Override
	@Transactional
	public List<CompteCourantAd> getCompteCourantAds() {
		return compteCourantAdRepository.findAll();
	}

	@Override
	@Transactional
	public void saveCompteCourantAd(CompteCourantAd theCompteCourantAd) {
		compteCourantAdRepository.save(theCompteCourantAd);
	}

	@Override
	@Transactional
	public CompteCourantAd getCompteCourantAd(int id) throws ResourceNotFoundException {
		return compteCourantAdRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(id));
	}

	@Override
	@Transactional
	public void deleteCompteCourantAd(int theId) {
		compteCourantAdRepository.deleteById(theId);
	}
}





