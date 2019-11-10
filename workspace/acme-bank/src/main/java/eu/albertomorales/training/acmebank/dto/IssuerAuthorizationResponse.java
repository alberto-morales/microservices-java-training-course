package eu.albertomorales.training.acmebank.dto;

import java.time.LocalDateTime;

public class IssuerAuthorizationResponse {
	
	public IssuerAuthorizationResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public IssuerAuthorizationResponse(String pan, Double ammount, LocalDateTime dateTime, String status) {
		super();
		this.pan = pan;
		this.ammount = ammount;
		this.dateTime = dateTime;
		this.status = status;
	}
	
	public String getPan() {
		return pan;
	}
	
	public void setPan(String pan) {
		this.pan = pan;
	}
	public Double getAmmount() {
		return ammount;
	}
	public void setAmmount(Double ammount) {
		this.ammount = ammount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	private String pan;
	private Double ammount;
	private LocalDateTime dateTime;
	private String status;

}
