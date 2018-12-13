package domain;

public class Locomotive {
	private String name;
	private String type;
	
	public Locomotive(String name) {
		this.name = name;
		this.type = "Locomotive";
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getType() {
		return this.type;
	}
}
