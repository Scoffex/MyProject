package it.its.domain;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Aereo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String targa;
	String modello;
	int capienza;
	String nome;
	int annoDiProduzione;
	@ManyToOne
	Produttore produttore;
	@OneToMany(mappedBy = "aereo")
	List<AereoTratta> aereoTratta;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public int getCapienza() {
		return capienza;
	}
	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAnnoDiProduzione() {
		return annoDiProduzione;
	}
	public void setAnnoDiProduzione(int annoDiProduzione) {
		this.annoDiProduzione = annoDiProduzione;
	}
	public Produttore getProduttore() {
		return produttore;
	}
	public void setProduttore(Produttore produttore) {
		this.produttore = produttore;
	}
	
	
	

}
