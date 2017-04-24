package tyagipreeti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tyagipreetiservice.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String USERID , PASSWORD;
		USERID = request.getParameter("userId");
		PASSWORD = request.getParameter("password");
		
		LoginService loginService = new LoginService();
		boolean result = loginService.authenticate(USERID, PASSWORD);
		if(result){
			response.sendRedirect("success.jsp");
			return;
		}
		else{
			response.sendRedirect("login.jsp");
			return;
			
		}
	}

}
