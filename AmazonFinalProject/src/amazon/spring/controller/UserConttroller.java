package amazon.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import amazon.model.User;

@Controller
@SessionAttributes("user")
public class UserConttroller {
	
	@RequestMapping(value="/registerrrrr", method = RequestMethod.GET)
	public String user(Model model, HttpServletRequest request) {
		User user = new User();
		model.addAttribute(user);
		System.out.println(request.getAttribute("test"));
		return "register";
	}
	
	@RequestMapping(value="/registerrrrrr", method = RequestMethod.POST)
	public String products(@ModelAttribute User user) {
		
		//add the new product somewhere
		
		System.out.println(user);
		
		// redirect to home page
		return "redirect:test";
	}

}
