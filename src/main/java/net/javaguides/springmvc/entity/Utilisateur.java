package net.javaguides.springmvc.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idUtilisateur;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="date_creation")
	private Date dateCreation;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_MaJ;

	private String email;

	private String genre;

	private String login;

	private String nom;

	private String password;

	private String prenom;

	private String role;

	private String statut;

	@Column(name="telephone_fixe")
	private String telephoneFixe;

	@Column(name="telephone_mobile")
	private String telephoneMobile;

	@JsonManagedReference
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY)
	private List<Administrateur> administrateurs;

	@JsonManagedReference
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy="utilisateur", fetch = FetchType.LAZY)		
	private List<Adresse> adresses;

	@JsonManagedReference
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy="utilisateur", fetch = FetchType.LAZY)
	private List<Agent> agents;

	@JsonManagedReference
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy="utilisateur", fetch = FetchType.LAZY)
	private List<Client> clients;

	public Utilisateur() {
	}

	public Integer getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDate_MaJ() {
		return this.date_MaJ;
	}

	public void setDate_MaJ(Date date_MaJ) {
		this.date_MaJ = date_MaJ;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getTelephoneFixe() {
		return this.telephoneFixe;
	}

	public void setTelephoneFixe(String telephoneFixe) {
		this.telephoneFixe = telephoneFixe;
	}

	public String getTelephoneMobile() {
		return this.telephoneMobile;
	}

	public void setTelephoneMobile(String telephoneMobile) {
		this.telephoneMobile = telephoneMobile;
	}


	public List<Administrateur> getAdministrateurs() {
		return this.administrateurs;
	}

	public void setAdministrateurs(List<Administrateur> administrateurs) {
		this.administrateurs = administrateurs;
	}

	public Administrateur addAdministrateur(Administrateur administrateur) {
		getAdministrateurs().add(administrateur);
		administrateur.setUtilisateur(this);

		return administrateur;
	}

	public Administrateur removeAdministrateur(Administrateur administrateur) {
		getAdministrateurs().remove(administrateur);
		administrateur.setUtilisateur(null);

		return administrateur;
	}

	public List<Adresse> getAdresses() {
		return this.adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	public Adresse addAdress(Adresse adress) {
		getAdresses().add(adress);
		adress.setUtilisateur(this);

		return adress;
	}

	public Adresse removeAdress(Adresse adress) {
		getAdresses().remove(adress);
		adress.setUtilisateur(null);

		return adress;
	}

	public List<Agent> getAgents() {
		return this.agents;
	}

	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}

	public Agent addAgent(Agent agent) {
		getAgents().add(agent);
		agent.setUtilisateur(this);

		return agent;
	}

	public Agent removeAgent(Agent agent) {
		getAgents().remove(agent);
		agent.setUtilisateur(null);

		return agent;
	}
	
	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client addClient(Client client) {
		getClients().add(client);
		client.setUtilisateur(this);

		return client;
	}

	public Client removeClient(Client client) {
		getClients().remove(client);
		client.setUtilisateur(null);

		return client;
	}
}