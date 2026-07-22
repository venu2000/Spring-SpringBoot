package com.flmfood.Service;

import java.util.List;

import com.flmfood.Dto.OrderResponseDTO;
import com.flmfood.Dto.PlaceOrderRequestDTO;

public interface OrderService {
	
	public OrderResponseDTO placeOrder (PlaceOrderRequestDTO orderRequestDTO);

	
	public List<OrderResponseDTO> getAllOrder();
	
	public String cancelOrder(int id);
	
	
	}

