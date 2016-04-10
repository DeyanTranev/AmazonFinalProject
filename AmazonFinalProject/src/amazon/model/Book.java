package amazon.model;



import amazon.exceptions.BookException;

public class Book {

	private int id;
	private String title;
	private double price;
	private String publishDate;
	private String blurb;
	private Author author;
	private String genre;
	private String img;
	
	public Book(String title, Author author, String genre, String publishDate, 
			String blurb, double price, String img) throws BookException {
		
		setTitle(title);
		setPrice(price);
		setPublishDate(publishDate);
		setBlurb(blurb);
		setAuthor(author);
		setGenre(genre);
		setImg(img);
	}

	
	public Book(int id, String title, double price, String publishDate, String blurb,
			Author author, String genre, String img) throws BookException {
		this(title, author, genre, publishDate, blurb, price, img);
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) throws BookException {
		
		if (publishDate != null && !publishDate.trim().isEmpty()) {
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
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) throws BookException {
		if(img != null && !img.trim().isEmpty()) {
		this.img = img;
		}
		else {
			throw new BookException("Input valid image name!");
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Title: " + getTitle());
		sb.append("Author: " + getAuthor());
		sb.append("Price: " + getPrice());
		
		return sb.toString();
	}


	
}
