package it.its;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class StudenteNotFoundException extends Exception {

	
	public StudenteNotFoundException() {
		super("Studente non trovato all'interno del sistema");
	}
}
