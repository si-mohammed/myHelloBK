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

import net.javaguides.springmvc.entity.Adresse;
import net.javaguides.springmvc.entity.Customer;
import net.javaguides.springmvc.exception.ResourceNotFoundException;
import net.javaguides.springmvc.service.AdresseService;
import net.javaguides.springmvc.service.CustomerService;

@Controller
@RequestMapping("/adresse")
public class AdresseController {
	
	private static final Logger LOG = LoggerFactory.getLogger(AdresseController.class);

	@Autowired
	private AdresseService adresseService;
	
	@GetMapping("/list")
	public String listAdresses(Model theModel) {
		List<Adresse> theAdresses = adresseService.getAdresses();
		theModel.addAttribute("adresses", theAdresses);
		return "adresse/list-adresses";
	}
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		LOG.debug("inside show customer-form handler method");
		Adresse theAdresse = new Adresse();
		theModel.addAttribute("adresse", theAdresse);
		return "adresse/adresse-form";
	}
	
	@PostMapping("/saveAdresse")
	public String saveAdresse(@ModelAttribute("adresse") Adresse theAdresse) {
		adresseService.saveAdresse(theAdresse);	
		return "redirect:/adresse/list";
	}
	
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("adresseId") int theId,
									Model theModel) throws ResourceNotFoundException {
		Adresse theAdresse = adresseService.getAdresse(theId);	
		theModel.addAttribute("cdresse", theAdresse);
		return "adresse/adresse-form";
	}
	
	@GetMapping("/delete")
	public String deleteAdresse(@RequestParam("adresseId") int theId) throws ResourceNotFoundException {
		adresseService.deleteAdresse(theId);
		return "redirect:/adresse/list";
	}
}
