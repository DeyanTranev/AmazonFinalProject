package amazon.spring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import amazon.dao.BookDAO;
import amazon.model.Book;

@Controller
public class TestController {
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String testCtrlGet(Model model) {
		BookDAO bDao = new BookDAO();
		List<Book> books = bDao.getAllBooks();
		
			model.addAttribute("books", books);

		return "test";
	}

	@RequestMapping(value = "/test2/{book_id}", method = RequestMethod.GET)
	public String testCtrlGetBook(Model model, @PathVariable("book_id") int id) {
		BookDAO bDao = new BookDAO();

		Book book = bDao.getBookById(id);

			model.addAttribute("book", book);

		return "test2";
	}
}
