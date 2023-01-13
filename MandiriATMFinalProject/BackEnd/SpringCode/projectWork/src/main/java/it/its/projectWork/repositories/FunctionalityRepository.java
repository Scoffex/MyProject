package it.its.projectWork.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.its.projectWork.domain.Functionality;

@Repository
public interface FunctionalityRepository extends JpaRepository<Functionality, Integer> {

	@Query(value = "SELECT * FROM functionality f " 
			+ "Where f.id IN ( " 
			+ "SELECT fbc.functionality_id FROM func_bank_code fbc "
			+ "WHERE bank_code_id = ?2) " 
			+ "AND f.id IN ( " 
			+ "SELECT fb.functionality_id FROM func_bin fb "
			+ "WHERE bin_id = ?1)"
			+ "AND f.enabled = true;", 
			nativeQuery = true)
	public List<Functionality> findByPanAtmBank(int bin_id, int bankCode_id);
}
