package it.its.event;

import org.springframework.context.ApplicationEvent;

import it.its.domain.Studente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent{

	Studente studente;
	String applicationUrl;
	
	public RegistrationCompleteEvent(Studente studente, String applicationUrl) {
		super(studente);
		this.studente = studente;
		this.applicationUrl = applicationUrl;
	}

}
