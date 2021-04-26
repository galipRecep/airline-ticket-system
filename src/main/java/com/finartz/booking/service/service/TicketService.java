package com.finartz.booking.service.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.finartz.booking.dto.TicketDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TicketService {

    TicketDto save(TicketDto ticketDto);

    String delete(String ticketNumber) throws JsonProcessingException;

    List<TicketDto> getAll() ;

    TicketDto findByTicketNumber(Optional<String> name);

    TicketDto findById(Long id);
}
