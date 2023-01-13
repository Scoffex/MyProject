package it.its.projectWork.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.projectWork.repositories.BinRepository;
import it.its.projectWork.services.interfaces.IBinService;

@Service
public class BinServiceImpl implements IBinService{
	
	@Autowired
	BinRepository binRepo;
	
	@Override
	public List<String> findAllBinValues() {
		return binRepo.findAllBinValues();
	}

}
