package it.its.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import it.its.DTO.StudenteDTO;
import it.its.domain.Studente;
import it.its.domain.StudenteCorso;


public class Conversion {
	
	public static Studente fromStudenteDTOToStudente(StudenteDTO studenteDTO) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
		Studente studente = new Studente();
		studente.setCognome(studenteDTO.getCognome());
		studente.setNome(studenteDTO.getNome());
		studente.setSesso(studenteDTO.getSesso());
		studente.setDataNascita(LocalDate.parse(studenteDTO.getDataNascita(), formatter));
		studente.setEmail(studenteDTO.getEmail());
		return studente;
	}
	
	
	public static StudenteDTO fromStudenteToStudenteDTO(Studente studente) {
		StudenteDTO studenteDTO = new StudenteDTO();
		studenteDTO.setNome(studente.getNome());
		studenteDTO.setCognome(studente.getCognome());
		studenteDTO.setDataNascita(studente.getDataNascita().toString());
		studenteDTO.setSesso(studente.getSesso());
		studenteDTO.setEmail(studente.getEmail());
		studenteDTO.setPassword(studente.getPassword());
		List<Integer> corsoId = new ArrayList<Integer>();
		for (StudenteCorso studenteCorso : studente.getStudenteCorso()) {
			corsoId.add(studenteCorso.getCorso().getId());
		}
		studenteDTO.setCorsiId(corsoId);
		studenteDTO.setId(studente.getId());
		return studenteDTO;
	}
	
	public static List<StudenteDTO> fromStudenteListtoStudenteDTOList(List<Studente> listStudent){
		List<StudenteDTO> listStudentDTO = new ArrayList<StudenteDTO>();
		for(Studente studente : listStudent) {
			listStudentDTO.add(Conversion.fromStudenteToStudenteDTO(studente));
		}
		return listStudentDTO;
	}
	
	public static List<Studente> fromStudenteDTOListToStudent(List<StudenteDTO> dtoList){
		List<Studente> listStudent = new ArrayList<Studente>();
		for(StudenteDTO studenteDTO : dtoList) {
			listStudent.add(Conversion.fromStudenteDTOToStudente(studenteDTO));
		}
		return listStudent;
	}
}
