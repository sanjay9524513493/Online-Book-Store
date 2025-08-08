package com.book.onlineStore.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.book.onlineStore.Entity.Book;
import com.book.onlineStore.Repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookrepo;
	
	
	public String addDetails(Book book)
	{
		bookrepo.save(book);
		return "Data Stored Successfully";
		
	}
	
	public List<Book> showDetail()
	{
		return bookrepo.findAll();
	}
	
	public List<Book> getByCategory(String category)
	{
		return bookrepo.getByCategory(category);
	}
	
	
	public List<Book> getByAuthor(String author)
	{
		return bookrepo.getByAuthor(author);
	}
	
	public Optional<Book> getByTitle(String title)
	{
		return bookrepo.getByTitle(title);
	}
	
	public Optional<Book> getByIsbn(String isbn)
	{
		return bookrepo.getByIsbn(isbn);
		
	}
	
	public String updateByTitle(String isbn,int newstock)
	{
		System.out.println(isbn+" "+newstock);
		 bookrepo.updateByTitle(isbn, newstock);
		 return "Updated Successfully";
	}
	
	
	
}
