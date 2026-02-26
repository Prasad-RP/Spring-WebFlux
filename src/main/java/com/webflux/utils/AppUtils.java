package com.webflux.utils;

import org.springframework.beans.BeanUtils;

import com.webflux.dto.Product;
import com.webflux.entity.ProductMaster;

public class AppUtils {

	private AppUtils() {
	}

	public static Product entityToDto(ProductMaster master) {
		Product product = new Product();
		BeanUtils.copyProperties(master, product);
		return product;
	}

	public static ProductMaster dtoToEntity(Product dto) {
		ProductMaster product = new ProductMaster();
		BeanUtils.copyProperties(dto, product);
		return product;
	}

}
