package net.javaguides.springmvc.repository;

import java.util.List;

import net.javaguides.springmvc.entity.Utilisateur;

public interface UtilisateurDao {
	public List<Utilisateur> getUtilisateurByName(String name);
	public List<Utilisateur> getUtilisateurBytelephoneFixe(String numphone);
	public List<Utilisateur> getUtilisateurBytelephoneMobile(String numphone);
	public List<Utilisateur> getUtilisateurBylogin(String login);
	public List<Utilisateur> getUtilisateurByemail(String email);
}
