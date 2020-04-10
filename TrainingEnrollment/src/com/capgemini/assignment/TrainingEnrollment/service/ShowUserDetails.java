package com.capgemini.assignment.TrainingEnrollment.service;

import java.util.HashMap;

import com.capgemini.assignment.TrainingEnrollment.dao.DatabaseConnection;
import com.capgemini.assignment.TrainingEnrollment.dao.DatabaseConnectionImp;
import com.capgemini.assignment.TrainingEnrollment.model.Training;

public class ShowUserDetails {
	DatabaseConnection db= new DatabaseConnectionImp();
	public HashMap<Integer,Training> getAllTraining(){
		return db.getALlTrainingDetails();
	}
}
