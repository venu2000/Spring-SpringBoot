package com.flmfood.Service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.flmfood.Dto.AddItemRequestDTO;
import com.flmfood.Dto.ItemResponseDTO;
import com.flmfood.Dto.UpdateItemDto;

public interface ItemService {
	
	
	public ItemResponseDTO addItem (AddItemRequestDTO addItemRequestDTO);

	public List<ItemResponseDTO> getAllItems();
	
	public ItemResponseDTO getItemById(int id);
	
	public List<ItemResponseDTO> getItemByDiscount(Double discount);
	
	public String deleteItemById(int id);
	
	public ItemResponseDTO updateItem(int id, UpdateItemDto updateItemDto);
}

