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

import net.javaguides.springmvc.entity.CompteCourantAd;
import net.javaguides.springmvc.exception.ResourceNotFoundException;
import net.javaguides.springmvc.service.CompteCourantAdService;


@Controller
@RequestMapping("/compteCourantAd")
public class CompteCourantAdController {
	
	private static final Logger LOG = LoggerFactory.getLogger(CompteCourantAdController.class);

	@Autowired
	private CompteCourantAdService compteCourantAdService;
	
	@GetMapping("/list")
	public String listCompteCourantAds(Model theModel) {
		List<CompteCourantAd> theCompteCourantAds = compteCourantAdService.getCompteCourantAds();
		theModel.addAttribute("compteCourantAds", theCompteCourantAds);
		return "compteCourantAd/list-compteCourantAds";
	}
			
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		LOG.debug("inside show compteCourantAd-form handler method");
		CompteCourantAd theCompteCourantAd = new CompteCourantAd();
		theModel.addAttribute("compteCourantAd", theCompteCourantAd);
		return "compteCourantAd/compteCourantAd-form";
	}
	
	@PostMapping("/saveCompteCourantAd")
	public String saveCustomer(@ModelAttribute("compteCourantAd") CompteCourantAd theCompteCourantAd) {
		compteCourantAdService.saveCompteCourantAd(theCompteCourantAd);	
		return "redirect:/compteCourantAd/list";
	}
	
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("compteCourantAdId") int theId,
									Model theModel) throws ResourceNotFoundException {
		CompteCourantAd theCompteCourantAd = compteCourantAdService.getCompteCourantAd(theId);	
		theModel.addAttribute("compteCourantAd", theCompteCourantAd);
		return "compteCourantAd/compteCourantAd-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("compteCourantAdId") int theId) throws ResourceNotFoundException {
		compteCourantAdService.deleteCompteCourantAd(theId);
		return "redirect:/compteCourantAd/list";
	}
}
