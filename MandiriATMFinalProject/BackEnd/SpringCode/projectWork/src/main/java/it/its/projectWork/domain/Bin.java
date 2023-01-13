package it.its.projectWork.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bin {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 int id;
	 String binValue;
	 @OneToMany(mappedBy = "bin", targetEntity = FuncBin.class)
	 List<FuncBin> functionalities;
	 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBinValue() {
		return binValue;
	}
	public void setBinValue(String binValue) {
		this.binValue = binValue;
	}
	public List<FuncBin> getFunctionalities() {
		return functionalities;
	}
	public void setFunctionalities(List<FuncBin> functionalities) {
		this.functionalities = functionalities;
	}
	 
	 
}
