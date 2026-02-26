package com.webflux.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webflux.dto.Customer;
import com.webflux.service.CustomerService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerApi {

	private final CustomerService customerService;

	@GetMapping
	public List<Customer> getCustomers() {
		return customerService.loadAllCustomers();
	}

	@GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Customer> getCustomersViaStream() {
		return customerService.loadAllCustomersStream();
	}
}
