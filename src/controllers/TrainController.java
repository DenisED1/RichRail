package controllers;

import domain.Train;
import persistence.TrainDao;
import persistence.TrainOracleDaoImpl;

public class TrainController {
	TrainDao tdao = new TrainOracleDaoImpl();

	public Train createTrain(String name) {
		Train train = new Train(name);
		if (tdao.createTrain(train)) {
			return train;
		} else {
			return null;
		}
	}

	public boolean deleteTrain(String name) {
		return tdao.deleteTrain(name);
	}

	public int getSeatsTrain(String name) {
		return tdao.getSeatsTrain(name);
	}
}
