package net.javaguides.springmvc.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springmvc.entity.Utilisateur;
import net.javaguides.springmvc.exception.ResourceNotFoundException;
import net.javaguides.springmvc.service.UtilisateurService;

@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {

	private static final Logger LOG = LoggerFactory.getLogger(UtilisateurController.class);

	@Autowired
	private UtilisateurService utilisateurService;

	@GetMapping("/list")
	public String listUtilisateurs(Model theModel) {
		List<Utilisateur> theUtilisateurs = utilisateurService.getUtilisateurs();
		theModel.addAttribute("utilisateurs", theUtilisateurs);
		return "utilisateur/list-utilisateurs";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		LOG.debug("inside show utilisateur-form handler method");
		Utilisateur theUtilisateur = new Utilisateur();
		theModel.addAttribute("utilisateur", theUtilisateur);
		return "utilisateur/utilisateur-form";
	}

	@PostMapping("/saveUtilisateur")
	public String saveUtilisateur(@ModelAttribute("utilisateur") Utilisateur theUtilisateur) {
		utilisateurService.saveUtilisateur(theUtilisateur);	
		return "redirect:/utilisateur/list";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("utilisateurId") int theId ,
			Model theModel) throws ResourceNotFoundException {
		Utilisateur theUtilisateur = utilisateurService.getUtilisateur(theId);
		theModel.addAttribute("utilisateur", theUtilisateur);
		return "utilisateur/utilisateur-form";
	}

	@GetMapping("/delete")
	public String deleteUtilisateur(@RequestParam("utilisateurId") int theId) throws ResourceNotFoundException {
		utilisateurService.deleteUtilisateur(theId);
		return "redirect:/utilisateur/list";
	}
}
