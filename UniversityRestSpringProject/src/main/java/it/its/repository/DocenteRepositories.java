package it.its.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.its.domain.Docente;

public interface DocenteRepositories extends JpaRepository<Docente, Integer>{

	@Query(nativeQuery = true,value = "SELECT * from DOCENTE as d where d.cognome = ?")
	public Docente findByCognome(String cognome);
}
