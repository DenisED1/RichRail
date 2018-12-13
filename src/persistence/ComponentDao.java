package persistence;

import domain.Locomotive;
import domain.Wagon;

public interface ComponentDao {
	boolean createLocomotive(Locomotive locomotive);
	boolean createWagon(Wagon wagon);
	public boolean addComponent(String trainName, String componentName);
	public boolean removeComponent(String trainName, String componentName);
	boolean deleteComponent(String componentName);
	public int getSeatsComponent(String trainName);
}
