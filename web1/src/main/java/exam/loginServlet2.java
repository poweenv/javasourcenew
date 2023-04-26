package exam;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login2")
public class loginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String userid=request.getParameter("userid");
		String password=request.getParameter("passord");

		
		// loginPro 에서 uesrid, password 값을 공유하고 싶음
		// setAtribute(), getAttribute(), removeAttribute()
		
		request.setAttribute("userid",userid);
		request.setAttribute("password",password);
		
		RequestDispatcher rd = request.getRequestDispatcher("");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
