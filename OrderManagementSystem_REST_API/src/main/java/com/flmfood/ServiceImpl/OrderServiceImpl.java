package com.flmfood.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.flmfood.Dto.OrderItemRequestDTO;
import com.flmfood.Dto.OrderItemResponseDTO;
import com.flmfood.Dto.OrderResponseDTO;
import com.flmfood.Dto.PlaceOrderRequestDTO;
import com.flmfood.Repository.ItemsRepository;
import com.flmfood.Repository.OrderRepository;
import com.flmfood.Service.OrderService;
import com.flmfood.entity.Items;
import com.flmfood.entity.Order;
import com.flmfood.entity.OrderItems;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	ItemsRepository itemsRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	
	
	double finalOrderPrice = 0;
	List<OrderItems> orderItemList = new ArrayList<OrderItems>();
	Order order = new Order();		
	
	public OrderResponseDTO placeOrder (PlaceOrderRequestDTO orderRequestDTO) {
		
		// converting input list to Item by Item
		List<OrderItemRequestDTO> orderItemRequestList = orderRequestDTO.getOrderItemRequestList();
		
		for(OrderItemRequestDTO orderItemDto : orderItemRequestList) {
			
			Items items = itemsRepository.findById(orderItemDto.getItemId()).get();
			

			//Validating Stock Quanity 
			// when we order the quantity should be deducted in Actual Item 
			
			int remainingStock = items.getStockQuantity() - orderItemDto.getQuantity();
			
			items.setStockQuantity(remainingStock);
			itemsRepository.save(items);
			
			OrderItems orderItems = new OrderItems();
					
					
			orderItems.setItems(items);
			orderItems.setQuantity(orderItemDto.getQuantity());
			double itemPrice =items.getPrice() * orderItemDto.getQuantity();

			orderItems.setPrice(itemPrice);

			finalOrderPrice += itemPrice;
			orderItems.setOrder(order);
			
		   orderItemList.add(orderItems);
			

		}
		
		
		order.setOrderItems(orderItemList);
		order.setPrice(finalOrderPrice);
		
		
		Order savedOrder = orderRepository.save(order);
		
		OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
		List<OrderItemResponseDTO> orderItemResponseList = new ArrayList<OrderItemResponseDTO>();
		
		List<OrderItems> orderItems = savedOrder.getOrderItems();
		
		for(OrderItems orderItem : orderItems) {
			
			
			
			OrderItemResponseDTO orderItemResponseDTO = new OrderItemResponseDTO();
			
			orderItemResponseDTO.setItemName(orderItem.getItems().getItemName());
			orderItemResponseDTO.setQuantity(orderItem.getQuantity());
			orderItemResponseDTO.setPrice(orderItem.getItems().getPrice());
			orderItemResponseDTO.setSubTotal(orderItem.getPrice());
			orderItemResponseList.add(orderItemResponseDTO);
		
		}
		
		orderResponseDTO.setOrderId(order.getOrderId());
		orderResponseDTO.setOrderItemResponseDTO(orderItemResponseList);
		orderResponseDTO.setTotalPrice(order.getPrice());
		
		
		return orderResponseDTO;
		
		
		
		
		
		
	}

	@Override
	public List<OrderResponseDTO> getAllOrder() {
		
		
		List<Order> orders = orderRepository.findAll();
		
		List<OrderResponseDTO> orderResponseList = new ArrayList<>();
		
		
		for(Order order : orders) {
			
			OrderResponseDTO orderResponseDto = new OrderResponseDTO();
			orderResponseDto.setOrderId(order.getOrderId());
			orderResponseDto.setTotalPrice(order.getPrice());
			
			List<OrderItemResponseDTO> orderItemResponseList = new ArrayList<>();
			
			for(OrderItems orderItem: order.getOrderItems()) {
				
				OrderItemResponseDTO orderItemResponseDTO = new OrderItemResponseDTO();
				
		 		orderItemResponseDTO.setItemName(orderItem.getItems().getItemName());
				orderItemResponseDTO.setPrice(orderItem.getItems().getPrice());
				orderItemResponseDTO.setQuantity(orderItem.getQuantity());
				orderItemResponseDTO.setSubTotal(orderItem.getPrice());
				
				orderItemResponseList.add(orderItemResponseDTO);
				
				
			}
			
			
			orderResponseDto.setOrderItemResponseDTO(orderItemResponseList);
			
			orderResponseList.add(orderResponseDto);
			
		}
		
		return orderResponseList;
		
		
		
		
		
		
		
		
			}

	@Override
	public String cancelOrder(int id) {
		
		
		 orderRepository.deleteById(id);
		 return "Order : " +id+" DELETED successfully" ;
		
		
		
		
		
		
	}

}
