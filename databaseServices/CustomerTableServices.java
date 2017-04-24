package databaseServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerTableServices {
	public static Connection getConnection() throws Exception{
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/demo";
			String username = "sa";
			String password = "1234";
			//Class.forName(driver);

			System.out.println("inside getConnection() ");
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("Connected");
			System.out.println(conn);

		}catch(Exception e1){
			String excep = e1.getMessage();
			String userMsg="";
			if(excep.equalsIgnoreCase("Database not found")){
				userMsg= "We are not able to connect to database, please try after some time. If the problem persists then call customer support.";
			}
			else if(excep.equalsIgnoreCase("Table not found")){
				userMsg= "We are not able to connect to database, please try after some time. If the problem persists then call customer support.";
			}
			System.out.println(e1);
		}
		return conn;
	}
	
	public static boolean insert(String fname,String lname)//throws Exception
	{
		boolean isSuccess = false;
		try{
			System.out.println("Insert method fname= "+fname);
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("INSERT INTO "
					+ "customer(first,last"
					+ ")VALUES('"+fname+"', '"+lname+"')");
			posted.executeUpdate();
			System.out.println("Insert complete.");
			isSuccess=true;
		}catch(Exception e){
			System.out.println(e);
		}finally{
		}
		return isSuccess;
	}
	public static ResultSet getRecordById(String id)
	{
		ResultSet result = null;
		try{
			System.out.println("*** getRecordById method id= "+id);
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement
					("SELECT first,last From customer WHERE id=" +id);
			result = statement.executeQuery();
			System.out.println(result);
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
		 return result;

	}
	
	public static ResultSet getRecordByFirstName(String firstname)
	{
		ResultSet result = null;
		try{
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement
					("SELECT first,last From customer WHERE first='"+firstname+"'");
			System.out.println(" inside getRecordByFirstName ****");
			result = statement.executeQuery();
			System.out.println(result);
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
		 return result;

	}
	
	public static ResultSet getRecordByLastName(String lastname)
	{
		ResultSet result = null;
		try{
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement
					("SELECT first,last From customer WHERE last='"+lastname+"'");
			result = statement.executeQuery();
			System.out.println(result);
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
		 return result;

	}
	
	
	
	
	
	
	
}