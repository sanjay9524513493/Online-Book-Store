package com.book.onlineStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.onlineStore.Entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{
	


	
}
