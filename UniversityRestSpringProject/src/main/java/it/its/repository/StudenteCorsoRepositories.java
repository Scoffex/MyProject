package it.its.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import it.its.domain.StudenteCorso;

public interface StudenteCorsoRepositories extends JpaRepository<StudenteCorso, Integer> {
	
	@Query(nativeQuery = true, value ="select * from studente_corso sc where sc.studente_id = ?")
	public List<StudenteCorso> getByIdStudente(int id);
}
