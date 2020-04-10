package com.capgemini.assignment.TrainingEnrollment.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.capgemini.assignment.TrainingEnrollment.model.Training;

public interface DatabaseConnection {
	
	public HashMap<Integer,Training> getALlTrainingDetails();
	public int updateTrainingSeat(int TrainingId,int availableSeat);
}
