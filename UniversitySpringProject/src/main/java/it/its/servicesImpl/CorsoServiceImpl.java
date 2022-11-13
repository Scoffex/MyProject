package it.its.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.DTO.CorsoDTO;
import it.its.domain.Corso;
import it.its.repository.CorsoRepositories;
import it.its.repository.DocenteRepositories;
import it.its.repository.StudenteCorsoRepositories;
import it.its.services.CorsoService;
 
@Service
public class CorsoServiceImpl implements CorsoService{

	@Autowired
	CorsoRepositories repoCorso;
	@Autowired
	DocenteRepositories repoDocente;
	@Autowired
	StudenteCorsoRepositories scRepo;
	@Override
	public CorsoDTO save(CorsoDTO corsoDTO) {
		Corso corso = new Corso();
		corso.setDocente(repoDocente.findByCognome(corsoDTO.getCognomeDocente()));
		corso.setNomeCorso(corsoDTO.getNomeCorso());
		repoCorso.save(corso);
		corsoDTO.setId(corso.getId());
		return corsoDTO;
	}
	
	public void delete(int id) {
		scRepo.deleteById(id);
	}

	
}
