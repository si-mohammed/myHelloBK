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

import net.javaguides.springmvc.entity.Compte;
import net.javaguides.springmvc.exception.ResourceNotFoundException;
import net.javaguides.springmvc.service.CompteService;

@Controller
@RequestMapping("/compte")
public class CompteController {
	
	private static final Logger LOG = LoggerFactory.getLogger(CompteController.class);

	@Autowired
	private CompteService compteService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		List<Compte> theComptes = compteService.getComptes();
		theModel.addAttribute("comptes", theComptes);
		return "compte/list-comptes";
	}
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		LOG.debug("inside show compte-form handler method");
		Compte theCompte = new Compte();
		theModel.addAttribute("compte", theCompte);
		return "compte/compte-form";
	}
	
	@PostMapping("/saveCompte")
	public String saveCompte(@ModelAttribute("compte") Compte theCompte) {
		compteService.saveCompte(theCompte);	
		return "redirect:/compte/list";
	}
	
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("compteId") int theId,
									Model theModel) throws ResourceNotFoundException {
		Compte theCompte = compteService.getCompte(theId);	
		theModel.addAttribute("compte", theCompte);
		return "compte/compte-form";
	}
	
	@GetMapping("/delete")
	public String deleteCompte(@RequestParam("compteId") int theId) throws ResourceNotFoundException {
		compteService.deleteCompte(theId);
		return "redirect:/compte/list";
	}
}
