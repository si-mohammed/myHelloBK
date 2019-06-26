package net.javaguides.springmvc.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the agent database table.
 * 
 */
@Entity
@NamedQuery(name="Agent.findAll", query="SELECT a FROM Agent a")
public class Agent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAgent;

	@JsonManagedReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="Utilisateur_idUtilisateur")
	private Utilisateur utilisateur;

	@JsonManagedReference
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy="agent", fetch = FetchType.LAZY)
	private List<Client> clients;

	@JsonManagedReference
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy="agent", fetch = FetchType.LAZY)
	private List<ClientDemande> clientDemandes;

	@JsonManagedReference
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy="agent", fetch = FetchType.LAZY)
	private List<DemandeInscription> demandeInscriptions;

	public Agent() {
	}

	public int getIdAgent() {
		return this.idAgent;
	}

	public void setIdAgent(int idAgent) {
		this.idAgent = idAgent;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client addClient(Client client) {
		getClients().add(client);
		client.setAgent(this);

		return client;
	}

	public Client removeClient(Client client) {
		getClients().remove(client);
		client.setAgent(null);

		return client;
	}

	public List<ClientDemande> getClientDemandes() {
		return this.clientDemandes;
	}

	public void setClientDemandes(List<ClientDemande> clientDemandes) {
		this.clientDemandes = clientDemandes;
	}

	public ClientDemande addClientDemande(ClientDemande clientDemande) {
		getClientDemandes().add(clientDemande);
		clientDemande.setAgent(this);

		return clientDemande;
	}

	public ClientDemande removeClientDemande(ClientDemande clientDemande) {
		getClientDemandes().remove(clientDemande);
		clientDemande.setAgent(null);

		return clientDemande;
	}

	public List<DemandeInscription> getDemandeInscriptions() {
		return this.demandeInscriptions;
	}

	public void setDemandeInscriptions(List<DemandeInscription> demandeInscriptions) {
		this.demandeInscriptions = demandeInscriptions;
	}

	public DemandeInscription addDemandeInscription(DemandeInscription demandeInscription) {
		getDemandeInscriptions().add(demandeInscription);
		demandeInscription.setAgent(this);

		return demandeInscription;
	}

	public DemandeInscription removeDemandeInscription(DemandeInscription demandeInscription) {
		getDemandeInscriptions().remove(demandeInscription);
		demandeInscription.setAgent(null);

		return demandeInscription;
	}
}