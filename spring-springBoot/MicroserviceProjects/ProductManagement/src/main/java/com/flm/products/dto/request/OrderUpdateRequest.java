package com.flm.products.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderUpdateRequest {

	private long userId;
	private double totalPrice;
	private String status;
	private List<OrderItemUpdateRequest> orderItems;

}
