package it.its.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProduttoreNotFoundException extends Exception{
	
	public ProduttoreNotFoundException() {
		// TODO Auto-generated constructor stub
		super("Produttore not found");
	}

}
