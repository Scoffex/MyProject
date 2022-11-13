package it.its.rest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.its.DTO.TrattaDTO;
import it.its.Iservice.ITrattaService;


@RestController
@RequestMapping("api/tratta")
public class TrattaRestController {
@Autowired
ITrattaService itrattaService;

@RequestMapping(value="/save", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
public TrattaDTO save(@RequestBody @Valid TrattaDTO trattaDTO) {
	return itrattaService.save(trattaDTO);
}
}
