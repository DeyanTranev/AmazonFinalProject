package amazon.spring.controller;

import java.util.List;

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
public class ShopController {

	@RequestMapping(value="/shop", method = RequestMethod.GET)
	public String cartCtrl(Model model) {
		
		IBookDAO bDao = new BookDAO();
		List<Book> books = bDao.getAllBooks();
		model.addAttribute("books", books);
		return "shop";
	}
	
	
}
