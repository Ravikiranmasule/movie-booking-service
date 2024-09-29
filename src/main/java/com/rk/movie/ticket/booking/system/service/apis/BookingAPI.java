package com.rk.movie.ticket.booking.system.service.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.movie.ticket.booking.system.service.dtos.BookingDTO;
import com.rk.movie.ticket.booking.system.service.services.BookingService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/booking")
@Slf4j
public class BookingAPI {
	@Autowired
	BookingService bookingService; 
	
	@PostMapping("/register")
	public ResponseEntity<BookingDTO> createBooking(@Validated @RequestBody BookingDTO bookingDTO) {
		log.info(bookingDTO.toString());
		BookingDTO booking = bookingService.createBooking(bookingDTO);
		return new ResponseEntity<BookingDTO>(booking, HttpStatus.CREATED);
		
	}

}
