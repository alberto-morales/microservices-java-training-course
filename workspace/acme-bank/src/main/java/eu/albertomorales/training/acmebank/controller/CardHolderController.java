package eu.albertomorales.training.acmebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import eu.albertomorales.training.acmebank.persistence.CardHolder;
import eu.albertomorales.training.acmebank.persistence.impl.CardHolderImpl;
import eu.albertomorales.training.acmebank.persistence.CardHolderRepository;

@Controller
public class CardHolderController {
	
	@RequestMapping(value="/customers", method = RequestMethod.GET)
    @ResponseBody
    public List<CardHolder> getByDocument(@RequestParam(required = false, name="doctype") String typeDoc, @RequestParam(required = false, name="docnumber") String numberDoc) {
		Iterable<CardHolderImpl> customers = null;
		if (typeDoc != null || numberDoc != null) {
			customers = repository.findByDocument(typeDoc, numberDoc);
		} else {
			customers = repository.findAll();
		}
    	List<CardHolder> result = new ArrayList<CardHolder>();
    	customers.forEach(result::add);
    	return result;		
    }	
	
	@RequestMapping(value="/customers/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CardHolder getById(@PathVariable Long id) {
    	Optional<CardHolderImpl> optCustomer = repository.findById(id);
    	if (optCustomer.isPresent()) {
    		return (CardHolder)optCustomer.get();
    	} else {
    		throw new ResponseStatusException(
  				  HttpStatus.NOT_FOUND, "Card holder not found."
  				);
    	}
    }		
	
	@Autowired
	private CardHolderRepository repository;	

}
