package it.its.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import it.its.DTO.StudenteDTO;
import it.its.domain.Studente;

public interface StudenteService {

	public Studente save(StudenteDTO studenteDTO, int identify, HttpServletRequest request);
	public StudenteDTO getById(int id);
	public List<StudenteDTO> getAll();
	public String deleteById(int id);
	public List<StudenteDTO> findByNomeAndCognome(String nome, String cognome);
	public void update(int id, StudenteDTO studenteDTO);
	public List<StudenteDTO> findByIdMaterie(List<Integer> idMaterie);
	public void saveVerificationToken (Studente studente, String token);
	}
