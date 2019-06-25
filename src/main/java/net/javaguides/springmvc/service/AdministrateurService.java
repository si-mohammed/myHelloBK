package net.javaguides.springmvc.service;

import java.util.List;

import net.javaguides.springmvc.entity.Administrateur;
import net.javaguides.springmvc.exception.ResourceNotFoundException;

public interface AdministrateurService {

	public List<Administrateur> getAdministrateurs();

	public void saveAdministrateur(Administrateur theAdministrateur);

	public Administrateur getAdministrateur(int theId) throws ResourceNotFoundException;

	public void deleteAdministrateur(int theId) throws ResourceNotFoundException;
}
