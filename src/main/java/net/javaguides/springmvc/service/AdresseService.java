package net.javaguides.springmvc.service;

import java.util.List;

import net.javaguides.springmvc.entity.Adresse;
import net.javaguides.springmvc.exception.ResourceNotFoundException;

public interface AdresseService {
	
	public List<Adresse> getAdresses();

	public void saveAdresse(Adresse theAdresse);

	public Adresse getAdresse(int theId) throws ResourceNotFoundException;

	public void deleteAdresse(int theId) throws ResourceNotFoundException;

}
