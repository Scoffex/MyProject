package it.its.projectWork.RestControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.its.projectWork.DTO.FunctionalityDTO;
import it.its.projectWork.DTO.PanDTO;
import it.its.projectWork.services.interfaces.IFunctionalityService;

@RestController
@RequestMapping("/api/banking")
public class FunctionalityRestController {

	@Autowired
	IFunctionalityService funcService;

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FunctionalityDTO> save(@RequestBody FunctionalityDTO dto) throws NotFoundException {
		return new ResponseEntity<FunctionalityDTO>(funcService.save(dto), HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> delete(@PathVariable int id) throws NotFoundException {
		funcService.delete(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(value = "/findAll/pageSize/{pageSize}/pageNumber/{pageNumber}", method = RequestMethod.GET)
	public ResponseEntity<List<FunctionalityDTO>> findAll(@PathVariable int pageNumber, @PathVariable int pageSize) {
		return new ResponseEntity<List<FunctionalityDTO>>(funcService.findAll(pageNumber, pageSize), HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpStatus> update(@RequestBody FunctionalityDTO dto) throws NotFoundException {
		funcService.update(dto);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(value = "findById/{id}", method = RequestMethod.GET)
	public ResponseEntity<FunctionalityDTO> findById(@PathVariable int id) throws NotFoundException {
		return new ResponseEntity<FunctionalityDTO>(funcService.findById(id), HttpStatus.OK);
	}

	@RequestMapping(value = "findByPanAtmBank", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<FunctionalityDTO> findByPanAtmBank(@RequestBody PanDTO panDTO) {
		return funcService.findByPanAtmBank(panDTO);
	}
}
