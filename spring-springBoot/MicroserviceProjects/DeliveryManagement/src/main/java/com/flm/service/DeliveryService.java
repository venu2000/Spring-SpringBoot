package com.flm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flm.builder.DeliveryBuilder;
import com.flm.dao.DeliveryRepository;
import com.flm.delivery.dto.request.DeliveryCreateRequest;
import com.flm.delivery.dto.response.DeliveryResponse;
import com.flm.delivery.model.Delivery;

@Service
public class DeliveryService {
	
	@Autowired
	DeliveryRepository deliveryRepository;
	
	public DeliveryResponse assign(DeliveryCreateRequest deliveryCreateRequest) {
		
		Delivery delivery = DeliveryBuilder.buildDeliveryFromDeliveryDto(deliveryCreateRequest);
		
		deliveryRepository.save(delivery);
		
		DeliveryResponse deliveryResponse = DeliveryBuilder.buildDeliveryDtoFromDelivery(delivery);
		
		return deliveryResponse;
		
	}

	public DeliveryResponse findById(long id) {
		 Delivery delivery = deliveryRepository.findById(id).get();
		 
		return DeliveryBuilder.buildDeliveryDtoFromDelivery(delivery);
	}

}
