package eu.albertomorales.training.acmenet.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import eu.albertomorales.training.acmenet.dto.IssuerAuthorizationRequest;
import eu.albertomorales.training.acmenet.dto.IssuerAuthorizationResponse;

@FeignClient("acme-bank-services")
public interface IssuerAuthorizationRestClient {

	@RequestMapping(value="/authorization", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public abstract IssuerAuthorizationResponse save(@RequestBody IssuerAuthorizationRequest dto);

}
