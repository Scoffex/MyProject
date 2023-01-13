package it.its.projectWork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.its.projectWork.domain.FuncPeripheral;

@Repository
public interface FuncPeripheralRepository extends JpaRepository<FuncPeripheral, Integer>{
	
}
