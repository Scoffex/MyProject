package it.its.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.its.domain.Aereo;

@Repository
public interface AereoRepository extends JpaRepository<Aereo, Integer>{
	@Query("from Aereo as a where a.nome = :Nome")
	public List<Aereo> getByName(@Param("Nome") String nome);
	public List<Aereo> findByannoDiProduzione(int data);
	
	@Query("from Aereo as a where a.produttore.id = :Id")
	public List<Aereo> getAereoByIdProduttore(@Param("Id") int Id);

}
