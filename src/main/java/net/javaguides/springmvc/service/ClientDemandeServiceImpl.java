package net.javaguides.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springmvc.entity.ClientDemande;
import net.javaguides.springmvc.exception.ResourceNotFoundException;
import net.javaguides.springmvc.repository.ClientDemandeRepository;


@Service
public class ClientDemandeServiceImpl implements ClientDemandeService {

	@Autowired
	private ClientDemandeRepository clientDemandeRepository;
	
	@Override
	@Transactional
	public List<ClientDemande> getClientDemandes() {
		return clientDemandeRepository.findAll();
	}

	@Override
	@Transactional
	public void saveClientDemande(ClientDemande theClientDemande) {
		clientDemandeRepository.save(theClientDemande);
	}

	@Override
	@Transactional
	public ClientDemande getClientDemande(int id) throws ResourceNotFoundException {
		return clientDemandeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(id));
	}

	@Override
	@Transactional
	public void deleteClientDemande(int theId) {
		clientDemandeRepository.deleteById(theId);
	}
}





