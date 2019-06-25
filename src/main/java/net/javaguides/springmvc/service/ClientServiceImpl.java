package net.javaguides.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import net.javaguides.springmvc.entity.Client;
import net.javaguides.springmvc.exception.ResourceNotFoundException;
import net.javaguides.springmvc.repository.ClientRepository;

public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public List<Client> getClients() {
		return clientRepository.findAll();
	}

	@Override
	public void saveClient(Client theClient) {
		clientRepository.save(theClient);

	}

	@Override
	public Client getClient(int id) throws ResourceNotFoundException {
		return clientRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(id));
	}

	@Override
	public void deleteClient(int theId) throws ResourceNotFoundException {
		clientRepository.deleteById(theId);

	}

}
