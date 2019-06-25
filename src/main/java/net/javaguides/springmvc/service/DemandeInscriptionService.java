package net.javaguides.springmvc.service;

import java.util.List;

import net.javaguides.springmvc.entity.DemandeInscription;
import net.javaguides.springmvc.exception.ResourceNotFoundException;

public interface DemandeInscriptionService {

	public List<DemandeInscription> getDemandeInscriptions();

	public void saveDemandeInscription(DemandeInscription theDemandeInscription);

	public DemandeInscription getDemandeInscription(int theId) throws ResourceNotFoundException;

	public void deleteDemandeInscription(int theId) throws ResourceNotFoundException;
	
}
