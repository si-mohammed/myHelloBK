package net.javaguides.springmvc.repository;

import java.util.List;

import net.javaguides.springmvc.entity.Client;

public interface ClientDao {
	public List<Client> getClientByName(String name);
}
