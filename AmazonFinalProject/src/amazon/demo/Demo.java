package amazon.demo;

import java.util.List;

import amazon.dao.AddressDAO;
import amazon.dao.AuthorDAO;
import amazon.exceptions.UserException;
import amazon.model.Address;
import amazon.model.Author;


public class Demo {

	public static void main(String[] args) {
		
		
		AddressDAO aDao = new AddressDAO();
		
		try {
			aDao.addAddress(new Address("Golqmo nadolnishte", 14, "Selska Morava"));
		} catch (UserException e) {
			e.printStackTrace();
		}
		
		
//		AuthorDAO author = new AuthorDAO();
//		
//		System.out.println(author.getAuthorId("stephen king"));
//		
		
//		List<Author> list = author.getAllAuthors();

//		for (Author author2 : list) {
//			System.out.println(author2);
//		}
	}

}
