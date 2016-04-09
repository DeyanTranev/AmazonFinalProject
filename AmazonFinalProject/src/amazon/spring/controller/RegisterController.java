package amazon.spring.controller;



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
public class RegisterController {
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String getRegCtrl(Model viewModel) {
		UserWrap userWrap = new UserWrap();
		viewModel.addAttribute(userWrap);
		
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registeruser(@ModelAttribute UserWrap userWrap) throws UserException  {
		IUserDAO udao = new UserDAO();
		
		User user = userWrap.getUser();
		Address address = userWrap.getAdress();
		user.setAddress(address);
		
		udao.addUser(user);
		
		return "index";
	}
}
