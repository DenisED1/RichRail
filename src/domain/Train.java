package domain;

import java.util.List;

public class Train {
	private String name;
	private List<Component> components;
	
	public Train(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Component> getComponents() {
		return components;
	}
	
	public void addComponent(Component component) {
		components.add(component);
	}
	
	public void deleteComponent(Component component) {
		components.remove(component);
	}
}
