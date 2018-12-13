package controllers;

import domain.Locomotive;
import domain.Wagon;
import persistence.ComponentDao;
import persistence.ComponentOracleDaoImpl;

public class ComponentController {
	ComponentDao cdao = new ComponentOracleDaoImpl();
	
	public Locomotive createLocomotive(String name) {
		Locomotive locomotive = new Locomotive(name);
		if (cdao.createLocomotive(locomotive)) {
			return locomotive;
		} else {
			return null;
		}
	}
	
	public Wagon createWagon(String name, int seats) {
		Wagon wagon = new Wagon(name, seats);
		if (cdao.createWagon(wagon)) {
			return wagon;
		} else {
			return null;
		}
	}
	
	public boolean addComponent(String trainName, String componentName) {
		return cdao.addComponent(trainName, componentName);
	}
	
	public boolean removeComponent(String trainName, String componentName) {
		//place remove counter fixen
		return cdao.removeComponent(trainName, componentName);
	}
	
	public boolean deleteComponent(String componentName) {
		return cdao.deleteComponent(componentName);
	}
	
	public int getSeatsComponent(String name) {
		return cdao.getSeatsComponent(name);
	}
}
