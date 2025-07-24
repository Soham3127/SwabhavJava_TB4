package coom.aurionpro.ennumeration;

public enum PaymentStatus {
	SUCCESS ("Payment Received"),
	PENDING ("Payment Remaning"),
	FAILED ("Payment Failed"),
	CANCELLED ("Payment Cancelled"),
	
	private String status;
	
	PaymentStatus(String status) {
		this.status=status;
		
	}
	
	public String getStatus() {
		return status;
	}
	

}
