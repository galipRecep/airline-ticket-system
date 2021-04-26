package com.finartz.booking.service.service;

import com.finartz.booking.dto.AirCarrierDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AirCarrierService {

    AirCarrierDto save(AirCarrierDto airCarrierDto);

    void delete(Long id);

    List<AirCarrierDto> getAll() ;

    List<AirCarrierDto> findByName(Optional<String> name);

    AirCarrierDto findById(Long id);

}
