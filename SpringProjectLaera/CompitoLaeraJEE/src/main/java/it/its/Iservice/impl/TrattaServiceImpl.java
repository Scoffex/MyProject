package it.its.Iservice.impl;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.DTO.TrattaDTO;
import it.its.Iservice.ITrattaService;
import it.its.domain.AereoTratta;
import it.its.domain.Tratta;
import it.its.repository.AereoRepository;
import it.its.repository.AereoTrattaRepository;
import it.its.repository.TrattaRepository;
import it.its.utils.Conversion;


@Service
public class TrattaServiceImpl implements ITrattaService{
	@Autowired
	TrattaRepository trattaRepository;
	@Autowired
	AereoRepository aereoRepository;
	@Autowired
	AereoTrattaRepository aereoTrattaRepository;
	
	String giorno = "Lunedi";
	@Transactional(rollbackOn = EntityNotFoundException.class)
	@Override
	public TrattaDTO save(TrattaDTO trattaDTO) {
		Tratta tratta = trattaRepository.save(Conversion.formTrattaToTrattaDTO(trattaDTO));
		trattaDTO.setId(trattaRepository.save(tratta).getId());
		for (Integer idAereo : trattaDTO.getIdAereo()) {
			AereoTratta aereoTratta = new AereoTratta();
			aereoTratta.setAereo(aereoRepository.findById(idAereo).orElseThrow(() -> new EntityNotFoundException("Aereo/i non trovato/i")));
			aereoTratta.setTratta(tratta);
			aereoTrattaRepository.save(aereoTratta);
			aereoTratta.setGiornoDellaSettimana(giorno);
		}
		return trattaDTO;
	}
	
	

}
