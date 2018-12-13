package domain;

public class Wagon implements Component {
	private String name;
	private String type;
	private int seats;
	
	public Wagon(String name) {
		this.name = name;
		this.type = "Wagon";
		this.seats = 20;
	}
	
	public Wagon(String name, int seats) {
		this.name = name;
		this.type = "Wagon";
		this.seats = seats;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getType() {
		return this.type;
	}
	
	public int getSeats() {
		return this.seats;
	}
}
