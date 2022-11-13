package it.its.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AereoTratta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@ManyToOne
	Aereo aereo;
	@ManyToOne
	Tratta tratta;
	String giornoDellaSettimana;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Aereo getAereo() {
		return aereo;
	}
	public void setAereo(Aereo aereo) {
		this.aereo = aereo;
	}
	public Tratta getTratta() {
		return tratta;
	}
	public void setTratta(Tratta tratta) {
		this.tratta = tratta;
	}
	public String getGiornoDellaSettimana() {
		return giornoDellaSettimana;
	}
	public void setGiornoDellaSettimana(String giornoDellaSettimana) {
		this.giornoDellaSettimana = giornoDellaSettimana;
	}
	

}
