package it.its.projectWork.DTO;

import java.util.List;

import it.its.projectWork.domain.FuncType;

public class FunctionalityDTO {
	
	int id;
	String name;
	String description;
	boolean enabled;
	FuncType type;
	boolean multisession;
	List<Integer> peripherals;
	List<Integer> bankCodes;
	List<Integer> bins;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public FuncType getType() {
		return type;
	}
	public void setType(FuncType type) {
		this.type = type;
	}
	public boolean isMultisession() {
		return multisession;
	}
	public void setMultisession(boolean multisession) {
		this.multisession = multisession;
	}
	public List<Integer> getPeripherals() {
		return peripherals;
	}
	public void setPeripherals(List<Integer> peripherals) {
		this.peripherals = peripherals;
	}
	public List<Integer> getBankCodes() {
		return bankCodes;
	}
	public void setBankCodes(List<Integer> bankCodes) {
		this.bankCodes = bankCodes;
	}
	public List<Integer> getBins() {
		return bins;
	}
	public void setBins(List<Integer> bins) {
		this.bins = bins;
	}
	
	
}
