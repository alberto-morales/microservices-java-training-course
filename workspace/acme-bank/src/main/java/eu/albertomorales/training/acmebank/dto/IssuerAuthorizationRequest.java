package eu.albertomorales.training.acmebank.dto;

public class IssuerAuthorizationRequest {
	
	public IssuerAuthorizationRequest() {
		// TODO Auto-generated constructor stub
	}
	
	public IssuerAuthorizationRequest(String pan, Double ammount) {
		super();
		this.pan = pan;
		this.ammount = ammount;
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
	
	private String pan;
	private Double ammount;

}
