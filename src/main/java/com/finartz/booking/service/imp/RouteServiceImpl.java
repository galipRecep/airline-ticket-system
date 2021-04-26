package com.finartz.booking.service.imp;

import com.finartz.booking.Util.Util;
import com.finartz.booking.dto.RouteDto;
import com.finartz.booking.model.Airport;
import com.finartz.booking.model.Route;
import com.finartz.booking.repository.AirportRepository;
import com.finartz.booking.repository.RouteRepository;
import com.finartz.booking.service.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {

    private  final RouteRepository routeRepository;
    private  final AirportRepository airportRepository;
    private static ModelMapper modelMapper = new ModelMapper();

    @Override
    @Transactional
    public RouteDto save(RouteDto routeDto) {
        Optional<Airport> arrivalAirport = airportRepository.findById(routeDto.getArrivalAirportId());
        Optional<Airport> departureAirport = airportRepository.findById(routeDto.getDepartureAirportId());

        Route route = modelMapper.map(routeDto, Route.class);
        if(arrivalAirport.isPresent() && departureAirport.isPresent()){
            route.setArrivalAirport(arrivalAirport.get());
            route.setDepartureAirport(departureAirport.get());
        }
        route= routeRepository.save(route);
        routeDto.setId(route.getId());
        return routeDto;
    }

    @Override
    public List<RouteDto> saveAll(List<RouteDto> routeDtoList) {
        return null;
    }

    @Override
    public void delete(Long id) {
        routeRepository.deleteById(id);
    }

    @Override
    public List<RouteDto> getAll() {
        List<Route> airlineRouteList = routeRepository.findAll();
        List<RouteDto> airlineRouteDtos = new ArrayList<>();
        if (airlineRouteList!=null && airlineRouteList.size()>0){
            airlineRouteDtos = Util.mapAll(airlineRouteList,RouteDto.class);
        }
        return airlineRouteDtos;
    }

    @Override
    public List<RouteDto> findByName(Optional<String> name) {
        List<Route> airlineRouteList = routeRepository.findByName(name.orElse("_"));
        List<RouteDto> airlineRouteDtos = Util.mapAll(airlineRouteList,RouteDto.class);
        return airlineRouteDtos;
    }

    @Override
    public List<RouteDto> findByCode(Optional<String> code) {
        List<Route> airlineRouteList = routeRepository.findByCode(code.get());
        List<RouteDto> airlineRouteDtos = Util.mapAll(airlineRouteList,RouteDto.class);
        return airlineRouteDtos;
    }

    @Override
    public RouteDto findById(Long id) {
        Route airlineRoute = routeRepository.findById(id).orElse(null);
        RouteDto airlineRouteDto = null;
        if (airlineRoute !=null){
            airlineRouteDto = modelMapper.map(airlineRoute,RouteDto.class);
        }
        return airlineRouteDto;
    }
}
