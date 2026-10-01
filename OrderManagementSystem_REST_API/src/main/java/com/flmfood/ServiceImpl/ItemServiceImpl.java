package com.flmfood.ServiceImpl;

import com.flmfood.Exception.GlobalExceptionHandler;
import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;

import com.flmfood.Controller.ItemsController;
import com.flmfood.Dto.AddItemRequestDTO;
import com.flmfood.Dto.ItemResponseDTO;
import com.flmfood.Dto.UpdateItemDto;
import com.flmfood.Dto.UpdateRating;
import com.flmfood.Exception.InvalidRatingException;
import com.flmfood.Exception.ItemNotFoundException;
import com.flmfood.Repository.ItemsRepository;
import com.flmfood.Service.ItemService;
import com.flmfood.entity.Items;



@Service
public class ItemServiceImpl implements ItemService {
	
	

	@Autowired
	ItemsRepository itemsRepository;
	
	public final static Logger log = LoggerFactory.getLogger(ItemsController.class);


	@Override
	
	public ItemResponseDTO addItem(AddItemRequestDTO addItemRequestDTO) {
	
		log.trace("Entered to Add Item Menthod in ItemServiceImpl");
		
		
		Items item = new Items();
		Items savedItems = null;
		try {
		log.trace("Started Copying Data to Item Object from AddItemRequestDTO");
		item.setItemName(addItemRequestDTO.getItemName());
		item.setPrice(addItemRequestDTO.getPrice());
		item.setStockQuantity(addItemRequestDTO.getStockQuantity());
		item.setDiscount(addItemRequestDTO.getDiscount());
	//	item.setRating(item.getRating()/0);   // it return Nan
		item.setRating(0);
		
		log.debug("Built Item Objected from ItemRequestDto, Item - {}", item);
		
		savedItems = itemsRepository.save(item);
		}
		catch(Exception e) {
			log.error("Error in the rating : {}" ,e.getMessage());
		}
		log.debug("Saved Item into Item Repository");
		log.info("Saved Items : {}", savedItems);
		
		
		log.trace("Started Converting savedItem to ItemResponseDto");
		ItemResponseDTO responseDTO = new ItemResponseDTO();
		
		BeanUtils.copyProperties(savedItems, responseDTO);
		
		log.info("returning Final Saved ItemResponseDTO -{}", responseDTO);
		log.trace("returning back from AddItem mentod in ItemServiceImpl to ItemController");
		return responseDTO;
		
	}
	
	@Override
	@Cacheable(value = "items")
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
	@Cacheable(value = "items", key = "#id")
	public ItemResponseDTO getItemById(int id) {
	
		Items items = itemsRepository.findById(id)
				                     .orElseThrow(() -> new ItemNotFoundException("Item Not Found with Id :" + id));
		
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
	//this is used only for getItemByID, this will update directly into cache memory , but wont update in getAllItems
	//@CachePut(value = "items", key= "#id") 
	
	//this is used to both getItemByid & getAllItems, because this will clear the Old cache when we update and fetch data from DB when we call again 
	@CacheEvict(value = "items", allEntries = true)
	
	public ItemResponseDTO updateItem(int id, UpdateItemDto updateItemDto) {
		
		Items Item = itemsRepository.findById(id).get();
		
		//                         Source        target
		BeanUtils.copyProperties(updateItemDto, Item);
		
		Items savedItem = itemsRepository.save(Item);
		
		ItemResponseDTO itemResponseDTO = new ItemResponseDTO();
		BeanUtils.copyProperties(savedItem, itemResponseDTO);
		
		return itemResponseDTO;

	}
	
	/* 
	 * JPQL 
	 * 
	 * */

	@Override
	public ItemResponseDTO updateRating(UpdateRating updateRating) {
		

	
		/*  **** This code is written by me without JPQL
		 * 
		 * Items item = itemsRepository.findById(updateRating.getItemId()).get();
		 * 
		 * item.setRating(updateRating.getRating());
		 * 
		 * Items savedItem = itemsRepository.save(item); 
		 * ItemResponseDTO itemResponseDTO = new ItemResponseDTO(); 
		 * BeanUtils.copyProperties(savedItem, itemResponseDTO); return itemResponseDTO;
		 * 
		 */
		ItemResponseDTO itemResponseDTO = new ItemResponseDTO();
		if(updateRating.getRating()>0 && updateRating.getRating()<=5) {
			int rating = itemsRepository.updateRating(updateRating.getItemId(), updateRating.getRating());
			
			Items updatedItem = itemsRepository.findById(updateRating.getItemId())
					.orElseThrow(() -> new ItemNotFoundException("Item Not Found woth mentioned id :" + updateRating.getItemId()));
			BeanUtils.copyProperties(updatedItem, itemResponseDTO);
			
		}else {
			throw new InvalidRatingException("Please Enter the rating Between 0 - 5, you have entered wrong rating :" + updateRating.getRating() );
		}
		 return itemResponseDTO;

		
	}
	
	
	
	

}
