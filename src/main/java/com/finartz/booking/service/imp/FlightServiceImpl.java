package com.finartz.booking.service.imp;

import com.finartz.booking.Util.Util;
import com.finartz.booking.dto.FlightDto;
import com.finartz.booking.model.AirCarrier;
import com.finartz.booking.model.Flight;
import com.finartz.booking.model.Route;
import com.finartz.booking.repository.AirCarrierRepository;
import com.finartz.booking.repository.FlightRepository;
import com.finartz.booking.repository.RouteRepository;
import com.finartz.booking.service.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final AirCarrierRepository airCarrierRepository;
    private final RouteRepository routeRepository;
    private static ModelMapper modelMapper = new ModelMapper();

    @Override
    public FlightDto save(FlightDto flightDto) {
        Flight flight = modelMapper.map(flightDto, Flight.class);
        Optional<Route> route = routeRepository.findById(flightDto.getRouteId());
        Optional<AirCarrier> airCarrier = airCarrierRepository.findById(flightDto.getAirCarrierId());
        if(route!=null && airCarrier!=null){
            flight.setAirCarrier(airCarrier.get());
            flight.setRoute(route.get());
        }
        flight= flightRepository.save(flight);
        flightDto.setId(flight.getId());
        return flightDto;
    }

    @Override
    public void delete(Long id) {
        flightRepository.deleteById(id);
    }

    @Override
    public List<FlightDto> getAll() {
        List<Flight> flightList = flightRepository.findAll();
        List<FlightDto> flightDtoList = new ArrayList<>();
        if (flightList!=null && flightList.size()>0){
            flightDtoList = Util.mapAll(flightList,FlightDto.class);
        }
        return flightDtoList;
    }

    @Override
    public List<FlightDto> findByName(Optional<String> name) {
        name.toString().toLowerCase();
        List<Flight> flightList = flightRepository.findByName(name.orElse("_"));
        List<FlightDto> flightDtoList = Util.mapAll(flightList,FlightDto.class);
        return flightDtoList;
    }

    @Override
    public List<FlightDto> findByCode(Optional<String> code) {
        List<Flight> flightList = flightRepository.findByName(code.orElse("_"));
        List<FlightDto> flightDtoList = Util.mapAll(flightList,FlightDto.class);
        return flightDtoList;
    }

    @Override
    public FlightDto findById(Long flightId) {
        Flight flight = flightRepository.findById(flightId).orElse(null);
        FlightDto flightDto = null;
        if (flight!=null){
            flightDto = modelMapper.map(flight,FlightDto.class);
        }
        return flightDto;
    }

    @Override
    public Double getTicketPriceByFlightId(Long flightId) {
        return null;
    }
}
