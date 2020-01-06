
package eu.albertomorales.training.acmenet.lockedCard;

import eu.albertomorales.training.acmenet.dto.LockedCardDTO;

public interface LockedCardCommandService {

	void register(LockedCardDTO command);
	
}
