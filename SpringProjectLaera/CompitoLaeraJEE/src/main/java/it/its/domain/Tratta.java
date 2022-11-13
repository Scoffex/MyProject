package it.its.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tratta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String aereoportoPartenza;
	String aereoportoArrivo;
	int kmPercorsi;
	@OneToMany(mappedBy = "tratta")
	List<AereoTratta> aereoTratta;
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
	public List<AereoTratta> getAereoTratta() {
		return aereoTratta;
	}
	public void setAereoTratta(List<AereoTratta> aereoTratta) {
		this.aereoTratta = aereoTratta;
	}
	
}
