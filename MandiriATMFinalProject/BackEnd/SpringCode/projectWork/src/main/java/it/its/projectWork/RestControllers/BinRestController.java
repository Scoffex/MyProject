package it.its.projectWork.RestControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.its.projectWork.services.interfaces.IBinService;

@RestController
@RequestMapping("/api/banking/bin")
public class BinRestController {
	
	@Autowired
	IBinService binService;
	
	@RequestMapping(value = "/findAllBinValues",method = RequestMethod.GET)
	public List<String> findAllBinValues(){
		return binService.findAllBinValues();
	}
}
