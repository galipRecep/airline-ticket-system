package com.finartz.booking.service.imp;

import com.finartz.booking.dto.AirportDto;
import com.finartz.booking.model.Airport;
import com.finartz.booking.repository.AirportRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AirportServiceImplTest {

    @InjectMocks
    private AirportServiceImpl airportService;

    @Mock
    private  AirportRepository airportRepository;

    @Mock
    private static ModelMapper modelMapper ;

    @Test
    void save() {
        AirportDto airportDto = new AirportDto();
        airportDto.setName("EsenBoğa Hava Limanı");
        airportDto.setCity("Ankara");
        airportDto.setCountry("TR");

        Airport airportMock= Mockito.mock(Airport.class);

        Mockito.when(airportMock.getId()).thenReturn(3L);
        Mockito.when(airportRepository.save(ArgumentMatchers.any(Airport.class))).thenReturn(airportMock);

        AirportDto result = airportService.save(airportDto);

        assertEquals(result.getName(),airportDto.getName());
    }

    @Test
    void getAll() {
        Airport airport = new Airport();
        airport.setCity("İstanbul");
        airport.setCountry("TR");
        airport.setCode("İST001");
        airport.setName("İstanbul Yeni Hava Limanı");
        List<Airport> airports = new ArrayList<>();
        airports.add(airport);
        Mockito.when(airportRepository.findAll()).thenReturn(airports);
        List<AirportDto> airportDtos= airportService.getAll();
        assertEquals(airportDtos.get(0).getName(),airport.getName());
    }


    @Test
    void findByName() {
        Airport airport = new Airport();
        airport.setCity("İstanbul");
        airport.setCountry("TR");
        airport.setCode("İST001");
        airport.setName("İstanbul Yeni Hava Limanı");
        List<Airport> airports = new ArrayList<>();
        airports.add(airport);
        Mockito.when(airportRepository.findByName("İstanbul Yeni Hava Limanı")).thenReturn(airports);
        List<AirportDto> airportDtos= airportService.findByName(airport.getName());
        assertEquals(airportDtos.get(0).getName(),airport.getName());
    }

    @Test
    void findById() {
        Airport airport = new Airport();
        airport.setCity("İstanbul");
        airport.setCountry("TR");
        airport.setCode("İST001");
        airport.setName("İstanbul Yeni Hava Limanı");

        Mockito.when(airportRepository.findById(1L)).thenReturn(java.util.Optional.of(airport));
        AirportDto airportDto= airportService.findById(1L);
        assertEquals(airportDto.getName(),airport.getName());
    }
}