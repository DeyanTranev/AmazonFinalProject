package amazon.spring.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import amazon.dao.BookDAO;
import amazon.model.Book;
import amazon.model.Search;



@Controller
public class IndexController {

	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String indexCtrl(HttpServletRequest request, Model model) {
		
		BookDAO bDao = new BookDAO();
		Search search = new Search();
		List<Book> books = bDao.getAllBooks();
		
			model.addAttribute("books", books);
			model.addAttribute("searchForm", search);
		
		return "index";
	}
	
	@RequestMapping(value="/search", method = RequestMethod.POST) 
	public String searchCtrl(@ModelAttribute("searchForm") Search search, Model model) {
		BookDAO bDao = new BookDAO();
		List<Book> books = bDao.bookBy(search.getSelectMenu(), search.getUserInput());
		model.addAttribute("books", books);
		return "index";
	}
	

	
}
