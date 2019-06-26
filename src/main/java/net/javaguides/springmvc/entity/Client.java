package net.javaguides.springmvc.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idClient;

	@JsonManagedReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="Utilisateur_idUtilisateur")
	private Utilisateur utilisateur;

	@JsonManagedReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="Agent_idAgent")
	private Agent agent;

	@JsonManagedReference
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy="client", fetch = FetchType.LAZY)
	private List<ClientDemande> clientDemandes;

	@JsonManagedReference
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy="client", fetch = FetchType.LAZY)
	private List<Compte> comptes;
	
	public Client() {
	}

	public int getIdClient() {
		return this.idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Agent getAgent() {
		return this.agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public List<ClientDemande> getClientDemandes() {
		return this.clientDemandes;
	}

	public void setClientDemandes(List<ClientDemande> clientDemandes) {
		this.clientDemandes = clientDemandes;
	}

	public ClientDemande addClientDemande(ClientDemande clientDemande) {
		getClientDemandes().add(clientDemande);
		clientDemande.setClient(this);

		return clientDemande;
	}

	public ClientDemande removeClientDemande(ClientDemande clientDemande) {
		getClientDemandes().remove(clientDemande);
		clientDemande.setClient(null);

		return clientDemande;
	}

	public List<Compte> getComptes() {
		return this.comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public Compte addCompte(Compte compte) {
		getComptes().add(compte);
		compte.setClient(this);

		return compte;
	}

	public Compte removeCompte(Compte compte) {
		getComptes().remove(compte);
		compte.setClient(null);

		return compte;
	}
}