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

import net.javaguides.springmvc.entity.CompteCourantStd;
import net.javaguides.springmvc.exception.ResourceNotFoundException;
import net.javaguides.springmvc.service.CompteCourantStdService;

@Controller
@RequestMapping("/compteCourantStd")
public class CompteCourantStdController {
	
	private static final Logger LOG = LoggerFactory.getLogger(CompteCourantStdController.class);

	@Autowired
	private CompteCourantStdService compteCourantStdService;
	
	@GetMapping("/list")
	public String listCompteCourantStds(Model theModel) {
		List<CompteCourantStd> theCompteCourantStds = compteCourantStdService.getCompteCourantStds();
		theModel.addAttribute("compteCourantStds", theCompteCourantStds);
		return "compteCourantStd/list-compteCourantStds";
	}
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		LOG.debug("inside show compteCourantStd-form handler method");
		CompteCourantStd theCompteCourantStd = new CompteCourantStd();
		theModel.addAttribute("compteCourantStd", theCompteCourantStd);
		return "compteCourantStd/CompteCourantStd-form";
	}
	
	@PostMapping("/saveCompteCourantStd")
	public String saveCompteCourantStd(@ModelAttribute("compteCourantStd") CompteCourantStd theCompteCourantStd) {
		compteCourantStdService.saveCompteCourantStd(theCompteCourantStd);	
		return "redirect:/compteCourantStd/list";
	}
	
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("compteCourantStdId") int theId,
									Model theModel) throws ResourceNotFoundException {
		CompteCourantStd theCompteCourantStd = compteCourantStdService.getCompteCourantStd(theId);	
		theModel.addAttribute("compteCourantStd", theCompteCourantStd);
		return "compteCourantStd/compteCourantStd-form";
	}
	
	@GetMapping("/delete")
	public String deleteCompteCourantStd(@RequestParam("compteCourantStdId") int theId) throws ResourceNotFoundException {
		compteCourantStdService.deleteCompteCourantStd(theId);
		return "redirect:/compteCourantStd/list";
	}
}
