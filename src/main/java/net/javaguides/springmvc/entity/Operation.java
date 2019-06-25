package net.javaguides.springmvc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the operation database table.
 * 
 */
@Entity
@NamedQuery(name="Operation.findAll", query="SELECT o FROM Operation o")
public class Operation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idOperation;

	@Temporal(TemporalType.DATE)
	@Column(name="date_operation")
	private Date dateOperation;

	@Lob
	private String libelle;

	//bi-directional many-to-one association to Compte
	@ManyToOne
	private Compte compte;

	//bi-directional many-to-one association to OperationCredit
	@OneToMany(mappedBy="operation")
	private List<OperationCredit> operationCredits;

	//bi-directional many-to-one association to OperationDebit
	@OneToMany(mappedBy="operation")
	private List<OperationDebit> operationDebits;

	public Operation() {
	}

	public int getIdOperation() {
		return this.idOperation;
	}

	public void setIdOperation(int idOperation) {
		this.idOperation = idOperation;
	}

	public Date getDateOperation() {
		return this.dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Compte getCompte() {
		return this.compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public List<OperationCredit> getOperationCredits() {
		return this.operationCredits;
	}

	public void setOperationCredits(List<OperationCredit> operationCredits) {
		this.operationCredits = operationCredits;
	}

	public OperationCredit addOperationCredit(OperationCredit operationCredit) {
		getOperationCredits().add(operationCredit);
		operationCredit.setOperation(this);

		return operationCredit;
	}

	public OperationCredit removeOperationCredit(OperationCredit operationCredit) {
		getOperationCredits().remove(operationCredit);
		operationCredit.setOperation(null);

		return operationCredit;
	}

	public List<OperationDebit> getOperationDebits() {
		return this.operationDebits;
	}

	public void setOperationDebits(List<OperationDebit> operationDebits) {
		this.operationDebits = operationDebits;
	}

	public OperationDebit addOperationDebit(OperationDebit operationDebit) {
		getOperationDebits().add(operationDebit);
		operationDebit.setOperation(this);

		return operationDebit;
	}

	public OperationDebit removeOperationDebit(OperationDebit operationDebit) {
		getOperationDebits().remove(operationDebit);
		operationDebit.setOperation(null);

		return operationDebit;
	}

}