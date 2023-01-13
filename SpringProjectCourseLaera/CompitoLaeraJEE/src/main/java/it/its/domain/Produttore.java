package it.its.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Produttore {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String nome;
	String nazione;
	String sedeLegale;
	@OneToMany(mappedBy = "produttore")
	List<Aereo> aereo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNazione() {
		return nazione;
	}
	public void setNazione(String nazione) {
		this.nazione = nazione;
	}
	public String getSedeLegale() {
		return sedeLegale;
	}
	public void setSedeLegale(String sedeLegale) {
		this.sedeLegale = sedeLegale;
	}
	public List<Aereo> getAereo() {
		return aereo;
	}
	public void setAereo(List<Aereo> aereo) {
		this.aereo = aereo;
	}
	
	
}
