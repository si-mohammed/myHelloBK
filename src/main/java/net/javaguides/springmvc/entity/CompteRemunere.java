package net.javaguides.springmvc.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the compte_remunere database table.
 * 
 */
@Entity
@Table(name="compte_remunere")
@NamedQuery(name="CompteRemunere.findAll", query="SELECT c FROM CompteRemunere c")
public class CompteRemunere implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCompte_Remunere;

	private int plafond;

	@Column(name="taux_remun")
	private float tauxRemun;

	//bi-directional many-to-one association to Compte
	@ManyToOne
	private Compte compte;

	public CompteRemunere() {
	}

	public int getIdCompte_Remunere() {
		return this.idCompte_Remunere;
	}

	public void setIdCompte_Remunere(int idCompte_Remunere) {
		this.idCompte_Remunere = idCompte_Remunere;
	}

	public int getPlafond() {
		return this.plafond;
	}

	public void setPlafond(int plafond) {
		this.plafond = plafond;
	}

	public float getTauxRemun() {
		return this.tauxRemun;
	}

	public void setTauxRemun(float tauxRemun) {
		this.tauxRemun = tauxRemun;
	}

	public Compte getCompte() {
		return this.compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}