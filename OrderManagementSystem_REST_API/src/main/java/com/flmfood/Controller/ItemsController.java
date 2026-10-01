package com.flmfood.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
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
import com.flmfood.Dto.UpdateRating;
import com.flmfood.Service.ItemService;
import com.flmfood.ServiceImpl.ItemServiceImpl;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;

@RestController
@RequestMapping("/items")
public class ItemsController {
	

	@Autowired
	ItemService itemService;
	
	
	
	public final static Logger log = LoggerFactory.getLogger(ItemsController.class);
	
	@PostMapping("/add") 
	
	//@RequestBody used to convert JSON input to Object input to fields 
	
	//public ItemResponseDTO addItem (@RequestBody AddItemRequestDTO addItemRequestDTO) {
	public ResponseEntity<ItemResponseDTO> addItem(
	        @RequestBody AddItemRequestDTO addItemRequestDTO) {
		
		
		log.trace("Client Request received in Add Item of Item Controller");
		log.debug("Received ItemRequestDTO,{}", addItemRequestDTO);
		log.trace("Calling Service from Item Controller");
		
	    ItemResponseDTO itemresponseDto = itemService.addItem(addItemRequestDTO);
	    
	    log.trace("Received data from Item Service");
	    log.trace("Sending response for add item from Item Controller to Client");
	    log.info("Returning ItemResponseDTO,{} from itemController",itemresponseDto);
	    
	    return new ResponseEntity<>(itemresponseDto, HttpStatus.CREATED);
	}
	

	
	
	@Timed(value = "items.get.time")
	@Counted(value = "items.get.count")
	@GetMapping
	public  ResponseEntity<List<ItemResponseDTO>> getAllItems(){
		List<ItemResponseDTO> allItems = itemService.getAllItems();
		/* 
		 * return new ResponseEntity<>(allItems, HttpStatus.OK); 
		 * *
		 * Or we have a one and only default for OK in ResponseEntity
		 * */
		return ResponseEntity.ok(allItems);
	}

	
	
	@GetMapping("{itemId}")
	public ItemResponseDTO getItemById(@PathVariable int itemId) {
		return itemService.getItemById(itemId);
		
	}
	
	/*
	 * @GetMapping("/byDiscount") 
	 * public List<ItemResponseDTO> getItemByDiscount(@RequestParam(name = "discount") double discount){ return
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
	public ResponseEntity<String> deleteItemById(@PathVariable int id) {
		String deleteItemById = itemService.deleteItemById(id);
		return new ResponseEntity<>(deleteItemById, HttpStatus.NO_CONTENT);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ItemResponseDTO> updateItem(@PathVariable int id, @RequestBody UpdateItemDto updateItemDto) {
		ItemResponseDTO updateItem = itemService.updateItem(id, updateItemDto);
		return new ResponseEntity<>(updateItem, HttpStatus.OK);
		
	}
	
	@PutMapping("/rating")
	public ItemResponseDTO updateRating(@RequestBody UpdateRating updateRating) {
		return itemService.updateRating(updateRating);
	}
	
	
	
	
	

}
