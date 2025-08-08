package com.book.onlineStore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.onlineStore.Entity.Cart;
import com.book.onlineStore.Service.CartService;

@RestController
public class CartController {
	
	@Autowired
	private CartService cartserv;
	
	
	@PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestBody Cart item) 
	{
        cartserv.addCart(item);
        return ResponseEntity.ok("Item added to cart");
    }
	
	@GetMapping
    public List<Cart> getCart() {
        return cartserv.getCart();
    }
	
	@DeleteMapping("/remove/{isbn}")
    public ResponseEntity<String> removeItem(@PathVariable String isbn) {
        cartserv.removeCart(isbn);
        return ResponseEntity.ok("Item removed");
    }
	
	
	
}