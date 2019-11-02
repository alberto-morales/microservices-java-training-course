package eu.albertomorales.training.acmebank.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eu.albertomorales.training.acmebank.persistence.impl.CardHolderImpl;

import java.util.List;

public interface CardHolderRepository extends CrudRepository<CardHolderImpl, Long> {

	@Query("SELECT c FROM CardHolderImpl c WHERE c.docType = :doc_type AND c.docNumber = :doc_number ")
    List<CardHolderImpl> findByDocument(@Param("doc_type") String docType, @Param("doc_number") String docNumber);
    
}
