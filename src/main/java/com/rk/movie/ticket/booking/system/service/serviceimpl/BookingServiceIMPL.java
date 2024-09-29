package com.rk.movie.ticket.booking.system.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.movie.ticket.booking.system.service.brokers.PaymentServiceBroker;
import com.rk.movie.ticket.booking.system.service.dtos.BookingDTO;
import com.rk.movie.ticket.booking.system.service.entities.BookingEntity;
import com.rk.movie.ticket.booking.system.service.enums.BookingStatus;
import com.rk.movie.ticket.booking.system.service.repositories.BookingRepository;
import com.rk.movie.ticket.booking.system.service.services.BookingService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class BookingServiceIMPL implements BookingService {

	@Autowired
	BookingRepository bookingRepository;
	@Autowired
	PaymentServiceBroker paymentServiceBroker;
	@Override
	public BookingDTO createBooking(BookingDTO bookingDTO) {
		//BookingEntity entity=new BookingEntity();
//		entity.setUserId(bookingDTO.getUserId());
//		entity.setMovieId(bookingDTO.getMovieId());
//		entity.setBookingStatus(BookingStatus.PENDING);
//		entity.setSeatsSelected(bookingDTO.getSeatsSelected());
//		entity.setShowDate(bookingDTO.getShowDate());
//		entity.setShowTime(bookingDTO.getShowTime());
//		entity.setBookingAmount(bookingDTO.getBookingAmount());
//		
		BookingEntity entity=BookingEntity.builder()
		.userId(bookingDTO.getUserId())
		.movieId(bookingDTO.getMovieId())
		.bookingStatus(BookingStatus.PENDING)
		.seatsSelected(bookingDTO.getSeatsSelected())
		.showDate(bookingDTO.getShowDate())
		.showTime(bookingDTO.getShowTime())
		.bookingAmount(bookingDTO.getBookingAmount())
		.build();
		bookingRepository.save(entity);
		String paymentResponse=paymentServiceBroker.getPayment();
		log.info(paymentResponse);
		return BookingDTO.builder()
				.bookingId(entity.getBookingId())
		.userId(entity.getUserId())
		.movieId(entity.getMovieId())
		.bookingStatus(entity.getBookingStatus())
		.seatsSelected(entity.getSeatsSelected())
		.showDate(entity.getShowDate())
		.showTime(entity.getShowTime())
		.bookingAmount(entity.getBookingAmount())
		.build();
	
		
	}

}
