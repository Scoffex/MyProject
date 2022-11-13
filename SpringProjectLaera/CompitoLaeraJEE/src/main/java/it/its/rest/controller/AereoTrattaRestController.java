package it.its.rest.controller;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.its.DTO.AereoTrattaDTO;
import it.its.Iservice.IServiceTrattaAereo;
import it.its.exception.AereoNotFoundException;

@RestController
@RequestMapping("api/aereoTratta")
public class AereoTrattaRestController {
	@Autowired
	IServiceTrattaAereo iserviceTrattaAereo;
	
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
	public AereoTrattaDTO save(@RequestBody @Valid AereoTrattaDTO aereoTrattaDTO) throws EntityNotFoundException, AereoNotFoundException {
		return iserviceTrattaAereo.save(aereoTrattaDTO);
	}
	

}
