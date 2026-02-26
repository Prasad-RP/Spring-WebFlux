package com.webflux.dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.webflux.dto.Customer;

import reactor.core.publisher.Flux;

@Component
public class CustomerDao {

	public List<Customer> getAll() {
		return IntStream.rangeClosed(1, 10).peek(i -> System.out.println("Procesing User No : " + i)).peek(i -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).mapToObj(i -> new Customer(i, "Customer" + i)).toList();
	}

	public Flux<Customer> getAllStream() {
		return Flux.range(1, 10)	.delayElements(Duration.ofSeconds(1))
				.doOnNext(i -> System.out.println("Procesing User No : " + i))
				.map(i -> new Customer(i, "Customer" + i));
	}

	public Flux<Customer> getCustomersList() {
		return Flux.range(1, 50).doOnNext(i -> System.out.println("Procesing User No : " + i))
				.map(i -> new Customer(i, "Customer" + i));
	}
}
