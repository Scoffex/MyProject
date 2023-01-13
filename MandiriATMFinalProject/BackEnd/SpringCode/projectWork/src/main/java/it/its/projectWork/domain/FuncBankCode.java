package it.its.projectWork.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FuncBankCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@ManyToOne
	Functionality functionality;
	@ManyToOne
	BankCode bankCode;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Functionality getFunctionality() {
		return functionality;
	}
	public void setFunctionality(Functionality functionality) {
		this.functionality = functionality;
	}
	public BankCode getBankCode() {
		return bankCode;
	}
	public void setBankCode(BankCode bankCode) {
		this.bankCode = bankCode;
	}
	
	
}


