package amazon.spring.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import amazon.dao.UserDAO;
import amazon.exceptions.UserException;
import amazon.model.Login;

@Controller
@SessionAttributes("login")
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String logingGet(Model model) {
		Login loginForm = new Login();

		model.addAttribute("loginForm", loginForm);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(@ModelAttribute("loginForm") Login login, HttpServletRequest request, Model model) throws UserException  {
		UserDAO userDAO = new UserDAO();
		
	
				if (userDAO.login(login.getEmail(), login.getPass())) {
					HttpSession session = request.getSession();
					session.setMaxInactiveInterval(60);
					String firstName = userDAO.getFirstNameByEmail(login.getEmail());
					session.setAttribute("name", firstName);
					model.addAttribute(session);
					return "redirect:index";
				} 
				else {
					model.addAttribute("error", "Invalid e-mail or password!");
					return "login";

				}
		}
	

}
