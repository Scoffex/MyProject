package it.its.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.its.domain.TokenValidazioneUtente;

public interface StudenteTokenRepository extends JpaRepository<TokenValidazioneUtente, Integer>{

	@Query(nativeQuery = true, value ="select * from token_studente ts where ts.id_studente = ?")
	public TokenValidazioneUtente getByIdStudente(int id); 
}
