package com.rk.movie.ticket.booking.system.service.dtos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import com.rk.movie.ticket.booking.system.service.enums.BookingStatus;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingDTO {

	
	private UUID bookingId;
	@NotBlank(message = "userid is mandatory")
	private String userId;
	@NotNull(message="provide movie id")
	@Positive(message="please provide a movie id")
	private Integer movieId;
	
	@NotNull(message="you need to select atleast one seat")
	private List<String> seatsSelected;
	
	@NotNull(message="select the show date")
	private LocalDate showDate;
	
	@NotNull(message="select the show time")
	private LocalTime showTime;
	
	@NotNull(message="booking amount is mandatory")
	@Positive(message="booking amount is mandatory")
	private Double bookingAmount;
	
	private BookingStatus bookingStatus;

}
