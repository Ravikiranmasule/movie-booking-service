package com.rk.movie.ticket.booking.system.service.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO {
	private String errorMessage;
	private BookingDTO bookingDTO; 

}
