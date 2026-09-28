package com.flm.products.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flm.products.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
