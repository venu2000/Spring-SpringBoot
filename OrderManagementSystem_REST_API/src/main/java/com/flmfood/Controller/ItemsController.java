package com.flmfood.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flmfood.Dto.AddItemRequestDTO;

import com.flmfood.Dto.ItemResponseDTO;
import com.flmfood.Dto.UpdateItemDto;
import com.flmfood.Service.ItemService;
import com.flmfood.ServiceImpl.ItemServiceImpl;

@RestController
@RequestMapping("/items")
public class ItemsController {
	
	@Autowired
	ItemServiceImpl itemServiceImpl;
	@Autowired
	ItemService itemService;
	
	@PostMapping("/add") 
	
	//@RequestBody used to convert JSON input to Object input to fields 
	
	public ItemResponseDTO addItem (@RequestBody AddItemRequestDTO addItemRequestDTO) {
		return itemServiceImpl.addItem(addItemRequestDTO);
		
	}
	
	@GetMapping
	public List<ItemResponseDTO> getAllItems(){
		return itemServiceImpl.getAllItems();
		
	}
	
	
	
	@GetMapping("{itemId}")
	public ItemResponseDTO getItemById(@PathVariable int itemId) {
		return itemServiceImpl.getItemById(itemId);
		
	}
	
	/*
	 * @GetMapping("/byDiscount") public List<ItemResponseDTO>
	 * getItemByDiscount(@RequestParam(name = "discount") double discount){ return
	 * itemServiceImpl.getItemByDiscount(discount);
	 * 
	 * }
	 */
	
	// http://localhost:8080/items/byDiscount?discount=30
	// we need all list if we didnt apply discount variables as we see in real time 
	//so we use Required = false 
	//change double to Double 
	
	@GetMapping("/byDiscount")
	public List<ItemResponseDTO> getItemByDiscount(@RequestParam(name = "discount", required = false) Double discount){
		return itemService.getItemByDiscount(discount);
		
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteItemById(@PathVariable int id) {
		return itemService.deleteItemById(id);
		
	}
	
	@PutMapping("/update/{id}")
	public ItemResponseDTO updateItem(@PathVariable int id, @RequestBody UpdateItemDto updateItemDto) {
		return itemService.updateItem(id, updateItemDto);
		
	}
	
	
	
	
	

}
