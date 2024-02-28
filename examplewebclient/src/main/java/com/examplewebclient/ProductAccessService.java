package com.examplewebclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class ProductAccessService {

	@Autowired
	private WebClient webClient;

	public ProductAccess saveProduct(ProductAccess product) {
		ProductAccess productAccessResponse = webClient.post().uri("/createProduct").bodyValue(product)
				.accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(ProductAccess.class).block();
		return productAccessResponse;
	}

	public List<ProductAccess> getAllproducts() {
		List<ProductAccess> allProducts = webClient.get().uri("/allProducts").accept(MediaType.APPLICATION_JSON)
				.retrieve().bodyToFlux(ProductAccess.class).collectList().block();
		return allProducts;
	}

	public Mono<ProductAccess> getProductById(Long productId) {
		Mono<ProductAccess> product = webClient.get().uri("/allProducts/{productId}", productId)
				.accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(ProductAccess.class);
		return product;
	}

	public Mono<Void> deleteById(Long productId) {
		return webClient.delete().uri("/allProducts/{productId}", productId).accept(MediaType.APPLICATION_JSON)
				.retrieve().bodyToMono(Void.class);
	}
	
	public String updateProduct(ProductAccess product) {
	    return webClient.put()
	            .uri("/allProducts")
	            .bodyValue(product)
	            .accept(MediaType.APPLICATION_JSON)
	            .retrieve()
	            .bodyToMono(String.class)
	            .block();
	}

}
