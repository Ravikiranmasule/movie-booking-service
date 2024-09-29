package com.rk.movie.ticket.booking.system.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MovieBookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieBookingServiceApplication.class, args);
	}

}
