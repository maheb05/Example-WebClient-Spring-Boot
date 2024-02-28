package com.examplewebclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ProductAccessController {
	
	@Autowired
	private ProductAccessService productAccessService;
	
	@PostMapping("/saveProduct")
	public ProductAccess saveProduct(@RequestBody ProductAccess product) {
		return productAccessService.saveProduct(product);
	}
	
	@GetMapping("/getAll")
	public List<ProductAccess> getAllProducts(){
		return productAccessService.getAllproducts();
	}
	
	@GetMapping("/getAll/{productId}")
	public Mono<ProductAccess> getProductById(@PathVariable long productId) {
		return productAccessService.getProductById(productId);
	}
	
	@DeleteMapping("/delete/{productId}")
	public Mono<Void> deleteById(@PathVariable long productId){
		return productAccessService.deleteById(productId);
	}
	
	@PutMapping("/update")
	public String updateProduct(@RequestBody ProductAccess productAccess) {
		return productAccessService.updateProduct(productAccess);
	}
}
