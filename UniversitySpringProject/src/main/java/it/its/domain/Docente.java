package it.its.domain;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
@Data
@Entity
public class Docente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String nome;
	String cognome;
	@OneToMany(mappedBy = "docente", targetEntity = Corso.class)
	List<Corso> corso;

}
