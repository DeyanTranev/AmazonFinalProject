package amazon.demo;

import java.util.List;

import amazon.dao.AuthorDAO;
import amazon.model.Author;


public class Demo {

	public static void main(String[] args) {
		
		AuthorDAO author = new AuthorDAO();
		
		System.out.println(author.getAuthorId("stephen king"));
		
		
//		List<Author> list = author.getAllAuthors();

//		for (Author author2 : list) {
//			System.out.println(author2);
//		}
	}

}
