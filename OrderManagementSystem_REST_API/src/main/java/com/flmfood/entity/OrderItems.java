package com.flmfood.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderItemId;
	
	private double price;
	
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name="items_id")
	private Items items;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	
	
	

	public OrderItems(double price, int quantity, Items items) {
		super();
		this.price = price;
		this.quantity = quantity;
		this.items = items;
	}

	public OrderItems(double price, int quantity) {
		super();
		this.price = price;
		this.quantity = quantity;
	}


	

}
