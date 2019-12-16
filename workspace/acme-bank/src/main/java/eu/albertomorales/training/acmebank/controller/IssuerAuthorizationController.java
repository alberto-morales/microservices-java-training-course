package eu.albertomorales.training.acmebank.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import eu.albertomorales.training.acmebank.dto.IssuerAuthorizationRequest;
import eu.albertomorales.training.acmebank.dto.IssuerAuthorizationResponse;

// @Controller
public class IssuerAuthorizationController {

//  	@RequestMapping(value="/authorization", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public IssuerAuthorizationResponse save(@RequestBody IssuerAuthorizationRequest dto) {
	    LocalDateTime dateTime = LocalDateTime.now();
	    // Everybody is rich :-o
	    String status = "APPROVED"; // or REJECTED
		return new IssuerAuthorizationResponse(dto.getPan(), 
						   					   dto.getAmmount(),
											   dateTime, 
											   status);
    }	
	
}
