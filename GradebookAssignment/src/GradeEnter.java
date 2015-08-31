import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import customTools.DBUtil;
import model.Gradebookjpa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Servlet implementation class Details	
 */
@WebServlet("/GradeEnter")
public class GradeEnter extends HttpServlet {
	static Connection conn;
	static String assignment, grade, output="", custID, aveT="";
	static int grade2, count=0;
	static double average, average2;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeEnter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public List<Gradebookjpa> getGrades()
    {
    	EntityManager em = DBUtil.getEmFactory().createEntityManager();
    	String qString = "Select g from Gradebookjpa g";
    	TypedQuery<Gradebookjpa> q = em.createQuery(qString, Gradebookjpa.class);
    	
    	List<Gradebookjpa> grades;
    	try{ grades= q.getResultList();
    	if(grades == null || grades.isEmpty())
    		grades= null;
    	}
    	finally
    	{
    		em.close();
    	}
    	return grades;
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        
         output+="<table class= \"table table-striped\">";
         output+="<tr><th align=\"center\">Assignment Name</th><th align=center>Grade</th></tr> "; 
         
        List<Gradebookjpa> a = getGrades();
 		for(Gradebookjpa b : a)
 		{
 			output+= "<tr><td>"+ b.getAssignment()+"</td><td>" + b.getGrade()+"</td></tr>";
 			average+= b.getGrade();
 			count +=100;
 		}
 		 average2=average/count* 100;
 		 aveT+="<p></p><table class= \"table table-striped\">";
         aveT+="<tr><th>Average</th></tr> ";
         aveT+= "<tr><td>" + String.valueOf(average2) +"</td></tr>";
         
 	   request.setAttribute("message", output);
       request.setAttribute("average", aveT);
	   getServletContext().getRequestDispatcher("/Table.jsp").forward(request,response);
	   output="";
	   aveT="";
         
         
       
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
