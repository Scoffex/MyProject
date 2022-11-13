package it.its.Iservice.impl;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.DTO.AereoTrattaDTO;
import it.its.Iservice.IServiceTrattaAereo;
import it.its.domain.Aereo;
import it.its.domain.AereoTratta;
import it.its.domain.Tratta;
import it.its.exception.AereoNotFoundException;
import it.its.repository.AereoRepository;
import it.its.repository.AereoTrattaRepository;
import it.its.repository.TrattaRepository;
@Service
public class AereoTrattaImpl implements IServiceTrattaAereo{

	@Autowired
	AereoRepository aereoRepository;
	@Autowired
	TrattaRepository trattaRepository;
	@Autowired
	AereoTrattaRepository aereoTrattaRepository;
	
	@Transactional
	@Override
	public AereoTrattaDTO save(AereoTrattaDTO aereoTrattaDTO) throws AereoNotFoundException, EntityNotFoundException{
		Tratta tratta = null;
		if(aereoTrattaDTO.getIdTratta() != 0) {
			tratta = trattaRepository.findById(aereoTrattaDTO.getIdTratta()).orElseThrow(() -> new EntityNotFoundException("tratta non presente"));
		}
		Aereo aereo = aereoRepository.findById(aereoTrattaDTO.getIdAereo()).orElseThrow(() -> new AereoNotFoundException());
		if (tratta == null) {
			tratta = new Tratta();
			tratta.setAereoportoPartenza(aereoTrattaDTO.getAereoportoPartenza());
			tratta.setAereoportoArrivo(aereoTrattaDTO.getAereoportoArrivo());
			tratta.setKmPercorsi(aereoTrattaDTO.getKmPercorsi());
			tratta.setId(trattaRepository.save(tratta).getId());
			aereoTrattaDTO.setIdTratta(tratta.getId());
		}
		AereoTratta aereoTratta = new AereoTratta();
		aereoTratta.setAereo(aereo);
		aereoTratta.setTratta(tratta);
		aereoTratta.setGiornoDellaSettimana(aereoTrattaDTO.getGiornoDellaSettimana());
		aereoTrattaRepository.save(aereoTratta);
		return aereoTrattaDTO;
	}

}
