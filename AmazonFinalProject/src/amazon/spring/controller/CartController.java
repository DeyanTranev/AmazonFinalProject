package amazon.spring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import amazon.dao.BookDAO;
import amazon.dao.IBookDAO;
import amazon.model.Book;
import amazon.model.Cart;

@Controller
@SessionAttributes("cart")
public class CartController {

	@RequestMapping(value = "/addtocart", method = RequestMethod.GET)
	public String cartCtrl(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if (session.getAttribute("name") == null) {
			ArrayList<Book> cart = new ArrayList<Book>();
			session.setAttribute("cart", cart);
			return "redirect:login";
		} else {
			
			return "addtocart";
		}
	}

	@RequestMapping(value = "/addtocart/{book_id}", method = RequestMethod.GET)
	public String addToCartCtrl(Model model, @PathVariable("book_id") Integer id, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("name") == null) {
			try {
				ArrayList<Book> cart = new ArrayList<Book>();
				double total = 0.0;
				session.setAttribute("cart", cart);
				session.setAttribute("total", total);
				return "redirect:/login";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				model.addAttribute("error", "An error occurred");
				return "index";
			}
		} 
		else {
			try {
				IBookDAO bdao = new BookDAO();
				Book book = bdao.getBookById(id);
				ArrayList<Book> cart = ((ArrayList<Book>)session.getAttribute("cart"));
				double total = ((Double)session.getAttribute("total"));
				//System.out.println(cart + "---------------------------");
				cart.add(book);
				total+=book.getPrice();
				model.addAttribute("cart", cart);
				session.setAttribute("cart", cart);
				model.addAttribute("total", total);
				session.setAttribute("total", total);
				for (Book b : cart) {
					System.out.println(b);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				model.addAttribute("error", "An error occurred! ");
				e.printStackTrace();
				return "addtocart";
			}
			return "addtocart";
		}
		
		
	}
	
	@RequestMapping(value="/remove/{book_id}", method = RequestMethod.GET)
	public String removeFromCartCtrl(Model model, @PathVariable("book_id") Integer id, HttpServletRequest request) {
		HttpSession session = request.getSession();
		IBookDAO bdao= new BookDAO();
		
		ArrayList<Book> cart = ((ArrayList<Book>)session.getAttribute("cart"));
		double total = ((Double)session.getAttribute("total"));
		Book bookToRemove = bdao.getBookById(id);
		cart.remove(bookToRemove);
		
		for (Book b : cart) {
			System.out.println("---------------------------------------------------"+b);
		}
		total-=bdao.getBookPriceById(id);
		model.addAttribute(cart);
		session.setAttribute("cart", cart);
		model.addAttribute("total", total);
		session.setAttribute("total", total);
		
		return "addtocart";
	}
	
	

}
