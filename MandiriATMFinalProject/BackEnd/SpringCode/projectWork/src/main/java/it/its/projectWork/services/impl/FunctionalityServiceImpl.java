package it.its.projectWork.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import it.its.projectWork.DTO.FunctionalityDTO;
import it.its.projectWork.DTO.PanDTO;
import it.its.projectWork.Util.Conversions;
import it.its.projectWork.domain.FuncBankCode;
import it.its.projectWork.domain.FuncBin;
import it.its.projectWork.domain.FuncPeripheral;
import it.its.projectWork.domain.Functionality;
import it.its.projectWork.repositories.BankCodeRepository;
import it.its.projectWork.repositories.BinRepository;
import it.its.projectWork.repositories.FuncBankCodeRepository;
import it.its.projectWork.repositories.FuncBinRepository;
import it.its.projectWork.repositories.FuncPeripheralRepository;
import it.its.projectWork.repositories.FunctionalityRepository;
import it.its.projectWork.repositories.PeripheralRepository;
import it.its.projectWork.services.interfaces.IFunctionalityService;

@Service
public class FunctionalityServiceImpl implements IFunctionalityService {

	@Autowired
	FunctionalityRepository funcRepo;

	@Autowired
	FuncPeripheralRepository funcPeripheralRepo;

	@Autowired
	FuncBankCodeRepository funcBankCodeRepo;

	@Autowired
	FuncBinRepository funcBinRepo;

	@Autowired
	PeripheralRepository peripheralRepo;

	@Autowired
	BankCodeRepository bankCodeRepo;

	@Autowired
	BinRepository binRepo;

	@Override
	public List<FunctionalityDTO> findAll(int pageNumber, int pageSize) {
		return Conversions
				.functionalityDomainToDTOList(funcRepo.findAll(PageRequest.of(pageNumber, pageSize)).getContent());
	}

	@Override
	@Transactional(rollbackOn = NotFoundException.class)
	public FunctionalityDTO save(FunctionalityDTO dto) throws NotFoundException {

		Functionality func = Conversions.functionalityDTOToDomain(dto);

		func.setPeripherals(new ArrayList<FuncPeripheral>());
		func.setBankCodes(new ArrayList<FuncBankCode>());
		func.setBins(new ArrayList<FuncBin>());

		func = funcRepo.save(func);
		dto.setId(func.getId());

		for (int i : dto.getPeripherals()) {
			FuncPeripheral funcPer = new FuncPeripheral();

			funcPer.setFunctionality(func);

			funcPer.setPeripheral(peripheralRepo.findById(i).orElseThrow(() -> new NotFoundException()));

			funcPer = funcPeripheralRepo.save(funcPer);

			func.getPeripherals()
					.add(funcPeripheralRepo.findById(funcPer.getId()).orElseThrow(() -> new NotFoundException()));

			funcPer = null;
		}

		for (int i : dto.getBankCodes()) {

			FuncBankCode funcBank = new FuncBankCode();

			funcBank.setFunctionality(func);

			funcBank.setBankCode(bankCodeRepo.findById(i).orElseThrow(() -> new NotFoundException()));

			funcBank = funcBankCodeRepo.save(funcBank);

			func.getBankCodes()
					.add(funcBankCodeRepo.findById(funcBank.getId()).orElseThrow(() -> new NotFoundException()));

			funcBank = null;
		}

		for (int i : dto.getBins()) {

			FuncBin funcBin = new FuncBin();

			funcBin.setFunctionality(func);

			funcBin.setBin(binRepo.findById(i).orElseThrow(() -> new NotFoundException()));

			funcBin = funcBinRepo.save(funcBin);

			func.getBins().add(funcBinRepo.findById(funcBin.getId()).orElseThrow(() -> new NotFoundException()));
		}

		func = null;

		return dto;
	}

	@Override
	@Transactional(rollbackOn = NotFoundException.class)
	public FunctionalityDTO findById(int id) throws NotFoundException {

		return Conversions.functionalityDomainToDTO(funcRepo.findById(id).orElseThrow(() -> new NotFoundException()));
	}

	@Override
	@Transactional(rollbackOn = NotFoundException.class)
	public void delete(int id) throws NotFoundException {

		Functionality func = funcRepo.findById(id).orElseThrow(() -> new NotFoundException());

		if (!func.getBankCodes().isEmpty()) {
			for (FuncBankCode funcBankCode : func.getBankCodes()) {
				funcBankCodeRepo.delete(funcBankCode);
			}
		}

		if (!func.getBins().isEmpty()) {
			for (FuncBin funcBin : func.getBins()) {
				funcBinRepo.delete(funcBin);
			}
		}

		if (!func.getPeripherals().isEmpty()) {
			for (FuncPeripheral funcPer : func.getPeripherals()) {
				funcPeripheralRepo.delete(funcPer);
			}
		}

		funcRepo.delete(func);
		func = null;
	}

	@Override
	public List<FunctionalityDTO> findByPanAtmBank(PanDTO dto) {

		List<Functionality> functionalities = funcRepo.findByPanAtmBank(
				binRepo.findByBinValueLike(dto.getPan().substring(0, 2)).get(0).getId(),
				bankCodeRepo.findByBank(dto.getBankCode()).get(0).getId());

		List<FunctionalityDTO> list = Conversions.functionalityDomainToDTOList(functionalities);

		List<FunctionalityDTO> resultList = new ArrayList<FunctionalityDTO>();

		for (FunctionalityDTO funcDto : list) {

			if (dto.getPeripherals().containsAll(funcDto.getPeripherals())) {
				resultList.add(funcDto);
			}
		}

		functionalities = null;
		list = null;

		return resultList;
	}

	@Override
	@Transactional(rollbackOn = NotFoundException.class)
	public void update(FunctionalityDTO dto) throws NotFoundException {
		if (dto.getId() != 0) {
			Functionality func = Conversions.functionalityDTOToDomain(dto);
			func.setId(dto.getId());
			funcRepo.save(func);
		} else {
			throw new NotFoundException();
		}
	}

}
