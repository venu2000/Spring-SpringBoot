package com.flm.products.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.flm.products.builder.OrderBuilder;
import com.flm.products.dao.OrderRepository;
import com.flm.products.dto.request.DeliveryCreateRequest;
import com.flm.products.dto.request.OrderCreateRequest;
import com.flm.products.dto.request.OrderUpdateRequest;
import com.flm.products.dto.response.DeliveryResponse;
import com.flm.products.dto.response.OrderResponse;
import com.flm.products.dto.response.UserResponse;
import com.flm.products.model.Order;
import com.flm.products.model.OrderItem;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	RestTemplate restTemplate;

	public OrderResponse save(OrderCreateRequest orderCreateRequest) {

		Order order = OrderBuilder.buildOrderFromOrderCreateRequest(orderCreateRequest);

		Order savedOrder = orderRepository.save(order);
		
		String trackingNumber = UUID.randomUUID().toString();
		
		DeliveryCreateRequest deliveryCreateRequest = DeliveryCreateRequest
			.builder()
			.orderId(savedOrder.getOrderId())
			.shippingAddress("Hyderabad")
			.estimatedDeliveryDate(LocalDate.now().plusDays(7))
			.status("PLACED")
			.trackingNumber(trackingNumber)
			.build();
		
		DeliveryResponse deliveryResponse = restTemplate.postForObject("http://localhost:8084/deliveries", 
				deliveryCreateRequest, DeliveryResponse.class);
		

		return OrderBuilder.buildOrderResponseFromOrder(savedOrder);

	}

	public List<OrderResponse> getAllOrders() {

		return orderRepository
			.findAll()
			.stream()
			.map(OrderBuilder::buildOrderResponseFromOrder)
			.toList();

	}

	public OrderResponse getOrderById(long orderId) {

		Order order = orderRepository
			.findById(orderId)
			.orElseThrow(() -> new RuntimeException("Order not found with id : " + orderId));

		OrderResponse orderResponseFromOrder = OrderBuilder.buildOrderResponseFromOrder(order);
		
		UserResponse userResponse = restTemplate.getForObject("http://UserManagement/users/"+ orderResponseFromOrder.getUserId() , UserResponse.class);
		orderResponseFromOrder.setName(userResponse.getUserName());
		return orderResponseFromOrder;
		
	}

	public OrderResponse update(long orderId, OrderUpdateRequest orderUpdateRequest) {

		Order existingOrder = orderRepository
			.findById(orderId)
			.orElseThrow(() -> new RuntimeException("Order not found with id : " + orderId));

		existingOrder.setUserId(orderUpdateRequest.getUserId());
		existingOrder.setStatus(orderUpdateRequest.getStatus());

		List<OrderItem> updatedItems = orderUpdateRequest
			.getOrderItems()
			.stream()
			.map(OrderBuilder::buildOrderItemFromOrderItemUpdateRequest)
			.toList();

		existingOrder.getOrderItems().clear();
		existingOrder.getOrderItems().addAll(updatedItems);

		OrderBuilder.linkOrderItems(existingOrder);

		existingOrder.setTotalPrice(OrderBuilder.calculateTotalPrice(existingOrder.getOrderItems()));

		Order savedOrder = orderRepository.save(existingOrder);

		return OrderBuilder.buildOrderResponseFromOrder(savedOrder);

	}

	public void delete(long orderId) {

		if (!orderRepository.existsById(orderId)) {
			throw new RuntimeException("Order not found with id : " + orderId);
		}

		orderRepository.deleteById(orderId);

	}

}
