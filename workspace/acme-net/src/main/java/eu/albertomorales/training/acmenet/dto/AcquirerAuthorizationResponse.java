package eu.albertomorales.training.acmenet.dto;

import java.time.LocalDateTime;

public class AcquirerAuthorizationResponse {
	
	public AcquirerAuthorizationResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public AcquirerAuthorizationResponse(String pan, Double ammount, LocalDateTime dateTime, String status, String country) {
		super();
		this.pan = pan;
		this.ammount = ammount;
		this.dateTime = dateTime;
		this.status = status;
		this.country = country;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	private String pan;
	private Double ammount;
	private LocalDateTime dateTime;
	private String status;
	private String country;

}
