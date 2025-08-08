   package com.book.onlineStore.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.book.onlineStore.Entity.Book;
import com.book.onlineStore.Service.BookService;
//controller
@RestController
public class BookController {
	
	@Autowired
	private BookService bookserv;
	
	@PostMapping("/Book")
	public String insertDetails(@RequestBody Book book)
	{
		return bookserv.addDetails(book);
	}
	
	@GetMapping("/bookshow")
	public List<Book> display()
	{
		return bookserv.showDetail();
	}
	
	@GetMapping("/isbn/{isbn}")
	public Optional<Book> byIsbn(@PathVariable String isbn)
	{
		return bookserv.getByIsbn(isbn);
		        		
	}
	
	@GetMapping("/category")
	public List<Book> byCategory(@RequestBody String category)
	{
		return bookserv.getByCategory(category);
	}
	
	@GetMapping("/author")
	public List<Book> byAuthor(@RequestBody String author)
	{
		return bookserv.getByAuthor(author);
	}
	
	@GetMapping("/title")
	public Optional<Book> getByTitle(@RequestBody String title)
	{
		return bookserv.getByTitle(title);
	}
	
	@PutMapping("/update")
	public String updateByTitle(@RequestParam String isbn,@RequestParam int newstock)
	{
		
		return bookserv.updateByTitle(isbn, newstock);
	}
	
	
}
