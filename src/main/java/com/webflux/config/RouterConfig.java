package com.webflux.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.webflux.handler.CustomerHandler;
import com.webflux.handler.CustomerStreamHandler;

@Configuration
public class RouterConfig {

	@Autowired
	private CustomerHandler customerHandler;

	@Autowired
	private CustomerStreamHandler streamHandler;

	@Bean
	public RouterFunction<ServerResponse> routerFunction() {
		return RouterFunctions.route().GET("/router/customers", customerHandler::loadCustomers)
				.GET("/router/customers/stream", streamHandler::getCustomersStream)
				.GET("/router/customers/{input}", customerHandler::findCustomers)
				.POST("/router/customers/save", customerHandler::saveCustomers)
				.build();
	}

}
