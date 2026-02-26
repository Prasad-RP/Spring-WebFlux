package com.webflux.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.webflux.dao.CustomerDao;
import com.webflux.dto.Customer;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class CustomerService {

	private final CustomerDao customerDao;

	public List<Customer> loadAllCustomers() {

		long start = System.currentTimeMillis();
		List<Customer> list = customerDao.getAll();
		long end = System.currentTimeMillis();
		System.out.println("Total Execution Time  : " + (end - start));
		return list;

	}

	public Flux<Customer> loadAllCustomersStream() {

		long start = System.currentTimeMillis();
		Flux<Customer> flux = customerDao.getAllStream();
		long end = System.currentTimeMillis();
		System.out.println("Total Execution Time  : " + (end - start));
		return flux;

	}
}
