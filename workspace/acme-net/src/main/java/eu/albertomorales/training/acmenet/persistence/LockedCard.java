package eu.albertomorales.training.acmenet.persistence;

public interface LockedCard {

	Long getId();

	String getPAN();
	
	String getReason();
	
	String getComment();
	
}