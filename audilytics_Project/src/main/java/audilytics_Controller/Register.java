package audilytics_Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@SuppressWarnings("unused")
@WebServlet("/signUp")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String dob=request.getParameter("dob");
		String address=request.getParameter("address");
		String postalcode=request.getParameter("postcode");
		String phoneNumber=request.getParameter("phoneNumber");
		
		RequestDispatcher reqdisp=null;
		Connection con=null;
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/audilytics","root","tiger");
			PreparedStatement ps=con.prepareStatement("insert into employee (userName, password, firstName, lastName, dob, address, postalcode,phoneNumber) values(?,?,?,?,?,?,?,?)");
			ps.setString(1, userName);
			ps.setString(2, password);
			ps.setString(3, firstName);
			ps.setString(4, lastName);
			ps.setString(5, dob);
			ps.setString(6, address);
			ps.setString(7, postalcode);
			ps.setString(8, phoneNumber);
			
			int rowcount=ps.executeUpdate();		
			
			reqdisp=request.getRequestDispatcher("signUp.html");
			if(rowcount>0)
			{
				request.setAttribute("Status", "Success");
			}
			else
			{
				request.setAttribute("Status", "Failed");
			}
			reqdisp.forward(request, response);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}

}
