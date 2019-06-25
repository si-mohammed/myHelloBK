package net.javaguides.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springmvc.entity.Agent;

@Repository("agentRepository")
public interface AgentRepository extends JpaRepository<Agent, Integer> {

}
