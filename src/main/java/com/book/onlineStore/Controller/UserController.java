package com.book.onlineStore.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.book.onlineStore.Entity.User;
import com.book.onlineStore.Service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	
	//Register Method
	@PostMapping("/register")
	public String register(@RequestBody User user)
	{
		service.saveAll(user);
		return "Registered Successfully";
	}
	
	
	@GetMapping("/userlogin")
	public Object login(@RequestPart String phoneNumber,String password)
	{
		//System.out.println(password);
		return service.login(phoneNumber, password);
	}
	
	
}
