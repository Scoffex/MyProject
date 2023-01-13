package it.its.projectWork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.its.projectWork.domain.FuncBin;

@Repository
public interface FuncBinRepository extends JpaRepository<FuncBin, Integer>{

}
