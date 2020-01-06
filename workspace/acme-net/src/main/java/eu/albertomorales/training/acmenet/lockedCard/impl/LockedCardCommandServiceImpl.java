package eu.albertomorales.training.acmenet.lockedCard.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.albertomorales.training.acmenet.dto.LockedCardDTO;
import eu.albertomorales.training.acmenet.lockedCard.LockedCardCommandService;
import eu.albertomorales.training.acmenet.lockedCard.LockedCardProducer;
import eu.albertomorales.training.acmenet.lockedCard.dto.LockedCardImpl;

@Service
public class LockedCardCommandServiceImpl implements LockedCardCommandService {

	@Override
	public void register(LockedCardDTO command) {
		producer.send(command.getPan(), dtoToEntity(command));
	}
	
    private LockedCardImpl dtoToEntity(LockedCardDTO dto){
    	LockedCardImpl entity = new LockedCardImpl(null, 
    			dto.getPan(), 
    			dto.getReason(), 
    			dto.getComment());
        return entity;
    }
    
	@Autowired
	private LockedCardProducer producer;

}
