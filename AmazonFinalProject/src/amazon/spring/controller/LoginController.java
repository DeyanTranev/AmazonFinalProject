package amazon.spring.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import amazon.dao.UserDAO;

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
	public String loginPost(@ModelAttribute("loginForm") Login login, HttpServletRequest request) {
		UserDAO userDAO = new UserDAO();
		
			if (userDAO.login(login.getEmail(), login.getPass())) {
				request.getSession();
				return "redirect:index";
			} else {
				return "test";
			}
		}
	

}
