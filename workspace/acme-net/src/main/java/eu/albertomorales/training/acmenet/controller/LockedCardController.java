package eu.albertomorales.training.acmenet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import eu.albertomorales.training.acmenet.persistence.impl.LockedCardImpl;
import eu.albertomorales.training.acmenet.dto.LockedCardDTO;
import eu.albertomorales.training.acmenet.persistence.LockedCard;
import eu.albertomorales.training.acmenet.persistence.LockedCardRepository;

@Controller
public class LockedCardController {
	
	@RequestMapping(value="/locked_cards", method = RequestMethod.GET)
    @ResponseBody
    public List<LockedCard> getByPAN(@RequestParam(name="pan") String pan) {
		Iterable<LockedCardImpl> lockedCards = repository.findByPAN(pan);
    	List<LockedCard> result = new ArrayList<LockedCard>();
    	lockedCards.forEach(result::add);
    	return result;		
    }	
	
	@RequestMapping(value="/locked_cards", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> save(@RequestBody LockedCardDTO dto) {
    	LockedCardImpl entity = new LockedCardImpl(null, 
    			                                   dto.getPan(),
    			                                   dto.getReason(),
    			                                   dto.getComment());
		entity = repository.save(entity);
        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(entity.getId())
                                    .toUri();
         
        
        //Send location in response
        return ResponseEntity.created(location).build();
    }	
	
	@RequestMapping(value="/locked_cards/{id}", method = RequestMethod.GET)
    @ResponseBody
    public LockedCard getById(@PathVariable Long id) {
    	Optional<LockedCardImpl> optCard = repository.findById(id);
    	if (optCard.isPresent()) {
    		return (LockedCard)optCard.get();
    	} else {
    		throw new ResponseStatusException(
  				  HttpStatus.NOT_FOUND, "Locked card not found."
  				);
    	}
    }			
    
	@Autowired
	private LockedCardRepository repository;	

}
