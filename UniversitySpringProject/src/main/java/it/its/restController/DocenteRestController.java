package it.its.restController;


import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.its.DTO.DocenteDTO;
import it.its.servicesImpl.DocenteServiceImpl;

@RestController
@RequestMapping("/api/university")
public class DocenteRestController {

	@Autowired 
	DocenteServiceImpl docService;
	
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DocenteDTO save (@RequestBody DocenteDTO docenteDTO) throws ParseException{
		return docService.save(docenteDTO);
	}
}
