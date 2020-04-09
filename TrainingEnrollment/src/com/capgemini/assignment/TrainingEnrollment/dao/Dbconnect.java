package com.capgemini.assignment.TrainingEnrollment.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Dbconnect {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement ps;
	
	public Dbconnect() {
		try{  
 
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			 con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:DB1","sys","oracle");   
			 stmt=con.createStatement();     
			  
			}catch(Exception e){
				System.out.println(e);
			}  
			  
	}
	public HashMap getALlTrainingDetails() {
		String query="Select * from Training";
		ArrayList array=new ArrayList();
		HashMap<Integer,ArrayList> hs=new HashMap();
		int i=0;
		try {
			rs=stmt.executeQuery(query);
			while(rs.next()) {
				//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));
				array.add(rs.getInt(1));
				array.add(rs.getString(2));
				array.add(rs.getInt(3));
				hs.put(i++, array);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hs;
	}
	public void updateTrainingSeat(int TrainingId) {
		String query="UPDATE Training SET AvailableSeat =AvailableSeat-1 WHERE TrainingId = "+TrainingId+";";
		try {
			int x=stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
}
