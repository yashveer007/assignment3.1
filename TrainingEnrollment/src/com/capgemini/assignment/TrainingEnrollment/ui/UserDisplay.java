package com.capgemini.assignment.TrainingEnrollment.ui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.assignment.TrainingEnrollment.service.UserDisplayService;


public class UserDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserDisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		int availableSeat=Integer.parseInt(request.getParameter("availableSeat"));
		int trainingId=Integer.parseInt(request.getParameter("trainingId"));
		String trainingName=request.getParameter("trainingName");
		//out.print(availableSeat+" "+trainingId+" "+trainingName);
		if(availableSeat==0) { 
			out.print("No seat avialable ");
		}
		if(availableSeat>0) {
			
			UserDisplayService us=new UserDisplayService();
			int x=us.updateDatabase(trainingId,availableSeat);
			//out.print(x);
			//if(x>0) {
				out.print("<b>hii you have successfully enrollled for "+trainingName+"training</b>");
			//}
		}
	}

}
