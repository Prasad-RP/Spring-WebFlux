package com.webflux.service;

import org.springframework.stereotype.Service;

import com.webflux.dto.Product;
import com.webflux.repository.ProductRepository;
import com.webflux.utils.AppUtils;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository repository;

	public Flux<Product> getAll() {
		return repository.findAll().map(AppUtils::entityToDto);
	}

	public Mono<Product> getById(String id) {
		return repository.findById(id).map(AppUtils::entityToDto);
	}

	public Mono<Product> save(Mono<Product> dto) {
		return dto.map(AppUtils::dtoToEntity).flatMap(repository::insert).map(AppUtils::entityToDto);
	}

	public Mono<Product> edit(Mono<Product> dto, String id) {
		return repository.findById(id).flatMap(p -> dto.map(AppUtils::dtoToEntity)).doOnNext(e -> e.setId(id))
				.map(AppUtils::entityToDto);
	}

	public Mono<Void> deleteById(String id) {
		return repository.deleteById(id);
	}

}
