package it.its.projectWork.DTO;

import java.util.List;

public class PanDTO {
	
	String pan;
	String bankCode;
	List<Integer> peripherals;
	
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public List<Integer> getPeripherals() {
		return peripherals;
	}
	public void setPeripherals(List<Integer> peripherals) {
		this.peripherals = peripherals;
	}
	
}
