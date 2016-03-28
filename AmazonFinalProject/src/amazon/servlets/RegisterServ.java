package amazon.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import amazon.dao.UserDAO;
import amazon.exceptions.UserException;
import amazon.model.Address;
import amazon.model.User;

@WebServlet("/RegisterServ")
public class RegisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		try {

			Address address = new Address(request.getParameter("street"), 
						 Integer.parseInt(request.getParameter("number")), 
						 				  request.getParameter("city"));

			User user = new User(request.getParameter("firstname"), 
								 request.getParameter("lastname"), 
								 request.getParameter("email"), 
								 request.getParameter("psw"), 
								 request.getParameter("rpsw"), 
								 address);

			UserDAO uDAO = new UserDAO();
			uDAO.addUser(user);


		} catch (NumberFormatException  e) {
			e.printStackTrace();
		} catch (UserException e) {

			e.printStackTrace();
		}
			response.sendRedirect("./");
	}
}
