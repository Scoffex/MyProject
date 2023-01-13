package it.its.projectWork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.its.projectWork.domain.FuncBankCode;

@Repository
public interface FuncBankCodeRepository extends JpaRepository<FuncBankCode, Integer>{

}
