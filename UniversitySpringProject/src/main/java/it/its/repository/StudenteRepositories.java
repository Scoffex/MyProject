package it.its.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import it.its.domain.Gender;
import it.its.domain.Studente;

public interface StudenteRepositories extends JpaRepository<Studente, Integer>{


	public List<Studente> findByNomeAndCognome(String nome, String cognome);
	
	@Modifying
	@Query("update studente s SET s.nome=:nome, s.cognome=:cognome, s.dataNascita=:data, s.email=:email, s.password =:password, s.sesso=:sesso WHERE s.id =:idd")
	public void updateStudente(@Param("nome")String nome, @Param("cognome") String cognome, @Param("data") LocalDate dataDiNascita, @Param("email") String email, @Param("password") String password, @Param("sesso") Gender sesso, @Param("idd") int id);
	
	
	
	

}
