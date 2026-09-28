package com.flmfood.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flmfood.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	

}
