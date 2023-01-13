package it.its.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.DTO.DocenteDTO;
import it.its.domain.Docente;
import it.its.repository.DocenteRepositories;
import it.its.services.DocenteService;

@Service
public class DocenteServiceImpl implements DocenteService{

	@Autowired
	DocenteRepositories repoDoc;
	@Override
	public DocenteDTO save(DocenteDTO docenteDTO) {
		Docente docente = new Docente();
		docente.setCognome(docenteDTO.getCognome());
		docente.setNome(docenteDTO.getNome());
		repoDoc.save(docente);
		docenteDTO.setId(docente.getId());
		return docenteDTO;
	}

}
