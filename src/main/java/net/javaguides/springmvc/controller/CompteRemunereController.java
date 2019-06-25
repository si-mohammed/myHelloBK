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

import net.javaguides.springmvc.entity.CompteRemunere;
import net.javaguides.springmvc.exception.ResourceNotFoundException;
import net.javaguides.springmvc.service.CompteRemunereService;

@Controller
@RequestMapping("/compteRemunere")
public class CompteRemunereController {
	
	private static final Logger LOG = LoggerFactory.getLogger(CompteRemunereController.class);

	@Autowired
	private CompteRemunereService compteRemunereService;
	
	@GetMapping("/list")
	public String listCompteRemuneres(Model theModel) {
		List<CompteRemunere> theCompteRemuneres = compteRemunereService.getCompteRemuneres();
		theModel.addAttribute("compteRemuneres", theCompteRemuneres);
		return "compteRemunere/list-customers";
	}
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		LOG.debug("inside show compteCourantRemunere-form handler method");
		CompteRemunere theCompteRemunere = new CompteRemunere();
		theModel.addAttribute("compteRemunere", theCompteRemunere);
		return "compteRemunere/compteRemunere-form";
	}
	
	@PostMapping("/saveCompteRemunere")
	public String saveCompteRemunere(@ModelAttribute("compteRemunere") CompteRemunere theCompteRemunere) {
		compteRemunereService.saveCompteRemunere(theCompteRemunere);	
		return "redirect:/compteRemunere/list";
	}
	
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("compteRemunereId") int theId,
									Model theModel) throws ResourceNotFoundException {
		CompteRemunere theCompteRemunere = compteRemunereService.getCompteRemunere(theId);	
		theModel.addAttribute("compteRemunere", theCompteRemunere);
		return "compteRemunere/compteRemunere-form";
	}
	
	@GetMapping("/delete")
	public String deleteCompteRemunere(@RequestParam("compteRemunereId") int theId) throws ResourceNotFoundException {
		compteRemunereService.deleteCompteRemunere(theId);
		return "redirect:/compteRemunere/list";
	}
}
