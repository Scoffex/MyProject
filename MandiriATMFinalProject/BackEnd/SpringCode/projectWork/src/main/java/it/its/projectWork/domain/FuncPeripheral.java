package it.its.projectWork.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FuncPeripheral {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@ManyToOne
	Peripheral peripheral;
	@ManyToOne
	Functionality functionality;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Peripheral getPeripheral() {
		return peripheral;
	}
	public void setPeripheral(Peripheral peripheral) {
		this.peripheral = peripheral;
	}
	public Functionality getFunctionality() {
		return functionality;
	}
	public void setFunctionality(Functionality functionality) {
		this.functionality = functionality;
	}
	
	
}
