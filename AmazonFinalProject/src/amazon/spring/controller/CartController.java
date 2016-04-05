package amazon.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CartController {

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String cartCtrl(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if ((String)session.getAttribute("name") == null) {
			return "redirect:login";
		} else {
			return "cart";
		}
	}

}
