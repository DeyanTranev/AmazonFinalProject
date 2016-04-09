package amazon.dao;

import java.util.List;

import amazon.exceptions.AuthorException;
import amazon.model.Author;

public interface IAuthorDAO {

	List<Author> getAllAuthors();

	int getAuthorId(String name);

	Author getAuthorById(int id) throws AuthorException;

	int addAuthor(Author author);

}