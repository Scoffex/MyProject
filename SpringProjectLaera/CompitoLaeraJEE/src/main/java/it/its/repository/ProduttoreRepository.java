package it.its.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.its.domain.Produttore;

@Repository
public interface ProduttoreRepository extends JpaRepository<Produttore, Integer>{

}
