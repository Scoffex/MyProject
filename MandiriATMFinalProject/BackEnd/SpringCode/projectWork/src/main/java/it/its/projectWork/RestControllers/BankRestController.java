package it.its.projectWork.RestControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.its.projectWork.services.interfaces.IBankService;

@RestController
@RequestMapping("/api/banking/bankCodes")
public class BankRestController {
	
	@Autowired
	IBankService bankService;
	
	@RequestMapping(value = "/findAllCodes", method = RequestMethod.GET)
	public ResponseEntity<List<String>> findAllCodes(){
		return new ResponseEntity<List<String>>(bankService.findAllCodes(), HttpStatus.OK);
	}
	
}
