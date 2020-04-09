package com.capgemini.assignment.TrainingEnrollment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.assignment.TrainingEnrollment.dao.Dbconnect;


public class ShowDetails extends HttpServlet {
	
    public ShowDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		Dbconnect db= new Dbconnect();
		HashMap<Integer,ArrayList> hs=db.getALlTrainingDetails();
		out.print("<table><tr><th>TrainingId</th><th>TrainingName</th><th>AvailableSeat</th></tr>");
		for(int i=0;i<hs.size();i++) {
			ArrayList arr=hs.get(i);
			out.print("<tr>");
			for(int j=0;j<arr.size();j++) {
				out.print("<td>"+arr.get(j)+"</td>");
			}
			out.print("<a href=\"\">Enroll</a>");
			out.print("</tr>");
		}
		out.print("</table>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
