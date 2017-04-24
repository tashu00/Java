package teshuServlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseServices.CustomerOutput;
import databaseServices.CustomerTableServices;

@WebServlet( "/LoginProject" )
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=  request.getParameter("searchId");
		String firstName=  request.getParameter("searchFirst");
		System.out.println("*** inside doGet 1 firstName= "+firstName);
		String lastName=  request.getParameter("searchLast");
		ResultSet result2 = null;

		try{
			if(request.getParameter("buttonId") != null){
				System.out.println("*** inside 2 doGet searchId= "+id);
				result2= CustomerTableServices.getRecordById(id);
			}
			else if(request.getParameter("buttonFirst") != null){
				System.out.println("*** inside 3 doGet firstName= "+firstName);
				result2= CustomerTableServices.getRecordByFirstName(firstName);
			}
			else if(request.getParameter("buttonLast") != null){
				System.out.println("*** inside 4 doGet lastName= "+lastName);
				result2= CustomerTableServices.getRecordByLastName(lastName);
			}
			ArrayList<CustomerOutput> myArr = new ArrayList<CustomerOutput>();
			int i=0;
			while(result2.next()){
				System.out.println(" VINAY obj "+i++);
				CustomerOutput obj= new CustomerOutput();
				obj.setFirstName(result2.getString("first"));
				obj.setLastName(result2.getString("last"));
				myArr.add(obj);
			}
			request.setAttribute("myArr2",myArr );
		}catch(Exception e){
			request.setAttribute("confMsg2", e.getMessage() );
		}
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		String firstName,lastName;

		firstName = request.getParameter("firstName");
		lastName = request.getParameter("lastName");
		System.out.println(" values in servlet= "+firstName);
		boolean status= CustomerTableServices.insert(firstName,lastName);
		if(status)
			request.setAttribute("confMsg", "Values added to DB");
		else
			request.setAttribute("confMsg", "Some error");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

}
