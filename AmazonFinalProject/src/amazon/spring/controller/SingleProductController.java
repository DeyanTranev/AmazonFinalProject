package amazon.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import amazon.dao.BookDAO;
import amazon.dao.IBookDAO;
import amazon.model.Book;

@Controller
public class SingleProductController {

	@RequestMapping(value="/single-product-{id}", method = RequestMethod.GET)
	public String cartSingleProductCtrlId(Model model, @PathVariable("id") int id) {
		
		IBookDAO bDao = new BookDAO();
		Book book = bDao.getBookById(id);
		model.addAttribute("book", book);
		
		return "single-product";
	}
	
	@RequestMapping(value="/single-product", method = RequestMethod.GET)
	public String cartSingleProductCtrl() {
		return "single-product";
	}
	
}
