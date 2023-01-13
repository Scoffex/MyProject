package it.its.projectWork.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.its.projectWork.domain.BankCode;

@Repository
public interface BankCodeRepository extends JpaRepository<BankCode, Integer>{
	
	public List<BankCode> findByBank(String bankCode);
}
