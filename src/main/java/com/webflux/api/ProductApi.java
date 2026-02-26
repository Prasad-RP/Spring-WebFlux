package com.webflux.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webflux.dto.Product;
import com.webflux.service.ProductService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductApi {

	private final ProductService productService;

	@GetMapping
	public Flux<Product> getAll() {
		return productService.getAll();
	}

	@GetMapping("/{id}")
	public Mono<Product> getById(@PathVariable String id) {
		return productService.getById(id);
	}

	@PostMapping
	public Mono<Product> persist(@RequestBody Mono<Product> obj) {
		return productService.save(obj);
	}

	@PutMapping("/update/{id}")
	public Mono<Product> update(@RequestBody Mono<Product> obj, @PathVariable String id) {
		return productService.edit(obj, id);
	}

	@DeleteMapping("/delete/{id}")
	public Mono<Void> delete(@PathVariable String id) {
		return productService.deleteById(id);
	}

}
