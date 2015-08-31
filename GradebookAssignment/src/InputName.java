

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customTools.DBUtil;
import model.Gradebookjpa;


/**
 * Servlet implementation class InputName
 */
@WebServlet("/InputName")
public class InputName extends HttpServlet 
{
	static Connection conn;
	static String name, grade, output;

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

    public InputName() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public static void insert(Gradebookjpa grade) 
    {
    	EntityManager em = DBUtil.getEmFactory().createEntityManager();
    	EntityTransaction trans = em.getTransaction();
    	trans.begin(); 
    	try {
    	em.persist(grade);
    	trans.commit();
    	} catch (Exception e) {
    	System.out.println(e);
    	trans.rollback();
    	} finally {
    
    	}
    }

    protected void processRequest( HttpServletRequest request, HttpServletResponse response )throws ServletException, IOException 
    {
    	String assignmentName;
    	String tempStr;
    	int grade = 0;
    	 
    	EntityManager em = DBUtil.getEmFactory().createEntityManager();
    	assignmentName = (String)request.getParameter( "Assignment" );
    	tempStr = (String)request.getParameter( "grade" );
    	grade = Integer.parseInt( tempStr );
    	
    	try 
		{   model.Gradebookjpa user = new Gradebookjpa();
			user.setAssignment(assignmentName);
			user.setGrade(grade);
			insert(user);
		
		} catch (Exception e){
			System.out.println(e);
		} finally {
		}

    	

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	    getServletContext().getRequestDispatcher("/Display.jsp").forward(request,response);
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/Display.jsp").forward(request,response);
		processRequest(request, response);
	}

}
