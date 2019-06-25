package net.javaguides.springmvc.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;


/**
 * The persistent class for the administrateur database table.
 * 
 */
@Entity
@NamedQuery(name="Administrateur.findAll", query="SELECT a FROM Administrateur a")
public class Administrateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAdministrateur;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="Utilisateur_idUtilisateur")
	private Utilisateur userAdmin;
	
	@JsonBackReference
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy="administrateur", fetch = FetchType.LAZY)
	private List<DemandeInscription> demandeInscriptions;

	public Administrateur() {
	}

	public int getIdAdministrateur() {
		return this.idAdministrateur;
	}

	public void setIdAdministrateur(int idAdministrateur) {
		this.idAdministrateur = idAdministrateur;
	}

	public Utilisateur getUtilisateur() {
		return this.userAdmin;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.userAdmin = utilisateur;
	}

	public List<DemandeInscription> getDemandeInscriptions() {
		return this.demandeInscriptions;
	}

	public void setDemandeInscriptions(List<DemandeInscription> demandeInscriptions) {
		this.demandeInscriptions = demandeInscriptions;
	}

	public DemandeInscription addDemandeInscription(DemandeInscription demandeInscription) {
		getDemandeInscriptions().add(demandeInscription);
		demandeInscription.setAdministrateur(this);

		return demandeInscription;
	}

	public DemandeInscription removeDemandeInscription(DemandeInscription demandeInscription) {
		getDemandeInscriptions().remove(demandeInscription);
		demandeInscription.setAdministrateur(null);

		return demandeInscription;
	}
}