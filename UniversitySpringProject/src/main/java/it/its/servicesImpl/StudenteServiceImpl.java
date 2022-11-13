package it.its.servicesImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import it.its.StudenteNotFoundException;
import it.its.DTO.StudenteDTO;
import it.its.domain.Corso;
import it.its.domain.Studente;
import it.its.domain.StudenteCorso;
import it.its.domain.TokenValidazioneUtente;
import it.its.event.RegistrationCompleteEvent;
import it.its.repository.CorsoRepositories;
import it.its.repository.StudenteCorsoRepositories;
import it.its.repository.StudenteRepositories;
import it.its.repository.StudenteTokenRepository;
import it.its.services.StudenteService;
import it.its.utils.Conversion;

@Service
public class StudenteServiceImpl implements StudenteService {

	@Autowired
	StudenteRepositories studRepo;

	@Autowired
	CorsoRepositories corsoRepo;

	@Autowired
	StudenteCorsoRepositories studCorsoRepo;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	StudenteTokenRepository studTokenRepo;

	@Autowired
	ApplicationEventPublisher publisher;

	@Override
	@Transactional(rollbackOn = StudenteNotFoundException.class)
	public Studente save(StudenteDTO studenteDTO, int identify, HttpServletRequest request) {
		Studente studente = Conversion.fromStudenteDTOToStudente(studenteDTO);
		studente.setPassword(passwordEncoder.encode(studenteDTO.getPassword()));
		if (identify != 0) {
			studente.setId(identify);
		}
		Studente studenteSaved = studRepo.save(studente);
		publisher.publishEvent(new RegistrationCompleteEvent(studente, scompone(request)));
		for (Integer id : studenteDTO.getCorsiId()) {
			StudenteCorso sc = new StudenteCorso();
			Corso corso = corsoRepo.getReferenceById(id);
			sc.setCorso(corso);
			sc.setStudente(studenteSaved);
			studCorsoRepo.save(sc);
		}
		return studenteSaved;
	}

	
	
	public String scompone(HttpServletRequest request) {
		return "http://" + request.getServerName() + ":" + request.getServerPort() + "/";
	}

	
	
	@Transactional(rollbackOn = StudenteNotFoundException.class)
	public StudenteDTO getById(int id) {
		Studente studente = studRepo.getReferenceById(id);
		return Conversion.fromStudenteToStudenteDTO(studente);
	}

	
	
	@Transactional(rollbackOn = StudenteNotFoundException.class)
	public List<StudenteDTO> getAll() {
		List<Studente> stud = studRepo.findAll();
		List<StudenteDTO> studDTO = new ArrayList<StudenteDTO>();
		for (Studente st : stud) {
			studDTO.add(Conversion.fromStudenteToStudenteDTO(st));

		}
		return studDTO;
	}

	
	
	@Transactional(rollbackOn = StudenteNotFoundException.class)
	public List<StudenteDTO> findByNomeAndCognome(String nome, String cognome) {
		return Conversion.fromStudenteListtoStudenteDTOList(studRepo.findByNomeAndCognome(nome, cognome));
	}

	@Override
	@Transactional(rollbackOn = { StudenteNotFoundException.class, Exception.class })
	public String deleteById(int id) {
		studTokenRepo.delete(studTokenRepo.getByIdStudente(id));
		for (StudenteCorso sc : studCorsoRepo.getByIdStudente(id)) {
			studCorsoRepo.delete(sc);
		}
		studRepo.deleteById(id);
		return "Eliminazione studente con id " + id + " effettuata";
	}

	
	
	@Override
	@Transactional(rollbackOn = StudenteNotFoundException.class)
	public void update(int id, StudenteDTO studenteDTO) {
		Studente studente = studRepo.getReferenceById(id);
		studente = Conversion.fromStudenteDTOToStudente(studenteDTO);
		studente.setPassword(passwordEncoder.encode(studenteDTO.getPassword()));
		studRepo.updateStudente(studente.getNome(), studente.getCognome(), studente.getDataNascita(), studente.getEmail(), studente.getPassword(), studente.getSesso(), id);
	}

	
	
	@Override
	public List<StudenteDTO> findByIdMaterie(List<Integer> idMaterie) {
		List<StudenteDTO> listStudDto = this.getAll();
		List<StudenteDTO> listFinal = new ArrayList<StudenteDTO>();
		for (StudenteDTO std : listStudDto) {
			Collections.sort(std.getCorsiId());
			Collections.sort(idMaterie);
			if (std.getCorsiId().equals(idMaterie))
				listFinal.add(std);
		}
		return listFinal;
	}

	
	
	@Override
	public void saveVerificationToken(Studente studente, String token) {
		TokenValidazioneUtente tokenValid = new TokenValidazioneUtente(token, studente);
		studTokenRepo.save(tokenValid);
	}

	
}
