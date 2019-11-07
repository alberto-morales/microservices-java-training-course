package eu.albertomorales.training.acmenet.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eu.albertomorales.training.acmenet.persistence.impl.LockedCardImpl;

import java.util.List;

public interface LockedCardRepository extends CrudRepository<LockedCardImpl, Long> {

	@Query("SELECT c FROM LockedCardImpl c WHERE c.pan = :pan")
    List<LockedCardImpl> findByPAN(@Param("pan") String pan);
    
}
