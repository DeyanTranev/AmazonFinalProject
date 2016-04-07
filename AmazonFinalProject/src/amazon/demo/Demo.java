package amazon.demo;

import java.util.List;

import amazon.dao.BookDAO;
import amazon.dao.UserDAO;
import amazon.exceptions.BookException;
import amazon.exceptions.UserException;
import amazon.model.Address;
import amazon.model.Author;
import amazon.model.Book;
import amazon.model.User;

public class Demo {
	public static void main(String[] args) throws BookException, UserException {
		BookDAO bdao = new BookDAO();
		List<Book> books = bdao.getAllBooks();
		for (Book b: books) {
			System.out.println(b);
		}
		
//		Book book = new Book("Of mice and men", new Author("John", "Steinbeck"), "Drama", "1999-03-15", "Qko cherna komediq, brat", 10.25);
//		Book book2 = new Book("Reaper Man", new Author("Terry", "Pratchett"),"Fantasy","2013-07-30","Tova e hubava kniga, mnogo qko.",9.62);
//		bdao.addBook(book2);
		UserDAO udao = new UserDAO();
//		User user = new User("Pesho", "Petrov", "ppetrov@gmail.com", "1234", "1234", new Address("Latinka", 15, "Yambol"));
//		udao.addUser(user);
		
//		System.out.println(udao.getSaltFromUser("test16@t.com"));
	}

}
