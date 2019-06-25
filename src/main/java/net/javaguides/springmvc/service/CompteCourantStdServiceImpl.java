package net.javaguides.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springmvc.entity.CompteCourantStd;
import net.javaguides.springmvc.exception.ResourceNotFoundException;
import net.javaguides.springmvc.repository.CompteCourantStdRepository;

@Service
public class CompteCourantStdServiceImpl implements CompteCourantStdService {

	@Autowired
	private CompteCourantStdRepository compteCourantStdRepository;
	
	@Override
	@Transactional
	public List<CompteCourantStd> getCompteCourantStds() {
		return compteCourantStdRepository.findAll();
	}

	@Override
	@Transactional
	public void saveCompteCourantStd(CompteCourantStd theCompteCourantStd) {
		compteCourantStdRepository.save(theCompteCourantStd);
	}

	@Override
	@Transactional
	public CompteCourantStd getCompteCourantStd(int id) throws ResourceNotFoundException {
		return compteCourantStdRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(id));
	}

	@Override
	@Transactional
	public void deleteCompteCourantStd(int theId) {
		compteCourantStdRepository.deleteById(theId);
	}
}





