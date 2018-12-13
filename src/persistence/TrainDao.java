package persistence;

import domain.Train;

public interface TrainDao {
	public boolean createTrain(Train train);
	public boolean deleteTrain(String name);
	public int getSeatsTrain(String trainName);
}
