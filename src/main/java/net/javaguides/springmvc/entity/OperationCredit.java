package net.javaguides.springmvc.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the operation_credit database table.
 * 
 */
@Entity
@Table(name="operation_credit")
@NamedQuery(name="OperationCredit.findAll", query="SELECT o FROM OperationCredit o")
public class OperationCredit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idOperation_Credit;

	private int montant;

	//bi-directional many-to-one association to Operation
	@ManyToOne
	private Operation operation;

	public OperationCredit() {
	}

	public int getIdOperation_Credit() {
		return this.idOperation_Credit;
	}

	public void setIdOperation_Credit(int idOperation_Credit) {
		this.idOperation_Credit = idOperation_Credit;
	}

	public int getMontant() {
		return this.montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public Operation getOperation() {
		return this.operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

}