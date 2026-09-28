package com.flm.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flm.inventory.builder.InventoryBuilder;
import com.flm.inventory.dao.InventoryRepository;
import com.flm.inventory.dto.request.InventoryCreateRequest;
import com.flm.inventory.dto.request.InventoryUpdateRequest;
import com.flm.inventory.dto.response.InventoryResponse;
import com.flm.inventory.model.Inventory;

@Service
public class InventoryService {

	@Autowired
	InventoryRepository inventoryRepository;

	public InventoryResponse save(InventoryCreateRequest inventoryCreateRequest) {

		Inventory inventory = InventoryBuilder.buildInventoryFromInventoryCreateRequest(inventoryCreateRequest);

		Inventory savedInventory = inventoryRepository.save(inventory);

		return InventoryBuilder.buildInventoryResponseFromInventory(savedInventory);

	}

	public List<InventoryResponse> getAllInventories() {

		return inventoryRepository
			.findAll()
			.stream()
			.map(InventoryBuilder::buildInventoryResponseFromInventory)
			.toList();

	}

	public InventoryResponse getInventoryById(long inventoryId) {

		Inventory inventory = inventoryRepository
			.findById(inventoryId)
			.orElseThrow(() -> new RuntimeException("Inventory not found with id : " + inventoryId));

		return InventoryBuilder.buildInventoryResponseFromInventory(inventory);

	}

	public InventoryResponse update(long inventoryId, InventoryUpdateRequest inventoryUpdateRequest) {

		Inventory existingInventory = inventoryRepository
			.findById(inventoryId)
			.orElseThrow(() -> new RuntimeException("Inventory not found with id : " + inventoryId));

		Inventory inventory = InventoryBuilder.buildInventoryFromInventoryUpdateRequest(existingInventory, inventoryUpdateRequest);

		Inventory savedInventory = inventoryRepository.save(inventory);

		return InventoryBuilder.buildInventoryResponseFromInventory(savedInventory);

	}

	public void delete(long inventoryId) {

		if (!inventoryRepository.existsById(inventoryId)) {
			throw new RuntimeException("Inventory not found with id : " + inventoryId);
		}

		inventoryRepository.deleteById(inventoryId);

	}

}
