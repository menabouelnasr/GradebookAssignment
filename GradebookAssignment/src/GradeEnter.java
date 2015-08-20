import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;
import java.util.ArrayList;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
         response.setContentType("text/html");
         out.println("<html><body>");
         try {
        	//URL of Oracle database server
        	 
             String url = "jdbc:oracle:thin:testuser/password@localhost"; 
             Class.forName("oracle.jdbc.driver.OracleDriver");
             
             //properties for creating connection to Oracle database
             Properties props = new Properties();
             props.setProperty("user", "testdb");
             props.setProperty("password", "password");
           
             //creating connection to Oracle database using JDBC
             try {
     			conn = DriverManager.getConnection(url,props);
     		} catch (SQLException e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}
          
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from Gradebook");     

         output+="<table border=2 color=white bgcolor=black>";
         output+="<tr><th>Assignment </th><th>Grade</th></tr> ";   
         while(rs.next())
        	 {
        		 assignment= rs.getString("Assigment");
        		 System.out.println(assignment);
        		 grade= rs.getString("Grade");
        		 grade2= Integer.parseInt(grade);
        		 average+=grade2;
        		 output+= "<tr><td>" + assignment +"</td><td>"+ grade + "</td></tr>"; 
        		 count++;
             
        	 }
         aveT+="<p></p><table alight=center border=1 color=white bgcolor=white>";
         aveT+="<tr><th>Average</th></tr> ";
         System.out.println(count);
         average2=average/count;
         aveT+= "<tr><td>" + String.valueOf(average2) +"</td></tr>";;
         conn.close();
        }
         catch (Exception e) 
         {
        	 e.getMessage();
         }
         
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
