package net.javaguides.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springmvc.entity.DemandeInscription;
import net.javaguides.springmvc.exception.ResourceNotFoundException;
import net.javaguides.springmvc.repository.DemandeInscriptionRepository;

@Service
public class DemandeInscriptionServiceImpl implements DemandeInscriptionService {

	@Autowired
	private DemandeInscriptionRepository demandeInscriptionRepository;
	
	@Override
	@Transactional
	public List<DemandeInscription> getDemandeInscriptions() {
		return demandeInscriptionRepository.findAll();
	}

	@Override
	@Transactional
	public void saveDemandeInscription(DemandeInscription theDemandeInscription) {
		demandeInscriptionRepository.save(theDemandeInscription);
	}

	@Override
	@Transactional
	public DemandeInscription getDemandeInscription(int id) throws ResourceNotFoundException {
		return demandeInscriptionRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(id));
	}

	@Override
	@Transactional
	public void deleteDemandeInscription(int theId) {
		demandeInscriptionRepository.deleteById(theId);
	}
}





