package it.its.projectWork.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Functionality {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	String description;
	boolean enabled;
	FuncType type;
	boolean multisession;
	@OneToMany(mappedBy = "functionality", targetEntity = FuncPeripheral.class)
	List<FuncPeripheral> peripherals;
	@OneToMany(mappedBy = "functionality", targetEntity = FuncBankCode.class)
	List<FuncBankCode> bankCodes;
	@OneToMany(mappedBy = "functionality", targetEntity = FuncBin.class)
	List<FuncBin> bins;
	
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
	public List<FuncPeripheral> getPeripherals() {
		return peripherals;
	}
	public void setPeripherals(List<FuncPeripheral> peripherals) {
		this.peripherals = peripherals;
	}
	public List<FuncBankCode> getBankCodes() {
		return bankCodes;
	}
	public void setBankCodes(List<FuncBankCode> bankCodes) {
		this.bankCodes = bankCodes;
	}
	public List<FuncBin> getBins() {
		return bins;
	}
	public void setBins(List<FuncBin> bins) {
		this.bins = bins;
	}
	
	
	
}
