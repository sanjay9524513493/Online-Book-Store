package com.book.onlineStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.onlineStore.Entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

}
