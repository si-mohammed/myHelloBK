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

import net.javaguides.springmvc.entity.Agent;
import net.javaguides.springmvc.entity.Customer;
import net.javaguides.springmvc.exception.ResourceNotFoundException;
import net.javaguides.springmvc.service.AgentService;
import net.javaguides.springmvc.service.CustomerService;

@Controller
@RequestMapping("/agent")
public class AgentController {
	
	private static final Logger LOG = LoggerFactory.getLogger(AgentController.class);

	
	
	@Autowired
	private AgentService agentService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		
		
		
		List<Agent> theAgents = agentService.getAgents();
		theModel.addAttribute("agents", theAgents);
		return "agent/list-agents";
	}
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		LOG.debug("inside show agent-form handler method");
		Agent theAgent = new Agent();
		theModel.addAttribute("agent", theAgent);
		return "agent/agent-form";
	}
	
	@PostMapping("/saveAgent")
	public String saveAgent(@ModelAttribute("agent") Agent theAgent) {
		agentService.saveAgent(theAgent);	
		return "redirect:/agent/list";
	}
	
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("agentId") int theId,
									Model theModel) throws ResourceNotFoundException {
		Agent theAgent= agentService.getAgent(theId);	
		theModel.addAttribute("agent", theAgent);
		return "agent/agent-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) throws ResourceNotFoundException {
		agentService.deleteAgent(theId);
		return "redirect:/agent/list";
	}
}
