package com.webflux.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductMaster {

	@Id
	private String id;
	
	private String name;
	
	private int qty;
	
	private double price;
	
}
