package com.capgemini.assignment.TrainingEnrollment.service;

import com.capgemini.assignment.TrainingEnrollment.dao.DatabaseConnection;
import com.capgemini.assignment.TrainingEnrollment.dao.DatabaseConnectionImp;

public class UserDisplayService {
	DatabaseConnection db= new DatabaseConnectionImp();
	public int  updateDatabase(int trainingId,int availableSeat) {
		return db.updateTrainingSeat(trainingId,availableSeat);
	}
}
