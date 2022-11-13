package it.its.event.listner;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import it.its.domain.Studente;
import it.its.event.RegistrationCompleteEvent;
import it.its.services.StudenteService;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RegistrationEventListner implements ApplicationListener<RegistrationCompleteEvent>{

	@Autowired
	StudenteService studService;
	
	@Override
	public void onApplicationEvent(RegistrationCompleteEvent event) {
		Studente studente = event.getStudente();
		String token = UUID.randomUUID().toString();
		studService.saveVerificationToken(studente, token);
		String url = event.getApplicationUrl() + "verifyRegistration?token=" + token;
		log.info("Click the link to verify your account{}", url);
	}

}
