package it.its.projectWork.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import it.its.projectWork.DTO.FunctionalityDTO;
import it.its.projectWork.domain.Functionality;

public class Conversions {
	
	public static FunctionalityDTO functionalityDomainToDTO(Functionality func) {
		
		FunctionalityDTO dto = new FunctionalityDTO();
		
		dto.setId(func.getId());
		dto.setName(func.getName());
		dto.setDescription(func.getDescription());
		dto.setEnabled(func.isEnabled());
		dto.setType(func.getType());
		dto.setMultisession(func.isMultisession());
		dto.setPeripherals(func.getPeripherals().stream().map(x -> x.getPeripheral().getId()).collect(Collectors.toList()));
		dto.setBankCodes(func.getBankCodes().stream().map(x -> x.getBankCode().getId()).collect(Collectors.toList()));
		dto.setBins(func.getBins().stream().map(x -> x.getBin().getId()).collect(Collectors.toList()));
		
		return dto;
	}
	
	
	public static Functionality functionalityDTOToDomain(FunctionalityDTO dto) {
		Functionality func = new Functionality();
		
		func.setName(dto.getName());
		func.setDescription(dto.getDescription());
		func.setEnabled(dto.isEnabled());
		func.setType(dto.getType());
		func.setMultisession(dto.isMultisession());
		
		return func;
	}
	
	
	public static List<FunctionalityDTO> functionalityDomainToDTOList(List<Functionality> list){
		
		List<FunctionalityDTO> convertedList = new ArrayList<FunctionalityDTO>();
		
		for(Functionality func : list) {
			convertedList.add(functionalityDomainToDTO(func));
		}
		
		return convertedList;
	}
}
