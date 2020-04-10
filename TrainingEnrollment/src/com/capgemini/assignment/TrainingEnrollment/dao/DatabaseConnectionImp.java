package com.capgemini.assignment.TrainingEnrollment.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import com.capgemini.assignment.TrainingEnrollment.model.Training;
import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;

public class DatabaseConnectionImp implements DatabaseConnection {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement ps;
	
	public DatabaseConnectionImp() {
		try{  
 
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","DB1","oracle");   
			stmt=con.createStatement();   
			
			}catch(Exception e){
				System.out.println(e);
			}
			  
	}
	public HashMap<Integer,Training> getALlTrainingDetails(){
		String query="Select * from training";
		HashMap<Integer,Training> hs=new HashMap();
		int i=0;
		try {
			rs=stmt.executeQuery(query); 
			while(rs.next()) {
				  Training training=new Training();
				  training.setTrainingId(rs.getInt(1));
				  training.setTrainingName(rs.getString(2));
				  training.setAvailableSeat(rs.getInt(3));
				  hs.put(i++,training);
				 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return hs;
	}
	public int  updateTrainingSeat(int TrainingId,int availableSeat) {
		int seat=availableSeat-1;
		String query="UPDATE Training SET AvailableSeat ="+seat+"WHERE TrainingId = "+TrainingId+";";
		int x=0;
		try {
			 x=stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
	/*
	 * public static void main(String[] args) { Dbconnect db= new Dbconnect();
	 * HashMap hs= db.getALlTrainingDetails(); for(int i=0;i<hs.size();i++) {
	 * 
	 * System.out.println(hs.get(i)); } }
	 */
}
