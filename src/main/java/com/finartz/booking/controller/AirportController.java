package com.finartz.booking.controller;


import com.finartz.booking.dto.AirportDto;
import com.finartz.booking.service.imp.AirportServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
@RequiredArgsConstructor
public class AirportController {


    private final AirportServiceImpl airportService;


    @PostMapping()
    public ResponseEntity<AirportDto> save( @RequestBody AirportDto airportDto){
        Assert.notNull(airportDto.getName(), "Name mustn't be null");
        return ResponseEntity.ok(airportService.save(airportDto));
    }

    @GetMapping()
    public ResponseEntity<List<AirportDto>> getAll(){
        return ResponseEntity.ok(airportService.getAll());
    }

    @GetMapping(value ="/findName")
    public ResponseEntity<List<AirportDto>> findByName(@RequestParam String name) {
        List<AirportDto> resultList = airportService.findByName(name);
        return ResponseEntity.ok(resultList);
    }


    @GetMapping("/findId")
    public ResponseEntity<AirportDto> findById(@RequestParam Long id) {
        AirportDto result = airportService.findById(id);
        if (result !=null){
            return ResponseEntity.ok(result);
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }



}
