package eu.albertomorales.training.acmenet.dto;

import java.time.LocalDate;

public class LockedCardDTO {

	public LockedCardDTO() {
		// TODO Auto-generated constructor stub
	}

    public LockedCardDTO(String pan, String reason, String comment) {
		super();
		this.pan = pan;
		this.reason = reason;
		this.comment = comment;
	}

	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
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
	public LocalDate getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDate dateTime) {
		this.dateTime = dateTime;
	}	
	
	private String pan;
    private String reason;
    private String comment;
    private LocalDate dateTime = LocalDate.now();
    
}
