package net.javaguides.springmvc.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the operation_debit database table.
 * 
 */
@Entity
@Table(name="operation_debit")
@NamedQuery(name="OperationDebit.findAll", query="SELECT o FROM OperationDebit o")
public class OperationDebit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idOperation_Debit;

	private int montant;

	//bi-directional many-to-one association to Operation
	@ManyToOne
	private Operation operation;

	public OperationDebit() {
	}

	public int getIdOperation_Debit() {
		return this.idOperation_Debit;
	}

	public void setIdOperation_Debit(int idOperation_Debit) {
		this.idOperation_Debit = idOperation_Debit;
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