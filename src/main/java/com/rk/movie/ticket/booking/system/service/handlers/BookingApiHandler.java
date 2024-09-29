package com.rk.movie.ticket.booking.system.service.handlers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rk.movie.ticket.booking.system.service.dtos.ResponseDTO;
import com.rk.movie.ticket.booking.system.service.dtos.ResponseDTO.ResponseDTOBuilder;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class BookingApiHandler {
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
	
 		List<ObjectError> allErrors = exception.getBindingResult().getAllErrors();
		log.error(allErrors.toString());
		List<String> allerrorMsg=new ArrayList<>();
		for (ObjectError objectError : allErrors) {
			allerrorMsg.add(objectError.getDefaultMessage());
			
		}
		 ResponseDTO responseDTO = ResponseDTO.builder()
				.errorMessage(allerrorMsg.toString()).build();
		 return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	
		
	}
}
