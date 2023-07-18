package audilytics_Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class welcome
 */
@WebServlet("/welcome")
public class welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		try 
		{
			response.setContentType("text/html");
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/audilytics","root","tiger");
			PreparedStatement ps=con.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();
			PrintWriter pw=response.getWriter();
			pw.println("<html><body><table border='2'><tr><td>userName</td><td>password</td><td>firstName</td><td>lastName</td><td>dob</td><td>address</td><td>postalcode</td><td>phoneNumber</td></tr>");
			while(rs.next())
			{
				pw.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td></tr>");
			}
			pw.print("</table></body></html>");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
