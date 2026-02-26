package com.webflux;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class SpringWebFluxApplicationTests {

	@Test
	void testMono() {
		
		Mono<?> just = Mono.just("D1")
		//.then(Mono.error(new RuntimeException("Exception Occued in Mono")))
		.log();

		just.subscribe(x -> System.out.println(x), (w) -> System.out.println(w.getMessage()));
	}

	@Test
	void testFlux() {
		Flux<?> just = Flux.just("D1", "D2", "D3")
				// .concatWith(Flux.error(new RuntimeException("Exception Occued in Mono")))
				.concatWithValues("D5")
				.log();

		just.subscribe(x -> System.out.println(x), (w) -> System.out.println(w.getMessage()));
	}

}
