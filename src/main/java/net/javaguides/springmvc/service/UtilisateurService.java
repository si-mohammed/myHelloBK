package net.javaguides.springmvc.service;

import java.util.List;

import net.javaguides.springmvc.entity.Utilisateur;
import net.javaguides.springmvc.exception.ResourceNotFoundException;

public interface UtilisateurService {

	public List<Utilisateur> getUtilisateurs();

	public void saveUtilisateur(Utilisateur theUtilisateur);

	public Utilisateur getUtilisateur(int theId) throws ResourceNotFoundException;

	public void deleteUtilisateur(int theId) throws ResourceNotFoundException;
	
}
