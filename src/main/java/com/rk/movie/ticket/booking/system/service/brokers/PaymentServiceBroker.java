package com.rk.movie.ticket.booking.system.service.brokers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="movie-payment-service",url="http://localhost:9091/payments")
public interface PaymentServiceBroker {
	@GetMapping
	public String getPayment() ;


}
