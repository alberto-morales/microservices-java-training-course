package eu.albertomorales.training.acmenet.lockedCard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.ArrayList;

@Controller
public class LockedCardQueryController {
	
	@RequestMapping(value="/locked_cards", method = RequestMethod.GET)
    @ResponseBody
    public List<LockedCard> getCardByPAN(@RequestParam(name="pan") String pan) {
		// Iterable<LockedCardImpl> lockedCards = repository.findByPAN(pan);
    	List<LockedCard> result = new ArrayList<LockedCard>();
    	// lockedCards.forEach(result::add);
    	return result;		
    }	

}
