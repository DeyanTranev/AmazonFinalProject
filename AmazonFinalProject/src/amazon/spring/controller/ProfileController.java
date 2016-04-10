package amazon.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import amazon.dao.IUserDAO;
import amazon.dao.UserDAO;
import amazon.exceptions.UserException;
import amazon.model.Address;
import amazon.model.User;
import amazon.model.UserWrap;


@Controller
public class ProfileController {
	
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public String profileCtrl(HttpServletRequest request, Model model) {
		UserWrap userWrap = new UserWrap();
		HttpSession session = request.getSession();
		
		IUserDAO udao = new UserDAO();
		String email = "" + session.getAttribute("eMail");
		User user = udao.getUserByEmail(email);
		model.addAttribute("user", user);
		model.addAttribute("userWrap", userWrap);
		return "profile";
	}

	
	@RequestMapping(value="/profile", method=RequestMethod.POST)
	public String updateUser(@ModelAttribute("userWrap") UserWrap userWrap) throws UserException  {
		IUserDAO udao = new UserDAO();
		
		User user = userWrap.getUser();
		Address address = userWrap.getAdress();
		user.setAddress(address);
		
		udao.addUser(user);
		
		return "redirect:index";
	}
}
