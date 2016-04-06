package amazon.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutCtrl(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:index";
	}
		
}
