package amazon.spring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import amazon.model.Book;

@Controller
@SessionAttributes("cart")
public class OrderControler {

	
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String orderCtrl(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if (session.getAttribute("name") == null) {
			ArrayList<Book> cart = new ArrayList<Book>();
			session.setAttribute("cart", cart);
			return "redirect:login";
		} else {
			
			return "order";
		}
	}
	
}
