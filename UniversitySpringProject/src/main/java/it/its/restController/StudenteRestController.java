package it.its.restController;


import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import it.its.DTO.StudenteDTO;

import it.its.services.StudenteService;

@RestController
@RequestMapping("/university/student")
public class StudenteRestController {

	@Autowired
	StudenteService studService;
	@Autowired
	ApplicationEventPublisher publisher;
	
	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String save(@RequestBody @Valid StudenteDTO studenteDTO, final HttpServletRequest request) {
		studService.save(studenteDTO, 0, request);
		return "Registration success ";
	}
	
	public String scompone (HttpServletRequest request) {
		return "http://"  + request.getServerName() + ":" + request.getServerPort()+ "/" + request.getContextPath();
	}
	
	@GetMapping(value = "/getById/{id}")
	public StudenteDTO getById(@PathVariable int id) {
		return studService.getById(id);
	}
	
	@GetMapping(value = "/getAll")
	public List<StudenteDTO> getAll(){
		return studService.getAll();
	}
	
	@GetMapping(value = "/getByNameAndSurname/{nome}/{cognome}")
	public List<StudenteDTO> findByNomeAndCognome(@PathVariable("nome") String nome, @PathVariable("cognome") String cognome){
		return studService.findByNomeAndCognome(nome, cognome);
	}
	
	@GetMapping(value="/getByMaterieId/{materieId}")
	public List<StudenteDTO> findByMaterie(@PathVariable("materieId") List<Integer> idMaterie){
		return studService.findByIdMaterie(idMaterie);
	}
	
	@GetMapping(value="/getByMaterieId2/{materieId}")
	public List<Integer> findByMaterie2(@PathVariable("materieId") List<Integer> idMaterie){
		return idMaterie;
	}
	
	@PutMapping(value="/update/{id}")
	public String update(@PathVariable("id") int id, @RequestBody @Valid StudenteDTO studenteDTO) {
		 studService.update(id, studenteDTO);
		 return "update eseguito con successo";
	}
	
	@DeleteMapping(value="/delete/{id}")
	public String delete(@PathVariable int id) {
		return studService.deleteById(id);
	}
}
