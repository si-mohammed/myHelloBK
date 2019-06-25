package net.javaguides.springmvc.service;

import java.util.List;

import net.javaguides.springmvc.entity.Client;
import net.javaguides.springmvc.exception.ResourceNotFoundException;

public interface ClientService {

	public List<Client> getClients();

	public void saveClient(Client theClient);

	public Client getClient(int theId) throws ResourceNotFoundException;

	public void deleteClient(int theId) throws ResourceNotFoundException;
	
}
