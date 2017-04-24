package account;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dbServices.CustomerAccountInfo;
import dbServices.AccountOutput;

/**
 * Servlet implementation class CustomerInfoServlet
 */
@WebServlet("/CustomerInfo")
public class CustomerInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private double origAmt;// declaring class variable 
	private String origSsn;//   same as above

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String ssn=  request.getParameter("searchSSN");
		ResultSet result2 = CustomerAccountInfo.getRecordBySSN(ssn);

		try{
			// storing data in Arraylist for collecting multypal information
			ArrayList<AccountOutput> myArr = new ArrayList<AccountOutput>();
			int i=0;
			while(result2.next()){
				System.out.println(" VINAY obj "+i++);
				AccountOutput obj= new AccountOutput();
				obj.setFirstName(result2.getString("FirstName"));//getting customer info from data base
				obj.setLastName(result2.getString("LastName"));
				obj.setSsn(result2.getString("ssn"));
				origSsn = result2.getString("ssn");
				obj.setAccountNum(result2.getString("accountNum"));
				obj.setBalance(result2.getDouble("balance")); //  same as above
				origAmt = result2.getDouble("balance");
				myArr.add(obj);
			}
			request.setAttribute("myArr2",myArr );
		}
		catch(Exception e){//handling exception
			e.printStackTrace();
			request.setAttribute("confMsg2", e.getMessage() );
		}
		request.getRequestDispatcher("/CreatPage.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doGet(request, response);
		if(request.getParameter("btnAccInfo") != null){
			String errorMsg ="";
			String firstName=  request.getParameter("firstName");// getting customer info from screen
			System.out.println("firstName ="+firstName);
			String lastName=   request.getParameter("lastName");
			String ssn =   request.getParameter("ssn");
			String accountNo =   request.getParameter("accountNo");
			String balance =   request.getParameter("balance");//   ''  .....
			
			if(firstName.isEmpty()){
				errorMsg = "Firstname Field is Empty";//handling exception by any field is empty or not
				request.setAttribute("confMsg", errorMsg);
			}
			else if(lastName.isEmpty()){
				errorMsg = "LastName Field is Empty"; //   ''  .....
				request.setAttribute("confMsg", errorMsg);
			}
			else if(ssn.isEmpty()){
				errorMsg = "SSN Field is Empty";  // same a above
				request.setAttribute("confMsg", errorMsg);
			}
			else if(accountNo.isEmpty()){
				errorMsg = "Account Number Field is Empty";
				request.setAttribute("confMsg", errorMsg);
			}
			else if(balance.isEmpty()){
				errorMsg = "Balance Field is Empty";
				request.setAttribute("confMsg", errorMsg); // same as above
			}
			else{	
				// added values in data base after checking any field is empty or not
				double balance1 =  Double.parseDouble(balance); 
				boolean status= CustomerAccountInfo.insert(firstName,lastName,ssn,accountNo,balance1);
				if(status)
					request.setAttribute("confMsg", "Values added to DB");
				else
					request.setAttribute("confMsg", "Some error");
			}
		}
		if(request.getParameter("btnUpdBal") != null){
			//this area updating balance after doing some changes in balance
			System.out.println("Updating balance");
			String radioBal = request.getParameter("radiobalance");
			double newBal = 0;
			String balance =   request.getParameter("userAmount");
			if(!balance.isEmpty() ){
				double balance1 =  Double.parseDouble(balance); 
				if("withdraw".equals(radioBal)){
					newBal = origAmt - balance1;
					System.out.println("New Balance "+newBal);
				}else if("deposit".equals(radioBal)){
					newBal = origAmt + balance1;
					System.out.println("New Balance "+newBal);
				}
				//String errorMsg1 ="";
				boolean status= CustomerAccountInfo.updateBalance(origSsn,newBal);
				System.out.println("VINAY updateBalance status = "+status);
				if(status)
					request.setAttribute("confMsg3", "Balance updated to DB");
				else
					request.setAttribute("confMsg3", "Some error in update balance");
			}
			else{
				//handling exception 
				String errorMsg1 ="";
				errorMsg1 = " Update field is Empty ";
				request.setAttribute("confMsg3", errorMsg1);
				//System.out.println(" Update field is Empty ");
			}
		}
		request.getRequestDispatcher("/CreatPage.jsp").forward(request, response);

	}

}
