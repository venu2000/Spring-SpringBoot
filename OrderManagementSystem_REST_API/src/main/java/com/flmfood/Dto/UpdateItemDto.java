package com.flmfood.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateItemDto {

	private String itemName;
	
	@Column(nullable=true)
	private double price;
	
	private int stockQuantity;
	
	private double rating;
	
	private double discount;

}
