package com.finartz.booking.service.imp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finartz.booking.Util.Util;
import com.finartz.booking.dto.TicketDto;
import com.finartz.booking.model.Flight;
import com.finartz.booking.model.Ticket;
import com.finartz.booking.repository.FlightRepository;
import com.finartz.booking.repository.TicketRepository;
import com.finartz.booking.service.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final FlightRepository flightRepository;
    private static ModelMapper modelMapper = new ModelMapper();

    @Transactional
    @Override
    public TicketDto save(TicketDto ticketDto) {
        UUID uuid = UUID.randomUUID();
        ticketDto.setTicketNumber(uuid.toString());
        Ticket ticket = modelMapper.map(ticketDto, Ticket.class);
        Optional<Flight> flight = flightRepository.findById(ticketDto.getFlightID());
        if(flight!=null){
            ticket.setFlight(flight.get());
        }
        ticket.setTicketPrice(flight.get().getCurrentPrice());
        ticket= ticketRepository.save(ticket);

        flight.get().setCount(flight.get().getCount()+1);
        ticketDto.setTicketPrice(flight.get().getCurrentPrice());
        Double updatedPrice = Util.calculatePrice(flight.get().getCount(),flight.get().getQuota(),flight.get().getBasePrice());
        flight.get().setCurrentPrice(updatedPrice);
        flightRepository.save(flight.get());
        ticketDto.setId(ticket.getId());

        ticketDto.setCardNumber(Util.maskCardNumber(ticketDto.getCardNumber()));
        ticketDto.setId(ticket.getId());
        return ticketDto;
    }


    @Override
    public String delete(String ticketNumber) throws JsonProcessingException {
        Map<String,Object> result = new ObjectMapper().readValue(ticketNumber, HashMap.class);
        Ticket ticket = ticketRepository.findByTicketNumber(result.get("ticketNumber").toString());
        Optional<Flight> flight = flightRepository.findById(ticket.getFlight().getId());
        flight.get().setCount(flight.get().getCount()-1);
        flight.get().setCurrentPrice(Util.calculatePrice(flight.get().getCount(),flight.get().getQuota(),flight.get().getBasePrice()));
        flightRepository.save(flight.get());
        ticketRepository.deleteById(ticket.getId());
        //ticketRepository.deleteByTicketNumber(ticketNumber);
        return ticketNumber;
    }


    @Override
    public List<TicketDto> getAll() {
        List<Ticket> ticketList = ticketRepository.findAll();

        List<TicketDto> ticketDtoList = new ArrayList<>();
        if (ticketList!=null && ticketList.size()>0){
            ticketDtoList = Util.mapAll(ticketList,TicketDto.class);
            ticketDtoList.stream().forEach(item -> item.setCardNumber(Util.maskCardNumber(item.getCardNumber()))
            );
        }
        return ticketDtoList;
    }

    @Override
    public TicketDto findByTicketNumber(Optional<String> ticketNumber) {
        Ticket ticketList = ticketRepository.findByTicketNumber(ticketNumber.orElse("_"));
        TicketDto ticketDto = modelMapper.map(ticketList,TicketDto.class);
        ticketDto.setCardNumber(Util.maskCardNumber(ticketDto.getCardNumber()));
        return ticketDto;
    }

    @Override
    public TicketDto findById(Long id) {
        Ticket ticket = ticketRepository.findById(id).orElse(null);
        TicketDto ticketDto = null;
        if (ticket !=null){
            ticketDto = modelMapper.map(ticket,TicketDto.class);
            ticketDto.setCardNumber(Util.maskCardNumber(ticket.getCardNumber()));
        }
        return ticketDto;
    }
}
