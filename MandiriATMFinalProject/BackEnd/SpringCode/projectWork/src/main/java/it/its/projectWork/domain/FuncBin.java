package it.its.projectWork.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FuncBin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@ManyToOne
	Bin bin;
	@ManyToOne
	Functionality functionality;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Bin getBin() {
		return bin;
	}
	public void setBin(Bin bin) {
		this.bin = bin;
	}
	public Functionality getFunctionality() {
		return functionality;
	}
	public void setFunctionality(Functionality functionality) {
		this.functionality = functionality;
	}
	
	
}
