package net.javaguides.springmvc.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the compte_courant_std database table.
 * 
 */
@Entity
@Table(name="compte_courant_std")
@NamedQuery(name="CompteCourantStd.findAll", query="SELECT c FROM CompteCourantStd c")
public class CompteCourantStd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCompte_Courant_Std;

	//bi-directional many-to-one association to Compte
	@ManyToOne
	private Compte compte;

	public CompteCourantStd() {
	}

	public int getIdCompte_Courant_Std() {
		return this.idCompte_Courant_Std;
	}

	public void setIdCompte_Courant_Std(int idCompte_Courant_Std) {
		this.idCompte_Courant_Std = idCompte_Courant_Std;
	}

	public Compte getCompte() {
		return this.compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}