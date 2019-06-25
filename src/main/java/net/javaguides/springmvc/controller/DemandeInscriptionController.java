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

import net.javaguides.springmvc.entity.DemandeInscription;
import net.javaguides.springmvc.exception.ResourceNotFoundException;
import net.javaguides.springmvc.service.DemandeInscriptionService;

@Controller
@RequestMapping("/demandeInscription")
public class DemandeInscriptionController {
	
	private static final Logger LOG = LoggerFactory.getLogger(DemandeInscriptionController.class);

	@Autowired
	private DemandeInscriptionService demandeInscriptionService;
	
	@GetMapping("/list")
	public String listDemandeInscriptions(Model theModel) {
		List<DemandeInscription> theDemandeInscriptions = demandeInscriptionService.getDemandeInscriptions();
		theModel.addAttribute("demandeInscriptions", theDemandeInscriptions);
		return "demandeInscription/list-demandeInscriptions";
	}
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		LOG.debug("inside show demandeInscription-form handler method");
		DemandeInscription theDemandeInscription = new DemandeInscription();
		theModel.addAttribute("demandeInscription", theDemandeInscription);
		return "demandeInscription/demandeInscription-form";
	}
	
	@PostMapping("/saveDemandeInscription")
	public String saveDemandeInscription(@ModelAttribute("demandeInscription") DemandeInscription theDemandeInscription) {
		demandeInscriptionService.saveDemandeInscription(theDemandeInscription);	
		return "redirect:/demandeInscription/list";
	}
	
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("demandeInscriptionId") int theId,
									Model theModel) throws ResourceNotFoundException {
		DemandeInscription theDemandeInscription = demandeInscriptionService.getDemandeInscription(theId);	
		theModel.addAttribute("demandeInscription", theDemandeInscription);
		return "demandeInscription/demandeInscription-form";
	}
	
	@GetMapping("/delete")
	public String deleteDemandeInscription(@RequestParam("demandeInscriptionId") int theId) throws ResourceNotFoundException {
		demandeInscriptionService.deleteDemandeInscription(theId);
		return "redirect:/demandeInscription/list";
	}
}
