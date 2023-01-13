package it.its.projectWork.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BankCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	int id;
	String bankCode;
	String bank;
	
	@OneToMany(mappedBy = "bankCode", targetEntity = FuncBankCode.class)
	List<FuncBankCode> functionalities;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public List<FuncBankCode> getFunctionalities() {
		return functionalities;
	}
	public void setFunctionalities(List<FuncBankCode> functionalities) {
		this.functionalities = functionalities;
	}
	
	
}
