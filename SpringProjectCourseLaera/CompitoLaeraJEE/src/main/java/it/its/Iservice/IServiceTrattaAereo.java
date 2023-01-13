package it.its.Iservice;

import javax.persistence.EntityNotFoundException;

import it.its.DTO.AereoTrattaDTO;
import it.its.exception.AereoNotFoundException;

public interface IServiceTrattaAereo {
	 public AereoTrattaDTO save (AereoTrattaDTO aereoTrattaDTO) throws AereoNotFoundException, EntityNotFoundException;
		 
	 

}
