package it.its.DTO;

import java.util.List;

public class TrattaDTO {
	int id;
	String aereoportoPartenza;
	String aereoportoArrivo;
	int kmPercorsi;
	List<Integer> idAereo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAereoportoPartenza() {
		return aereoportoPartenza;
	}
	public void setAereoportoPartenza(String aereoportoPartenza) {
		this.aereoportoPartenza = aereoportoPartenza;
	}
	public String getAereoportoArrivo() {
		return aereoportoArrivo;
	}
	public void setAereoportoArrivo(String aereoportoArrivo) {
		this.aereoportoArrivo = aereoportoArrivo;
	}
	
	public int getKmPercorsi() {
		return kmPercorsi;
	}
	public void setKmPercorsi(int kmPercorsi) {
		this.kmPercorsi = kmPercorsi;
	}
	public List<Integer> getIdAereo() {
		return idAereo;
	}
	public void setIdAereo(List<Integer> idAereo) {
		this.idAereo = idAereo;
	}
	
	
}
