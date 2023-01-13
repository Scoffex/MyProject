package it.its.projectWork.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.its.projectWork.domain.Bin;

@Repository
public interface BinRepository extends JpaRepository<Bin, Integer>{
	
	public List<Bin> findByBinValueLike(String binValue);
	
	@Query(nativeQuery = true,value = "SELECT b.bin_value FROM bin b;")
	public List<String> findAllBinValues();
}
