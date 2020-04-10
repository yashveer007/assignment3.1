package com.capgemini.assignment.TrainingEnrollment.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.assignment.TrainingEnrollment.dao.DatabaseConnection;
import com.capgemini.assignment.TrainingEnrollment.dao.DatabaseConnectionImp;
import com.capgemini.assignment.TrainingEnrollment.model.Training;
import com.capgemini.assignment.TrainingEnrollment.service.ShowUserDetails;


public class ShowDetails extends HttpServlet {
	
    public ShowDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		ShowUserDetails userDetails= new ShowUserDetails();
		HashMap<Integer,Training> hs=userDetails.getAllTraining();
		out.print("<table><tr><th>TrainingId</th><th>TrainingName</th><th>AvailableSeat</th></tr>");
		for(int i=0;i<hs.size();i++) {
			Training arr=hs.get(i);
			out.print("<tr>");
			out.print("<td>"+arr.getTrainingId()+"</td>");
			out.print("<td>"+arr.getTrainingName()+"</td>");
			out.print("<td>"+arr.getAvailableSeat()+"</td>");
			
			out.print("<td><a href='UserDisplay?trainingId="+""+arr.getTrainingId()+"&&availableSeat="+""+arr.getAvailableSeat()+"&&trainingName="+arr.getTrainingName()+"'>Enroll</a>");
			out.print("</td>");
			out.print("</tr>");
		}
		out.print("</table>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
