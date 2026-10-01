package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // Instead of using @Setter, @Getter, @toString -> we can use @Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	private int id;
	private String name;
	private int price;
	
}
