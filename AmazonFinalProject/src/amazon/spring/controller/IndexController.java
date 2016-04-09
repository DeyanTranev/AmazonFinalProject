package amazon.spring.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import amazon.dao.BookDAO;
import amazon.dao.IBookDAO;
import amazon.model.Book;
import amazon.model.Search;



@Controller
public class IndexController {

	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String indexCtrl(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if (session.getAttribute("name")!=null) {
			ArrayList<Book> cart = ((ArrayList<Book>)session.getAttribute("cart"));
			model.addAttribute("cart");
			double total = ((Double)session.getAttribute("total"));
		}
		IBookDAO bDao = new BookDAO();
		Search search = new Search();
		List<Book> books = bDao.getAllBooks();
		
		
			model.addAttribute("books", books);
			model.addAttribute("searchForm", search);
		
		return "index";
	}
	
	@RequestMapping(value="/search", method = RequestMethod.POST) 
	public String searchCtrl(@ModelAttribute("searchForm") Search search, Model model) {
		IBookDAO bDao = new BookDAO();
		System.out.println(search.getSelectMenu() + " ---------------");
		List<Book> books = bDao.bookBy(search.getSelectMenu(), search.getUserInput());
		model.addAttribute("books", books);
		return "index";
	}

	
}
