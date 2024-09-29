package com.rk.movie.ticket.booking.system.service.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rk.movie.ticket.booking.system.service.entities.BookingEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, UUID> {

}
