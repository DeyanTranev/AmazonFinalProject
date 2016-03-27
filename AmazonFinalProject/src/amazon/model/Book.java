package amazon.model;

import java.time.LocalDate;

import amazon.exceptions.BookException;

public class Book {
	private int id;
	private String title;
	private double price;
	private LocalDate publishDate;
	private String blurb;
	private Author author;
	private String genre;
	
	public Book(int id, String title, Author author, String genre, LocalDate publishDate, String blurb, double price) throws BookException {
		
		this.id = id;
		setTitle(title);
		setPrice(price);;
		this.publishDate = publishDate;
		setBlurb(blurb);
		setAuthor(author);
		setGenre(genre);
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) throws BookException {
		if (title != null && !title.trim().isEmpty()) {
			this.title = title;
		}
		else {
			throw new BookException("Invalid title");
		}
	}
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) throws BookException {
		if (price > 0) {
			this.price = price;
		}
		else {
			throw new BookException("Invalid price - must be greater than 0!");
		}
	}
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(LocalDate publishDate) throws BookException {
		
		if (publishDate != null) {
			this.publishDate = publishDate;
		}
		else {
			throw new BookException("Invalid date!");
		}
	}
	public String getBlurb() {
		return blurb;
	}
	public void setBlurb(String blurb) throws BookException {
		if (blurb != null && !blurb.trim().isEmpty()) {
			this.blurb = blurb;
		}
		else {
			throw new BookException("Invalid blurb!");
		}
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) throws BookException {
		
		if (author!=null) {
			this.author = author;
		}
		else {
			throw new BookException("Invalid author!");
		}
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) throws BookException {
		if (genre!=null && !genre.trim().isEmpty()) {
			this.genre = genre;
		}
		else {
			throw new BookException("Invalid genre!");
		}
	}
	public int getId() {
		return id;
	}
	
}
