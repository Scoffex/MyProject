package it.its.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.its.DTO.CorsoDTO;
import it.its.services.CorsoService;

@RestController
@RequestMapping("api/university/corso")
public class CorsoRestController {
	@Autowired
	CorsoService corsoService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CorsoDTO save(@RequestBody CorsoDTO corsoDTO) {
		
		return corsoService.save(corsoDTO);
	}
}
