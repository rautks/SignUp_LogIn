package audilytics_Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class audilytics_Dao 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/audilytics","root","tiger");
		Statement st=con.createStatement();
//		String s1="Create Database";
		String s1="Create table audilytics.employee( userName varchar(30), password varchar(15), firstName varchar(20), lastName varchar(20),dob varchar(10), address varchar(50),postalcode int, phoneNumber varchar(10))";
		
		st.execute(s1);
		System.out.println("Table is Created");
	}
}
