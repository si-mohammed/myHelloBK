package net.javaguides.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springmvc.entity.Agent;
import net.javaguides.springmvc.exception.ResourceNotFoundException;
import net.javaguides.springmvc.repository.AgentRepository;

@Service
public class AgentServiceImpl implements AgentService {

	@Autowired
	private AgentRepository agentRepository;
	
	@Override
	@Transactional
	public List<Agent> getAgents() {
		
		List<Agent> agentList = agentRepository.findAll();
		
		for(Agent elem:agentList) {
			elem.setClientDemandes(new ArrayList<>());
			elem.setDemandeInscriptions(new ArrayList<>());
			elem.setClients(new ArrayList<>());
			elem.setUtilisateur(null);
		}
		
		return agentList;
		
		
	}

	@Override
	@Transactional
	public void saveAgent(Agent theAgent) {
		agentRepository.save(theAgent);
	}

	@Override
	@Transactional
	public Agent getAgent(int id) throws ResourceNotFoundException {
		return agentRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(id));
	}

	@Override
	@Transactional
	public void deleteAgent(int theId) {
		agentRepository.deleteById(theId);
	}
}





