package it.its.Iservice;

import java.util.List;



import it.its.DTO.ProduttoreDTO;
import it.its.exception.ProduttoreNotFoundException;


public interface IServiceProduttore {

	public ProduttoreDTO save(ProduttoreDTO produttoreDTO);
	public List<ProduttoreDTO> getAll();
	public ProduttoreDTO getById (int id) throws ProduttoreNotFoundException;
}
