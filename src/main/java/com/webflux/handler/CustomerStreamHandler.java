package com.webflux.handler;

import org.springframework.http.MediaType;
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
public class CustomerStreamHandler {

	private final CustomerDao customerDao;

	public Mono<ServerResponse> getCustomersStream(ServerRequest serverRequest) {
		Flux<Customer> customersList = customerDao.getAllStream();
		return ServerResponse.ok()
				.contentType(MediaType.TEXT_EVENT_STREAM)
				.body(customersList, Customer.class);
	}
}
