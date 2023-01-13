package it.its.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.its.DTO.AereoDTO;
import it.its.Iservice.IServiceAereo;
import it.its.exception.AereoNotFoundException;


@RestController
@RequestMapping("/api/aereo")
public class AereoRestController {
	@Autowired
	IServiceAereo iserviceAereo;
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
	public AereoDTO save(@RequestBody @Valid AereoDTO aereoDTO) {
		return iserviceAereo.save(aereoDTO);
	}
	@RequestMapping(value="/getByNome/{nome}", method = RequestMethod.GET)
	public List<AereoDTO> getByName(@PathVariable("nome") String nome){
		return iserviceAereo.getByNome(nome);
	}
	@RequestMapping(value="/getByIdProduttore/{id}", method = RequestMethod.GET)
	public List<AereoDTO> getByName(@PathVariable("id") int id){
		return iserviceAereo.getAereoByIdProduttore(id);
	}
	
	
	@RequestMapping(value="/getByAnnoDiProduzione/{data}", method = RequestMethod.GET)
	public List<AereoDTO> getByAnnoDiProduzione(@PathVariable("data") int data){
		return new ArrayList<AereoDTO>(iserviceAereo.getByAnnoDiProduzione(data));
}	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleta(@PathVariable("id") int id) throws AereoNotFoundException {
		iserviceAereo.delete(id);	
		}
	
}
