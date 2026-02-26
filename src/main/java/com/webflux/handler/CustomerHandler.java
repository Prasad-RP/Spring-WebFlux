package com.webflux.handler;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.webflux.dao.CustomerDao;
import com.webflux.dto.Customer;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerHandler {

	private final CustomerDao customerDao;

	public Mono<ServerResponse> loadCustomers(ServerRequest serverRequest) {
		Flux<Customer> customersList = customerDao.getCustomersList();
		return ServerResponse.ok().body(customersList, Customer.class);
	}

	public Mono<ServerResponse> findCustomers(ServerRequest serverRequest) {
		int id = Integer.parseInt(serverRequest.pathVariable("input"));
		Mono<Customer> obj = customerDao.getCustomersList().filter(x -> x.getId() == id).next();
		return ServerResponse.ok().body(obj, Customer.class);
	}

	public Mono<ServerResponse> saveCustomers(ServerRequest serverRequest) {
		Mono<Customer> bodyToMono = serverRequest.bodyToMono(Customer.class);
		System.out.println("procssing body...");
		return ServerResponse.ok().body(bodyToMono, Customer.class);
	}

}
