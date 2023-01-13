package it.its.projectWork.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.projectWork.repositories.BankCodeRepository;
import it.its.projectWork.services.interfaces.IBankService;

@Service
public class BankServiceImpl implements IBankService{
	
	@Autowired
	BankCodeRepository bankCodeRepo;
	
	@Override
	public List<String> findAllCodes() {
		return bankCodeRepo.findAll().stream().map(x-> x.getBank()).collect(Collectors.toList());
	}

}
