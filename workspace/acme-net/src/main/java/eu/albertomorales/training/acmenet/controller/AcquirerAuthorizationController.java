package eu.albertomorales.training.acmenet.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import eu.albertomorales.training.acmenet.dto.AcquirerAuthorizationRequest;
import eu.albertomorales.training.acmenet.dto.AcquirerAuthorizationResponse;
import eu.albertomorales.training.acmenet.dto.IssuerAuthorizationRequest;
import eu.albertomorales.training.acmenet.dto.IssuerAuthorizationResponse;
import eu.albertomorales.training.acmenet.restclient.IssuerAuthorizationRestClient;

// @Controller
public class AcquirerAuthorizationController {

	public AcquirerAuthorizationController(IssuerAuthorizationRestClient issuerAuthorizationRestClient) {
		super();
		this.issuerAuthorizationRestClient = issuerAuthorizationRestClient;
	}

//	@RequestMapping(value="/authorization", consumes = "application/json", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public AcquirerAuthorizationResponse save(@RequestBody AcquirerAuthorizationRequest dto) {
		IssuerAuthorizationResponse issuerResponse = 
						issuerAuthorizationRestClient.save(
								new IssuerAuthorizationRequest(
										dto.getPan(), 
										dto.getAmmount()
								)
						);
	    LocalDateTime dateTime = LocalDateTime.now();
	    /*
	    String status = "APPROVED"; // REJECTED
	    */
	    String status = issuerResponse.getStatus();
		return new AcquirerAuthorizationResponse(dto.getPan(), 
												dto.getAmmount(),
												dateTime, 
												status,
												dto.getCountry());
    }	
	
	private IssuerAuthorizationRestClient issuerAuthorizationRestClient;
	
}
