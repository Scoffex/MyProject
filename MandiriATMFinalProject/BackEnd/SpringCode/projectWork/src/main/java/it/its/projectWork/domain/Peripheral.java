package it.its.projectWork.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Peripheral {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	@OneToMany(mappedBy = "peripheral", targetEntity = FuncPeripheral.class)
	List<FuncPeripheral> functionalities;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<FuncPeripheral> getFunctionalities() {
		return functionalities;
	}
	public void setFunctionalities(List<FuncPeripheral> functionalities) {
		this.functionalities = functionalities;
	}
	
	
}
