package it.its.projectWork.services.interfaces;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import it.its.projectWork.DTO.FunctionalityDTO;
import it.its.projectWork.DTO.PanDTO;

public interface IFunctionalityService {
	
	public FunctionalityDTO findById(int id) throws NotFoundException;
	
	public FunctionalityDTO save(FunctionalityDTO dto) throws NotFoundException;
	
	public List<FunctionalityDTO> findAll(int pageNumber, int pageSize);
	
	public void delete(int id) throws NotFoundException;
	
	public List<FunctionalityDTO> findByPanAtmBank(PanDTO dto);
	
	public void update(FunctionalityDTO dto) throws NotFoundException;

}
