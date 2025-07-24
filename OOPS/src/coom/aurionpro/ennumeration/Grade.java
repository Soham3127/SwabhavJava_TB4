package coom.aurionpro.ennumeration;

public enum Grade {
	A("Excellent"),
	B("Good"),
	C("Average"),
	D(" Below Average"),
	F("Fail");
	
	private String description ;
	
	Grade (String description){
		this.description = description;		
	}
	 public String getDescription () {
		 return description;
	 }
}
