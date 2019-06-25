package net.javaguides.springmvc.service;

import java.util.List;

import net.javaguides.springmvc.entity.Agent;
import net.javaguides.springmvc.exception.ResourceNotFoundException;

public interface AgentService {

	public List<Agent> getAgents();

	public void saveAgent(Agent theAgent);

	public Agent getAgent(int theId) throws ResourceNotFoundException;

	public void deleteAgent(int theId) throws ResourceNotFoundException;
	
}
