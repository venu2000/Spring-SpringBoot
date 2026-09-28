package com.flm.builder;

import com.flm.delivery.dto.request.DeliveryCreateRequest;
import com.flm.delivery.dto.response.DeliveryResponse;
import com.flm.delivery.model.Delivery;

public class DeliveryBuilder {
	
	
	public static Delivery buildDeliveryFromDeliveryDto(DeliveryCreateRequest deliveryCreateRequest) {
		
		return Delivery
			.builder()
			.orderId(deliveryCreateRequest.getOrderId())
			.trackingNumber(deliveryCreateRequest.getTrackingNumber())
			.shippingAddress(deliveryCreateRequest.getShippingAddress())
			.estimatedDeliveryDate(deliveryCreateRequest.getEstimatedDeliveryDate())
			.status(deliveryCreateRequest.getStatus())
			.build();
		
	}
	
	public static DeliveryResponse buildDeliveryDtoFromDelivery(Delivery delivery) {
		
		return DeliveryResponse
			.builder()
			.deliveryId(delivery.getDeliveryId())
			.orderId(delivery.getOrderId())
			.trackingNumber(delivery.getTrackingNumber())
			.shippingAddress(delivery.getShippingAddress())
			.estimatedDeliveryDate(delivery.getEstimatedDeliveryDate())
			.actualDeliveryDate(delivery.getActualDeliveryDate())
			.status(delivery.getStatus())
			.build();
		
		
	}

}
