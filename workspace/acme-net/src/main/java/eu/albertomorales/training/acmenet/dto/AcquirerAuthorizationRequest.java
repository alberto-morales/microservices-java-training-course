package eu.albertomorales.training.acmenet.dto;

public class AcquirerAuthorizationRequest {
	
	public AcquirerAuthorizationRequest() {
		// TODO Auto-generated constructor stub
	}
	
	public AcquirerAuthorizationRequest(String pan, Double ammount, String country) {
		super();
		this.pan = pan;
		this.ammount = ammount;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}	
	
	private String pan;
	private Double ammount;
	private String country;

}
