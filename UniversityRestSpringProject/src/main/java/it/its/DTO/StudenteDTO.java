package it.its.DTO;



import java.util.List;

import javax.validation.constraints.NotBlank;

import it.its.domain.Gender;
import it.its.validators.DateCustomConstraint;
import it.its.validators.EmailCustomConstraint;
import it.its.validators.PasswordCustomConstraint;
import lombok.Data;

@Data
public class StudenteDTO {
	int id;
	@NotBlank
	String nome;
	
	@NotBlank
	String cognome;
	
	@DateCustomConstraint
	String dataNascita;
	Gender sesso;
	
	@NotBlank
	@EmailCustomConstraint
	String email;
	
	@NotBlank
	@PasswordCustomConstraint
	String password;
	List<Integer> corsiId;

}
