package net.javaguides.springmvc.service;

import java.util.List;

import net.javaguides.springmvc.entity.Compte;
import net.javaguides.springmvc.exception.ResourceNotFoundException;

public interface CompteService {

	public List<Compte> getComptes();

	public void saveCompte(Compte theCompte);

	public Compte getCompte(int theId) throws ResourceNotFoundException;

	public void deleteCompte(int theId) throws ResourceNotFoundException;
	
}
