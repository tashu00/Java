package dbServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerAccountInfo {
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

	public static boolean insert(String fname,String lname,String ssn,String accNo,double bal)//throws Exception
	{
		boolean isSuccess = false;
		try{
			System.out.println("Insert method fname= "+fname);
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("INSERT INTO "
					+ "accountinfo(FirstName,LastName,ssn,accountNum,balance)"
					+ "VALUES('"+fname+"', '"+lname+"','"+ssn+"','"+accNo+"','"+bal+"')");
			posted.executeUpdate();
			System.out.println("Insert complete.");
			isSuccess=true;
		}catch(Exception e){
			e.getLocalizedMessage();
			System.out.println(e);
		}finally{
		}
		return isSuccess;
	}
	public static ResultSet getRecordBySSN(String ssn)
	{
		ResultSet result = null;
		try{
			System.out.println("*** getRecordById method SSN= "+ssn);
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement
					("SELECT FirstName,LastName,ssn,accountNum,balance From accountinfo WHERE ssn=" +ssn);
			result = statement.executeQuery();
			System.out.println(result);
			//con.
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
		
		 return result;

	}
	public static boolean updateBalance(String ssn,double bal)//throws Exception
	{
		boolean isSuccess = false;
		try{
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("update demo.accountinfo "
					+ "set balance ='" +bal
					+ "' where ssn = '"+ssn +"'");
			posted.executeUpdate();
			System.out.println("Update complete for query = "+posted.toString());
			isSuccess=true;
		}catch(Exception e){
			e.getLocalizedMessage();
			System.out.println(e);
		}finally{
		}
		return isSuccess;
	}

}
