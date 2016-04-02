package amazon.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import amazon.dao.UserDAO;
import amazon.exceptions.UserException;
import amazon.model.User;


@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String name = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		//boolean flag = false;
		
		UserDAO uDAO = new UserDAO();
		
		
		if(uDAO.login(name, pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			response.sendRedirect("./index.jsp");
		}
		else {
			response.sendRedirect("./failLogin.html");
		}
		
		
	}

}
