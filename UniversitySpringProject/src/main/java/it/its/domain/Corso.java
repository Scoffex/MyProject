package it.its.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Corso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String nomeCorso;
	@ManyToOne
	Docente docente;
	@OneToMany(mappedBy = "corso", targetEntity = StudenteCorso.class)
	List<StudenteCorso> studenteCorso;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeCorso() {
		return nomeCorso;
	}
	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	public List<StudenteCorso> getStudenteCorso() {
		return studenteCorso;
	}
	public void setStudenteCorso(List<StudenteCorso> studenteCorso) {
		this.studenteCorso = studenteCorso;
	}
	
}
