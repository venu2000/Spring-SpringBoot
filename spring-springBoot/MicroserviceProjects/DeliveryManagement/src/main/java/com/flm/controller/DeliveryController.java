package com.flm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flm.delivery.dto.request.DeliveryCreateRequest;
import com.flm.delivery.dto.response.DeliveryResponse;
import com.flm.service.DeliveryService;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
	
	@Autowired
	DeliveryService deliveryService;
	
	@PostMapping
	public DeliveryResponse assignDelivery(@RequestBody DeliveryCreateRequest deliveryCreateRequest) {
		
		return deliveryService.assign(deliveryCreateRequest);
	}
	
	@GetMapping("/{id}")
	public DeliveryResponse findDeliveryById(@PathVariable(name = "id") long id) {
		
		return deliveryService.findById(id);
		
	}
	

}
