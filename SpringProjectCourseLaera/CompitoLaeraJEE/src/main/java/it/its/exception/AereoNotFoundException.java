package it.its.exception;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;
@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AereoNotFoundException extends Exception{	
	public AereoNotFoundException() {
		// TODO Auto-generated constructor stub
		super("Aereo not found");
		}
}
