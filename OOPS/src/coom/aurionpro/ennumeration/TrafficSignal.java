package coom.aurionpro.ennumeration;

enum TrafficSignal {
	RED("Stop"), YELLOW("Get Ready"), GREEN("Go");

	private String action;

	TrafficSignal(String action) {
		this.action = action;
	}

	public String getAction() {
		return action;
	}

}
