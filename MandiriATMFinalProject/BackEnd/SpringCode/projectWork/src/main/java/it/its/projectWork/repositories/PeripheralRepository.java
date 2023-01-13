package it.its.projectWork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.its.projectWork.domain.Peripheral;

@Repository
public interface PeripheralRepository extends JpaRepository<Peripheral, Integer>{
	
}
