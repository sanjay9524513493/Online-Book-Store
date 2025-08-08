package com.book.onlineStore.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.book.onlineStore.Entity.Book;
import jakarta.transaction.Transactional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	@Query(value = "SELECT * FROM book where category=?",nativeQuery = true)
	public List<Book> getByCategory(String category);
	
	@Query(value = "SELECT * FROM book where author=?",nativeQuery = true)
	public List<Book> getByAuthor(String author);
	
	
	@Query(value = "SELECT * FROM book where isbn=?",nativeQuery = true)
	public Optional<Book> getByIsbn(String isbn);
	
	@Query(value= "SELECT * FROM book where title=?",nativeQuery = true)
	public Optional<Book> getByTitle(String title);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE book SET stock=stock+?2 where isbn=?1",nativeQuery = true)
	public int updateByTitle(String isbn,int newstock);
	
	
}
