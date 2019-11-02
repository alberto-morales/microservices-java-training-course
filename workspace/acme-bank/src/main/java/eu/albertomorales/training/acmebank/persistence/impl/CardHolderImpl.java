package eu.albertomorales.training.acmebank.persistence.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import eu.albertomorales.training.acmebank.persistence.CardHolder;

@Entity
@Table(name = "card_holders")
public class CardHolderImpl implements CardHolder {

    public CardHolderImpl() {
    }

    public CardHolderImpl(String firstName, String lastName, String docType, String docNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.docType = docType;
		this.docNumber = docNumber;
	}

	@Override
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Override
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	@Override
	public String getDocNumber() {
		return docNumber;
	}
	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "firstname")    
	private String firstName;
    @Column(name = "lastname")    
    private String lastName;
    @Column(name = "doc_type")    
    private String docType;
    @Column(name = "doc_number")    
    private String docNumber;

}
