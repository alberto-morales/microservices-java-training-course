package eu.albertomorales.training.acmenet.lockedCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import eu.albertomorales.training.acmenet.dto.LockedCardDTO;

@Controller
public class LockedCardCommandController {
	
	@RequestMapping(value="/locked_cards", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void register(@RequestBody LockedCardDTO dto) {
		service.register(dto);
    }	

	@Autowired
	private LockedCardCommandService service;
}
