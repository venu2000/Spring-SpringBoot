package com.flmfood.Dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceOrderRequestDTO {
	
	
	private List<OrderItemRequestDTO> orderItemRequestList;
	

}
