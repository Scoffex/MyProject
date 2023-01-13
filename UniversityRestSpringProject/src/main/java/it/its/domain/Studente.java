package it.its.domain;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity( name = "studente")
public class Studente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String nome;
	String cognome;
	LocalDate dataNascita;
	Gender sesso;
	String email;
	String password;
	@OneToMany(mappedBy = "studente", targetEntity = StudenteCorso.class)
	List<StudenteCorso> studenteCorso;

	
	
}
