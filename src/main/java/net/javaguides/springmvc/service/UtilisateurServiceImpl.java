package net.javaguides.springmvc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springmvc.entity.Administrateur;
import net.javaguides.springmvc.entity.Adresse;
import net.javaguides.springmvc.entity.Agent;
import net.javaguides.springmvc.entity.Client;
import net.javaguides.springmvc.entity.Utilisateur;
import net.javaguides.springmvc.exception.ResourceNotFoundException;
import net.javaguides.springmvc.repository.UtilisateurRepository;



@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Override
	@Transactional
	public List<Utilisateur> getUtilisateurs() {

		 List<Utilisateur> u=utilisateurRepository.findAll();
		
		 for(Utilisateur elem:u) {

			elem.setAdministrateurs(new ArrayList<Administrateur>());
			elem.setAdresses(new ArrayList<Adresse>());
			elem.setAgents(new ArrayList<Agent>());
			elem.setClients(new ArrayList<Client>());
		}

		return u;
	}

	@Override
	@Transactional
	public void saveUtilisateur(Utilisateur theUtilisateur) {
		Date date = new Date(System.currentTimeMillis());
		if(theUtilisateur.getIdUtilisateur()==null) {
			System.out.println("Date Creat");
			theUtilisateur.setDateCreation(date);
		} else {
			System.out.println("Date Update");
			theUtilisateur.setDate_MaJ(date);
		}
		utilisateurRepository.save(theUtilisateur);
	}

	@Override
	@Transactional
	public Utilisateur getUtilisateur(int id) throws ResourceNotFoundException {
		return utilisateurRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(id));
	}

	@Override
	@Transactional
	public void deleteUtilisateur(int theId) {
		utilisateurRepository.deleteById(theId);
	}
}





