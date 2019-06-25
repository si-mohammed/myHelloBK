package net.javaguides.springmvc.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the compte_courant_ad database table.
 * 
 */
@Entity
@Table(name="compte_courant_ad")
@NamedQuery(name="CompteCourantAd.findAll", query="SELECT c FROM CompteCourantAd c")
public class CompteCourantAd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCompte_Courant_AD;

	private int decouvert;

	//bi-directional many-to-one association to Compte
	@ManyToOne
	private Compte compte;

	public CompteCourantAd() {
	}

	public int getIdCompte_Courant_AD() {
		return this.idCompte_Courant_AD;
	}

	public void setIdCompte_Courant_AD(int idCompte_Courant_AD) {
		this.idCompte_Courant_AD = idCompte_Courant_AD;
	}

	public int getDecouvert() {
		return this.decouvert;
	}

	public void setDecouvert(int decouvert) {
		this.decouvert = decouvert;
	}

	public Compte getCompte() {
		return this.compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}