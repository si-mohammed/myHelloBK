package net.javaguides.springmvc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the compte database table.
 * 
 */
@Entity
@NamedQuery(name="Compte.findAll", query="SELECT c FROM Compte c")
public class Compte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCompte;

	@Temporal(TemporalType.DATE)
	@Column(name="date_cloture")
	private Date dateCloture;

	@Temporal(TemporalType.DATE)
	@Column(name="date_creation")
	private Date dateCreation;

	private String iban;

	private String rib;

	@Column(name="type_compte")
	private String typeCompte;

	//bi-directional many-to-one association to Client
	@ManyToOne
	private Client client;

	//bi-directional many-to-one association to CompteCourantAd
	@OneToMany(mappedBy="compte")
	private List<CompteCourantAd> compteCourantAds;

	//bi-directional many-to-one association to CompteCourantStd
	@OneToMany(mappedBy="compte")
	private List<CompteCourantStd> compteCourantStds;

	//bi-directional many-to-one association to CompteRemunere
	@OneToMany(mappedBy="compte")
	private List<CompteRemunere> compteRemuneres;

	//bi-directional many-to-one association to Operation
	@OneToMany(mappedBy="compte")
	private List<Operation> operations;

	public Compte() {
	}

	public int getIdCompte() {
		return this.idCompte;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public Date getDateCloture() {
		return this.dateCloture;
	}

	public void setDateCloture(Date dateCloture) {
		this.dateCloture = dateCloture;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getIban() {
		return this.iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getRib() {
		return this.rib;
	}

	public void setRib(String rib) {
		this.rib = rib;
	}

	public String getTypeCompte() {
		return this.typeCompte;
	}

	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<CompteCourantAd> getCompteCourantAds() {
		return this.compteCourantAds;
	}

	public void setCompteCourantAds(List<CompteCourantAd> compteCourantAds) {
		this.compteCourantAds = compteCourantAds;
	}

	public CompteCourantAd addCompteCourantAd(CompteCourantAd compteCourantAd) {
		getCompteCourantAds().add(compteCourantAd);
		compteCourantAd.setCompte(this);

		return compteCourantAd;
	}

	public CompteCourantAd removeCompteCourantAd(CompteCourantAd compteCourantAd) {
		getCompteCourantAds().remove(compteCourantAd);
		compteCourantAd.setCompte(null);

		return compteCourantAd;
	}

	public List<CompteCourantStd> getCompteCourantStds() {
		return this.compteCourantStds;
	}

	public void setCompteCourantStds(List<CompteCourantStd> compteCourantStds) {
		this.compteCourantStds = compteCourantStds;
	}

	public CompteCourantStd addCompteCourantStd(CompteCourantStd compteCourantStd) {
		getCompteCourantStds().add(compteCourantStd);
		compteCourantStd.setCompte(this);

		return compteCourantStd;
	}

	public CompteCourantStd removeCompteCourantStd(CompteCourantStd compteCourantStd) {
		getCompteCourantStds().remove(compteCourantStd);
		compteCourantStd.setCompte(null);

		return compteCourantStd;
	}

	public List<CompteRemunere> getCompteRemuneres() {
		return this.compteRemuneres;
	}

	public void setCompteRemuneres(List<CompteRemunere> compteRemuneres) {
		this.compteRemuneres = compteRemuneres;
	}

	public CompteRemunere addCompteRemunere(CompteRemunere compteRemunere) {
		getCompteRemuneres().add(compteRemunere);
		compteRemunere.setCompte(this);

		return compteRemunere;
	}

	public CompteRemunere removeCompteRemunere(CompteRemunere compteRemunere) {
		getCompteRemuneres().remove(compteRemunere);
		compteRemunere.setCompte(null);

		return compteRemunere;
	}

	public List<Operation> getOperations() {
		return this.operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public Operation addOperation(Operation operation) {
		getOperations().add(operation);
		operation.setCompte(this);

		return operation;
	}

	public Operation removeOperation(Operation operation) {
		getOperations().remove(operation);
		operation.setCompte(null);

		return operation;
	}

}