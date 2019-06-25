package net.javaguides.springmvc.service;

import java.util.List;

import net.javaguides.springmvc.entity.CompteRemunere;
import net.javaguides.springmvc.exception.ResourceNotFoundException;

public interface CompteRemunereService {

	public List<CompteRemunere> getCompteRemuneres();

	public void saveCompteRemunere(CompteRemunere theCompteRemunere);

	public CompteRemunere getCompteRemunere(int theId) throws ResourceNotFoundException;

	public void deleteCompteRemunere(int theId) throws ResourceNotFoundException;
	
}
