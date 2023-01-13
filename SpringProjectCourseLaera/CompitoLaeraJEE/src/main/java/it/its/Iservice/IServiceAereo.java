package it.its.Iservice;

import java.util.List;

import it.its.DTO.AereoDTO;
import it.its.exception.AereoNotFoundException;


public interface IServiceAereo {
	public AereoDTO save(AereoDTO aereoDTO);
	public List<AereoDTO> getByNome(String nome);
	public List<AereoDTO> getByAnnoDiProduzione(int data);
	public List<AereoDTO> getAereoByIdProduttore(int id);
	public void delete(int id) throws AereoNotFoundException;
	
}
