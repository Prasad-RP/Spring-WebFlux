package com.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.webflux.entity.ProductMaster;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<ProductMaster, String> {

}
