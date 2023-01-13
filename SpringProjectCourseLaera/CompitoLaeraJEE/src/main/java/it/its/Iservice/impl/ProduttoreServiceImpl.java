package it.its.Iservice.impl;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.its.DTO.ProduttoreDTO;
import it.its.Iservice.IServiceProduttore;
import it.its.domain.Produttore;

import it.its.exception.ProduttoreNotFoundException;
import it.its.repository.AereoRepository;
import it.its.repository.ProduttoreRepository;
import it.its.utils.Conversion;

@Service
public class ProduttoreServiceImpl implements IServiceProduttore{
	@Autowired
	ProduttoreRepository produttoreRepository;
	@Autowired
	AereoRepository aereoRepository;
	
	@Transactional
	@Override
	public ProduttoreDTO save(ProduttoreDTO produttoreDTO) {
		Produttore produttore = produttoreRepository.save(Conversion.fromProduttoreToProduttoreDTO(produttoreDTO));
		Produttore produttoreSaved = produttoreRepository.save(produttore);
		produttoreDTO.setId(produttoreSaved.getId());
		return produttoreDTO;
	}
	@Transactional
	@Override
	public List<ProduttoreDTO> getAll() {
		// TODO Auto-generated method stub
		List<Produttore> list = produttoreRepository.findAll();
		List<ProduttoreDTO> dtoList = new ArrayList<>();
		for (Produttore produttore : list) {
			ProduttoreDTO produttoreDTO = Conversion.fromProduttoreDTOtoProduttore(produttore);
			dtoList.add(produttoreDTO);
		}
		return dtoList;
	}
	
	@Transactional(rollbackOn = ProduttoreNotFoundException.class)
	@Override
	public ProduttoreDTO getById(int id) throws ProduttoreNotFoundException {
		Produttore produttore = produttoreRepository.findById(id).orElseThrow(()->new ProduttoreNotFoundException());
		ProduttoreDTO produttoreDTO = Conversion.fromProduttoreDTOtoProduttore(produttore);
		return produttoreDTO;
	
	}

}
