package net.javaguides.springmvc.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the adresse database table.
 * 
 */
@Entity
@Proxy(lazy=false)
@NamedQuery(name="Adresse.findAll", query="SELECT a FROM Adresse a")
public class Adresse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idAdresse;

	@Column(name="complement_adresse_1")
	private String complementAdresse1;

	@Column(name="complement_adresse_2")
	private String complementAdresse2;

	private String cp;

	@Column(name="nom_voie")
	private String nomVoie;

	private String num;

	private String pays;

	@Column(name="type_voie")
	private String typeVoie;

	private String ville;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="Utilisateur_idUtilisateur")
    private Utilisateur utilisateur;

	public Adresse() {
	}

	public Integer getIdAdresse() {
		return this.idAdresse;
	}

	public void setIdAdresse(Integer idAdresse) {
		this.idAdresse = idAdresse;
	}

	public String getComplementAdresse1() {
		return this.complementAdresse1;
	}

	public void setComplementAdresse1(String complementAdresse1) {
		this.complementAdresse1 = complementAdresse1;
	}

	public String getComplementAdresse2() {
		return this.complementAdresse2;
	}

	public void setComplementAdresse2(String complementAdresse2) {
		this.complementAdresse2 = complementAdresse2;
	}

	public String getCp() {
		return this.cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getNomVoie() {
		return this.nomVoie;
	}

	public void setNomVoie(String nomVoie) {
		this.nomVoie = nomVoie;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getTypeVoie() {
		return this.typeVoie;
	}

	public void setTypeVoie(String typeVoie) {
		this.typeVoie = typeVoie;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}