package eu.albertomorales.training.acmenet.persistence.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import eu.albertomorales.training.acmenet.persistence.LockedCard;

@Entity
@Table(name = "locked_cards")
public class LockedCardImpl implements LockedCard {

    public LockedCardImpl() {
    }
    
    public LockedCardImpl(Long id, String pan, String reason, String comment) {
		super();
		this.id = id;
		this.pan = pan;
		this.reason = reason;
		this.comment = comment;
	}

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPAN() {
		return pan;
	}

	public void setPAN(String pan) {
		this.pan = pan;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@Column(name = "pan")    
    private String pan;
    @Column(name = "reason")    
    private String reason;
    @Column(name = "comment")    
    private String comment;

}
