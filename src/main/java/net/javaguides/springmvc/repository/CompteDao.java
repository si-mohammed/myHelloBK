package net.javaguides.springmvc.repository;

import java.util.List;

import net.javaguides.springmvc.entity.Compte;

public interface CompteDao {
	public List<Compte> getCompteByIBAN(String IBAN);
	public List<Compte> getCompteByRIB(String RIB);
}
