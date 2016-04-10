package amazon.spring.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import amazon.dao.BookDAO;
import amazon.model.Book;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ServiceController {
	@RequestMapping(value = "/service", method = RequestMethod.GET)
	public String showBooksCtrl(Model model) {
		List<Book> books = new BookDAO().getAllBooks();
		
		model.addAttribute("books", new Gson().toJson(books));
		return "service";
	}
}
