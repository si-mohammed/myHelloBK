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

import net.javaguides.springmvc.entity.ClientDemande;
import net.javaguides.springmvc.exception.ResourceNotFoundException;
import net.javaguides.springmvc.service.ClientDemandeService;

@Controller
@RequestMapping("/clientDemande")
public class ClientDemandeController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ClientDemandeController.class);

	@Autowired
	private ClientDemandeService clientDemandeService;
	
	@GetMapping("/list")
	public String listClientDemandes(Model theModel) {
		List<ClientDemande> theClientDemandes = clientDemandeService.getClientDemandes();
		theModel.addAttribute("clientDemandes", theClientDemandes);
		return "clientDemande/list-clientDemandes";
	}
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		LOG.debug("inside show customer-form handler method");
		ClientDemande theClientDemande = new ClientDemande();
		theModel.addAttribute("clientDemande", theClientDemande);
		return "clientDemande/clientDemande-form";
	}
	
	@PostMapping("/saveClientDemande")
	public String saveClientDemande(@ModelAttribute("clientDemande") ClientDemande theClientDemande) {
		clientDemandeService.saveClientDemande(theClientDemande);	
		return "redirect:/clientDemande/list";
	}
	
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("clientDemandeId") int theId,
									Model theModel) throws ResourceNotFoundException {
		ClientDemande theClientDemande = clientDemandeService.getClientDemande(theId);	
		theModel.addAttribute("clientDemande", theClientDemande);
		return "clientDemande/clientDemande-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("clientDemandeId") int theId) throws ResourceNotFoundException {
		clientDemandeService.deleteClientDemande(theId);
		return "redirect:/clientDemande/list";
	}
}
