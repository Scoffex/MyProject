package it.its.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import it.its.validators.AnnoCapienzaCustomConstraint;
@AnnoCapienzaCustomConstraint(annoDiProduzione = "annoDiProduzione", capienza = "capienza")
public class AereoDTO {
	int id;
	@NotBlank
	String targa;
	@NotBlank
	String modello;
	@NotNull
	int capienza;
	@NotBlank
	String nome;
	@Range(min = 1980, max = 2022, message="ERRORE")
	int annoDiProduzione;
	@NotNull
	int idProduttore;
	
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
	public int getIdProduttore() {
		return idProduttore;
	}
	public void setIdProduttore(int idProduttore) {
		this.idProduttore = idProduttore;
	}
	

}
