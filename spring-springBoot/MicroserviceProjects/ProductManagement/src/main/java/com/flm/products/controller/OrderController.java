package com.flm.products.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flm.products.dto.request.OrderCreateRequest;
import com.flm.products.dto.request.OrderUpdateRequest;
import com.flm.products.dto.response.OrderResponse;
import com.flm.products.service.OrderService;


@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService orderService;

	@PostMapping
	public OrderResponse saveOrder(@RequestBody OrderCreateRequest orderCreateRequest) {

		return orderService.save(orderCreateRequest);

	}

	@GetMapping
	public List<OrderResponse> getAllOrders() {

		return orderService.getAllOrders();

	}

	@GetMapping("/{orderId}")
	public OrderResponse getOrderById(@PathVariable long orderId) {

		return orderService.getOrderById(orderId);

	}

	@PutMapping("/{orderId}")
	public OrderResponse updateOrder(@PathVariable long orderId, @RequestBody OrderUpdateRequest orderUpdateRequest) {

		return orderService.update(orderId, orderUpdateRequest);

	}

	@DeleteMapping("/{orderId}")
	public void deleteOrder(@PathVariable long orderId) {

		orderService.delete(orderId);

	}

}
