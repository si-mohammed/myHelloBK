package net.javaguides.springmvc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the demande_inscription database table.
 * 
 */
@Entity
@Table(name="demande_inscription")
@NamedQuery(name="DemandeInscription.findAll", query="SELECT d FROM DemandeInscription d")
public class DemandeInscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idDemande_Inscription;

	@Temporal(TemporalType.DATE)
	@Column(name="date_demande")
	private Date dateDemande;

	private String email;

	@Lob
	@Column(name="message_demande")
	private String messageDemande;

	private String nom;

	private String prenom;

	@Column(name="telephone_fixe")
	private String telephoneFixe;

	@Column(name="telephone_mobile")
	private String telephoneMobile;

	//bi-directional many-to-one association to Administrateur
	@ManyToOne
	private Administrateur administrateur;

	//bi-directional many-to-one association to Agent
	@ManyToOne
	private Agent agent;

	public DemandeInscription() {
	}

	public int getIdDemande_Inscription() {
		return this.idDemande_Inscription;
	}

	public void setIdDemande_Inscription(int idDemande_Inscription) {
		this.idDemande_Inscription = idDemande_Inscription;
	}

	public Date getDateDemande() {
		return this.dateDemande;
	}

	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessageDemande() {
		return this.messageDemande;
	}

	public void setMessageDemande(String messageDemande) {
		this.messageDemande = messageDemande;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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

	public Administrateur getAdministrateur() {
		return this.administrateur;
	}

	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}

	public Agent getAgent() {
		return this.agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

}