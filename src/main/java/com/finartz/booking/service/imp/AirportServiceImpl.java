package com.finartz.booking.service.imp;




import com.finartz.booking.Util.Util;
import com.finartz.booking.dto.AirportDto;

import com.finartz.booking.model.Airport;

import com.finartz.booking.repository.AirportRepository;

import com.finartz.booking.service.service.AirportService;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;



@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {

    private  final AirportRepository airportRepository;
    private static ModelMapper modelMapper = new ModelMapper();

    @Override
    @Transactional
    public AirportDto save(AirportDto airportDto) {
        Airport airport = modelMapper.map(airportDto,Airport.class);
        airport= airportRepository.save(airport);
        airportDto.setId(airport.getId());
        return airportDto;
    }

    @Override
    public void delete(Long id) {
        airportRepository.deleteById(id);
    }


    @Override
    public List<AirportDto> getAll() {
        List<Airport> airportList = airportRepository.findAll();
        List<AirportDto> airportDtoList = new ArrayList<>();
        if (airportList!=null && airportList.size()>0){
            airportDtoList = Util.mapAll(airportList,AirportDto.class);
        }
        return airportDtoList;
    }


    @Override
    public List<AirportDto> findByName(String name) {
        List<Airport> airportList = airportRepository.findByName(name);
        List<AirportDto> airportDtoList = Util.mapAll(airportList,AirportDto.class);
        return airportDtoList;
    }


    @Override
    public AirportDto findById(Long id) {
        Airport airport = airportRepository.findById(id).orElse(null);
        AirportDto airportDto = null;
        if (airport !=null){
            airportDto = modelMapper.map(airport,AirportDto.class);
        }
        return airportDto;
    }
}
