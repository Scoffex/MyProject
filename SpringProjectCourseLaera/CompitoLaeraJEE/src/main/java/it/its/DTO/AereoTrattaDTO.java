package it.its.DTO;

public class AereoTrattaDTO {
	String aereoportoPartenza;
	String aereoportoArrivo;
	int kmPercorsi;
	String giornoDellaSettimana;
	int idTratta;
	int idAereo;
	
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
	public String getGiornoDellaSettimana() {
		return giornoDellaSettimana;
	}
	public void setGiornoDellaSettimana(String giornoDellaSettimana) {
		this.giornoDellaSettimana = giornoDellaSettimana;
	}
	public int getIdTratta() {
		return idTratta;
	}
	public void setIdTratta(int idTratta) {
		this.idTratta = idTratta;
	}
	public int getIdAereo() {
		return idAereo;
	}
	public void setIdAereo(int idAereo) {
		this.idAereo = idAereo;
	}
}