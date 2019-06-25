package net.javaguides.springmvc.service;

import java.util.List;

import net.javaguides.springmvc.entity.ClientDemande;
import net.javaguides.springmvc.exception.ResourceNotFoundException;

public interface ClientDemandeService {

	public List<ClientDemande> getClientDemandes();

	public void saveClientDemande(ClientDemande theClientDemande);

	public ClientDemande getClientDemande(int theId) throws ResourceNotFoundException;

	public void deleteClientDemande(int theId) throws ResourceNotFoundException;
	
}
