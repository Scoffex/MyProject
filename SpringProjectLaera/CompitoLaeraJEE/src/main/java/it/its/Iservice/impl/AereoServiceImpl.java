package it.its.Iservice.impl;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.DTO.AereoDTO;
import it.its.Iservice.IServiceAereo;
import it.its.domain.Produttore;
import it.its.exception.AereoNotFoundException;
import it.its.domain.Aereo;

import it.its.repository.AereoRepository;
import it.its.repository.ProduttoreRepository;
import it.its.utils.Conversion;

@Service
public class AereoServiceImpl implements IServiceAereo{

	@Autowired
	AereoRepository aereoRepository;
	@Autowired
	ProduttoreRepository produttoreRepository;
	
	@Transactional(rollbackOn = EntityNotFoundException.class)
	@Override
	public AereoDTO save(AereoDTO aereoDTO) {
		Aereo aereo = aereoRepository.save(Conversion.fromAereoToAereoDTO(aereoDTO));
		Produttore produttore = produttoreRepository.findById(aereoDTO.getIdProduttore()).orElseThrow(()->new EntityNotFoundException());
		aereo.setProduttore(produttore);
		aereoDTO.setId(aereoRepository.save(aereo).getId());
		return aereoDTO;
	}
	
	@Transactional
	@Override
	public List<AereoDTO> getByNome(String nome) {
		// TODO Auto-generated method stub
		return Conversion.aereoDTOListFromAereoList(aereoRepository.getByName(nome));
	}

	@Transactional
	@Override
	public List<AereoDTO> getByAnnoDiProduzione(int data) {
		// TODO Auto-generated method stub
		return Conversion.aereoDTOListFromAereoList(aereoRepository.findByannoDiProduzione(data));
	}
	@Transactional
	@Override
	public List<AereoDTO> getAereoByIdProduttore(int id) {
		// TODO Auto-generated method stub
		return Conversion.aereoDTOListFromAereoList(aereoRepository.getAereoByIdProduttore(id));
	}
	@Transactional(rollbackOn = AereoNotFoundException.class)
	@Override
	public void delete(int id) throws AereoNotFoundException {
		Aereo aereo = aereoRepository.findById(id).orElseThrow(()-> new AereoNotFoundException());
		aereoRepository.delete(aereo);
		
	}

}
