package com.book.onlineStore.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import com.book.onlineStore.Entity.Cart;

@Service
@SessionScope
public class CartService {
	
	
	 private List<Cart> cart = new ArrayList<>();

	    public List<Cart> getCart() {
	        return cart;
	    }
	
	public void addCart(Cart item)
	{
		for (Cart existing : cart) {
            if (existing.getIsbn().equals(item.getIsbn())) {
                existing.setQuantity(existing.getQuantity() + item.getQuantity());
                return;
            }
        }
        cart.add(item);
    }
	
	public void removeCart(String isbn) {
        cart.removeIf(item -> item.getIsbn().equals(isbn));
    }
	
	public void clearCart() {
        cart.clear();
    }
	
	
	
	
	
}
