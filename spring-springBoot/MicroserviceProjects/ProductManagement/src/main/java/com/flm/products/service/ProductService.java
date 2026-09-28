package com.flm.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flm.products.builder.ProductBuilder;
import com.flm.products.dao.ProductRepository;
import com.flm.products.dto.request.ProductCreateRequest;
import com.flm.products.dto.request.ProductUpdateRequest;
import com.flm.products.dto.response.ProductResponse;
import com.flm.products.model.Product;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public ProductResponse save(ProductCreateRequest productCreateRequest) {

		Product product = ProductBuilder.buildProductFromProductCreateRequest(productCreateRequest);

		Product savedProduct = productRepository.save(product);

		return ProductBuilder.buildProductResponseFromProduct(savedProduct);

	}

	public List<ProductResponse> getAllProducts() {

		return productRepository
			.findAll()
			.stream()
			.map(ProductBuilder::buildProductResponseFromProduct)
			.toList();

	}

	public ProductResponse getProductById(long productId) {

		Product product = productRepository
			.findById(productId)
			.orElseThrow(() -> new RuntimeException("Product not found with id : " + productId));

		return ProductBuilder.buildProductResponseFromProduct(product);

	}

	public ProductResponse update(long productId, ProductUpdateRequest productUpdateRequest) {

		Product existingProduct = productRepository
			.findById(productId)
			.orElseThrow(() -> new RuntimeException("Product not found with id : " + productId));

		Product product = ProductBuilder.buildProductFromProductUpdateRequest(existingProduct, productUpdateRequest);

		Product savedProduct = productRepository.save(product);

		return ProductBuilder.buildProductResponseFromProduct(savedProduct);

	}

	public void delete(long productId) {

		if (!productRepository.existsById(productId)) {
			throw new RuntimeException("Product not found with id : " + productId);
		}

		productRepository.deleteById(productId);

	}

}
