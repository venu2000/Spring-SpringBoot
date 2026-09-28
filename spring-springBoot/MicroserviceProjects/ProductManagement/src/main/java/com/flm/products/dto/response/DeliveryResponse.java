package com.flm.products.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryResponse {

	private long deliveryId;
	private long orderId;
	private String trackingNumber;
	private String shippingAddress;
	private LocalDate estimatedDeliveryDate;
	private LocalDate actualDeliveryDate;
	private String status;

}
