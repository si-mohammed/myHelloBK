package net.javaguides.springmvc.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the client_demande database table.
 * 
 */
@Entity
@Table(name="client_demande")
@NamedQuery(name="ClientDemande.findAll", query="SELECT c FROM ClientDemande c")
public class ClientDemande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idClient_Demande;

	@Lob
	@Column(name="description_demande")
	private String descriptionDemande;

	@Column(name="type_demande")
	private String typeDemande;

	//bi-directional many-to-one association to Agent
	@ManyToOne
	private Agent agent;

	//bi-directional many-to-one association to Client
	@ManyToOne
	private Client client;

	public ClientDemande() {
	}

	public int getIdClient_Demande() {
		return this.idClient_Demande;
	}

	public void setIdClient_Demande(int idClient_Demande) {
		this.idClient_Demande = idClient_Demande;
	}

	public String getDescriptionDemande() {
		return this.descriptionDemande;
	}

	public void setDescriptionDemande(String descriptionDemande) {
		this.descriptionDemande = descriptionDemande;
	}

	public String getTypeDemande() {
		return this.typeDemande;
	}

	public void setTypeDemande(String typeDemande) {
		this.typeDemande = typeDemande;
	}

	public Agent getAgent() {
		return this.agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}