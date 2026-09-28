package com.flm.products.builder;

import com.flm.products.dto.request.ProductCreateRequest;
import com.flm.products.dto.request.ProductUpdateRequest;
import com.flm.products.dto.response.ProductResponse;
import com.flm.products.model.Product;

public class ProductBuilder {

	public static Product buildProductFromProductCreateRequest(ProductCreateRequest productCreateRequest) {

		return Product
			.builder()
			.productName(productCreateRequest.getProductName())
			.description(productCreateRequest.getDescription())
			.brand(productCreateRequest.getBrand())
			.price(productCreateRequest.getPrice())
			.rating(productCreateRequest.getRating())
			.build();
	}

	public static Product buildProductFromProductUpdateRequest(Product existingProduct, ProductUpdateRequest productUpdateRequest) {

		return Product
			.builder()
			.productId(existingProduct.getProductId())
			.productName(productUpdateRequest.getProductName())
			.description(productUpdateRequest.getDescription())
			.brand(productUpdateRequest.getBrand())
			.price(productUpdateRequest.getPrice())
			.rating(productUpdateRequest.getRating())
			.build();
	}

	public static ProductResponse buildProductResponseFromProduct(Product product) {

		return ProductResponse
			.builder()
			.productId(product.getProductId())
			.productName(product.getProductName())
			.description(product.getDescription())
			.brand(product.getBrand())
			.price(product.getPrice())
			.rating(product.getRating())
			.build();
	}

}
