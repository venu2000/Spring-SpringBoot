package com.flmfood.ServiceImpl;

import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flmfood.Dto.AddItemRequestDTO;
import com.flmfood.Dto.ItemResponseDTO;
import com.flmfood.Dto.UpdateItemDto;
import com.flmfood.Repository.ItemsRepository;
import com.flmfood.Service.ItemService;
import com.flmfood.entity.Items;



@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemsRepository itemsRepository;

	@Override
	public ItemResponseDTO addItem(AddItemRequestDTO addItemRequestDTO) {
		
		Items item = new Items();
		item.setItemName(addItemRequestDTO.getItemName());
		item.setPrice(addItemRequestDTO.getPrice());
		item.setStockQuantity(addItemRequestDTO.getStockQuantity());
		item.setDiscount(addItemRequestDTO.getDiscount());
		item.setRating(0);
		
		
		Items saveItems = itemsRepository.save(item);
		
		ItemResponseDTO responseDTO = new ItemResponseDTO();
		
		BeanUtils.copyProperties(saveItems, responseDTO);
		
		return responseDTO;
		
	}
	
	@Override
	public List<ItemResponseDTO> getAllItems(){
		
		List<Items> allItems = itemsRepository.findAll();
		
		List<ItemResponseDTO> itemResponseDTOs = new ArrayList<ItemResponseDTO>();
		
		List<ItemResponseDTO> list = allItems.stream()
		.map(item->{
			ItemResponseDTO dto = new ItemResponseDTO();
			BeanUtils.copyProperties(item, dto);
			return dto;
			
		})
		.toList();
		return list;
		
	}

	@Override
	public ItemResponseDTO getItemById(int id) {
	
		Items items = itemsRepository.findById(id).get();
		
		ItemResponseDTO dto = new ItemResponseDTO();
		BeanUtils.copyProperties(items, dto);
		
		return dto;
	}

	@Override
	public List<ItemResponseDTO> getItemByDiscount(Double discount) {
		
		List<Items> allItems = itemsRepository.findAll();
		
		
		if(discount == null) {
			
			return	allItems.stream()
					.map(item->{
						ItemResponseDTO dto = new ItemResponseDTO();
						BeanUtils.copyProperties(item, dto);
						return dto;
						
					})
					.toList();
		}
		
		List<ItemResponseDTO> dtoList = allItems.stream()
		.filter(item -> item.getDiscount() > discount)
		.map(item -> {
			ItemResponseDTO dto = new ItemResponseDTO();
			BeanUtils.copyProperties(item, dto);
			return dto;
		})
		.toList();
		
		
		return dtoList;
	}

	
	
	@Override
	public String deleteItemById(int id) {
		
		itemsRepository.deleteById(id);
		return "Item DELETED with ID : " + id;
	}

	@Override
	public ItemResponseDTO updateItem(int id, UpdateItemDto updateItemDto) {
		
		Items Item = itemsRepository.findById(id).get();
		
		//                         Source        target
		BeanUtils.copyProperties(updateItemDto, Item);
		
		Items savedItem = itemsRepository.save(Item);
		
		ItemResponseDTO itemResponseDTO = new ItemResponseDTO();
		BeanUtils.copyProperties(savedItem, itemResponseDTO);
		
		return itemResponseDTO;

	}
	
	
	
	

}
