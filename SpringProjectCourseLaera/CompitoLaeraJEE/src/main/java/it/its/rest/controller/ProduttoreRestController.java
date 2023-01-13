package it.its.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.its.DTO.ProduttoreDTO;

import it.its.Iservice.IServiceProduttore;
import it.its.exception.ProduttoreNotFoundException;

@RestController
@RequestMapping("/api/produttore")
public class ProduttoreRestController {
	@Autowired
	IServiceProduttore iserviceProduttore;

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProduttoreDTO save(@RequestBody @Valid ProduttoreDTO produttoreDTO) {
		return iserviceProduttore.save(produttoreDTO);
	}

	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
	public ProduttoreDTO getById(@PathVariable("id") int id) throws ProduttoreNotFoundException {
		return iserviceProduttore.getById(id);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<ProduttoreDTO> getAll() {
		return iserviceProduttore.getAll();
	}
}
