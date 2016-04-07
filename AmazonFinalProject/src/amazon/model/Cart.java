package amazon.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {
	private List<Book> books=new ArrayList<Book>();
	private Book book;
	
	public void addToCart(Book book) {
		books.add(book);
	}
	
	public void removeFromCart(Book book) {
		books.remove(book);
	}
	
	public void emptyCart() {
		books.clear();
	}
	

	public List<Book> getBooks() {
		return books;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
}
