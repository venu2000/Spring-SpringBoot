package com.flmfood.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flmfood.Dto.OrderResponseDTO;
import com.flmfood.Dto.PlaceOrderRequestDTO;
import com.flmfood.Service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping
	public OrderResponseDTO placeOrder (@RequestBody PlaceOrderRequestDTO orderRequestDTO) {
		return orderService.placeOrder(orderRequestDTO);
		
		
		
	}
	
	// i did extra API other then classes
	
	@GetMapping("/getAllOrders")
	public  List<OrderResponseDTO> getAllOrders() {
		return orderService.getAllOrder();
		
	}
	
	@PostMapping("/delete")
	public String cancelOrder(@RequestParam(name = "id") int id) {
		return orderService.cancelOrder(id);
		
	
		
		
	}
	
	
	
	
}
