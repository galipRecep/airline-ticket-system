package com.finartz.booking.service.service;

import com.finartz.booking.dto.FlightDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface FlightService {

    FlightDto save(FlightDto flightDto);

    void delete(Long id);

    List<FlightDto> getAll() ;

    List<FlightDto> findByName(Optional<String> name);

    List<FlightDto> findByCode(Optional<String> code);

    FlightDto findById(Long flightId);

    Double getTicketPriceByFlightId(Long flightId);

}
