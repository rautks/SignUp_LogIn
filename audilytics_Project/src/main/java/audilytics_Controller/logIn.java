package audilytics_Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

/**
 * Servlet implementation class logIn
 */
@WebServlet("/login")
public class logIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		Connection con=null;
		RequestDispatcher reqdisp=null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/audilytics","root","tiger");
			PreparedStatement ps=con.prepareStatement("select * from employee where userName=? and password=?");
			ps.setString(1, userName);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				request.setAttribute("Status","Success");
				reqdisp=request.getRequestDispatcher("welcome.html");
			}
			else
			{
				request.setAttribute("Status","failed");
				reqdisp=request.getRequestDispatcher("logIn.html");
			}
			reqdisp.forward(request, response);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
