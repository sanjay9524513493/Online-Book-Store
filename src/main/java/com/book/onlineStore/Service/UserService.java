package com.book.onlineStore.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.book.onlineStore.Entity.Book;
import com.book.onlineStore.Entity.Role;
import com.book.onlineStore.Entity.User;
import com.book.onlineStore.Repository.*;


@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private BookRepository bookrepo;

	private BCryptPasswordEncoder encoded = new BCryptPasswordEncoder(12);
	
	///save all field in register
	public User saveAll(User user) 
	{
		//System.out.println(user.getPassword());
		user.setPassword(encoded.encode(user.getPassword()));
		return repo.save(user);
	}
	
	//logic for login
	public Object login(String phoneNumber,String password)
	{
		
		Optional<User> opt=repo.findByNumber(phoneNumber);
		
		//boolean a=opt.isPresent();
		//System.out.println(a);
		if(opt.isPresent())
		{
			
			User user=opt.get();
			//System.out.println(user.getPassword());
			if(encoded.matches(password, user.getPassword()))
			{
				 if(user.getRole()==null)
				 {
					 user.setRole(Role.USER);
				 }
				 
				List<Book> book=bookrepo.findAll() ;
				return book;
				
			}
			else
			{
				return "!...........Wrong Credential........!";
			}
		}
		else
		{
			return "!...................Please use the registered PhoneNumber.................!"; 
				
		}
		
	}
	
	
	
	
}
