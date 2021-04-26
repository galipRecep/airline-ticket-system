package com.finartz.booking.service.service;

import com.finartz.booking.dto.AirportDto;
import com.finartz.booking.model.Airport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AirportService {

    AirportDto save(AirportDto airportDto);

    void delete(Long id);

    List<AirportDto> getAll() ;

    List<AirportDto> findByName(String name);

    AirportDto findById(Long id);

}
