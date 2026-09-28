package com.flm.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flm.inventory.dto.request.InventoryCreateRequest;
import com.flm.inventory.dto.request.InventoryUpdateRequest;
import com.flm.inventory.dto.response.InventoryResponse;
import com.flm.inventory.service.InventoryService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/inventories")
public class InventoryController {

	@Autowired
	InventoryService inventoryService;

	@PostMapping
	public InventoryResponse saveInventory(@RequestBody InventoryCreateRequest inventoryCreateRequest) {

		return inventoryService.save(inventoryCreateRequest);

	}

	@GetMapping
	public List<InventoryResponse> getAllInventories() {

		return inventoryService.getAllInventories();

	}

	@GetMapping("/{inventoryId}")
	public InventoryResponse getInventoryById(@PathVariable long inventoryId) {

		return inventoryService.getInventoryById(inventoryId);

	}

	@PutMapping("/{inventoryId}")
	public InventoryResponse updateInventory(@PathVariable long inventoryId, @RequestBody InventoryUpdateRequest inventoryUpdateRequest) {

		return inventoryService.update(inventoryId, inventoryUpdateRequest);

	}

	@DeleteMapping("/{inventoryId}")
	public void deleteInventory(@PathVariable long inventoryId) {

		inventoryService.delete(inventoryId);

	}

}
