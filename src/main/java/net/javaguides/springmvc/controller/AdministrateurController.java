package net.javaguides.springmvc.controller;

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

import net.javaguides.springmvc.entity.Administrateur;
import net.javaguides.springmvc.exception.ResourceNotFoundException;
import net.javaguides.springmvc.service.AdministrateurService;

@Controller
@RequestMapping("/administrateur")
public class AdministrateurController {
	
	private static final Logger LOG = LoggerFactory.getLogger(AdministrateurController.class);

	@Autowired
	private AdministrateurService administrateurService;
	
	@GetMapping("/list")
	public String listAdministrateurs(Model theModel) {
		List<Administrateur> theAdministrateurs = administrateurService.getAdministrateurs();
		theModel.addAttribute("administrateurs", theAdministrateurs);
		return "administrateur/list-administrateurs";
	}
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		LOG.debug("inside show administrateur-form handler method");
		Administrateur theAdministrateur = new Administrateur();
		theModel.addAttribute("administrateur", theAdministrateur);
		return "administrateur/administrateur-form";
	}
	
	@PostMapping("/saveAdministrateur")
	public String saveAdministrateur(@ModelAttribute("administrateur") Administrateur theAdministrateur) {
		administrateurService.saveAdministrateur(theAdministrateur);	
		return "redirect:/administrateur/list";
	}
	
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("administrateurId") int theId,
									Model theModel) throws ResourceNotFoundException {
		Administrateur theAdministrateur = administrateurService.getAdministrateur(theId);	
		theModel.addAttribute("administrateur", theAdministrateur);
		return "administrateur/administrateur-form";
	}
	
	@GetMapping("/delete")
	public String deleteAdministrateur(@RequestParam("administrateurId") int theId) throws ResourceNotFoundException {
		administrateurService.deleteAdministrateur(theId);
		return "redirect:/administrateur/list";
	}
}
