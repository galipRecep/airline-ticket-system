package com.finartz.booking.controller;


import com.finartz.booking.dto.FlightDto;
import com.finartz.booking.service.imp.FlightServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/flight")
public class FlightController {

    private final FlightServiceImpl flightService;

    @PostMapping
    public ResponseEntity<FlightDto> save(@RequestBody FlightDto flightDto){
        Assert.notNull(flightDto.getName(), "Name mustn't be null");
        Assert.notNull(flightDto.getCode(), "Code mustn't be null");
        return ResponseEntity.ok(flightService.save(flightDto));
    }

    @GetMapping
    public ResponseEntity<List<FlightDto>> getAll(){
        return ResponseEntity.ok(flightService.getAll());
    }

    @GetMapping(value = "/findName")
    public ResponseEntity<List<FlightDto>> findByName(@RequestParam Optional<String> name) {
        List<FlightDto> resultList = flightService.findByName(name);
        return ResponseEntity.ok(resultList);
    }

    @GetMapping(value = "/findCode")
    public ResponseEntity<List<FlightDto>> findByCode(@RequestParam Optional<String> code) {
        List<FlightDto> resultList = flightService.findByCode(code);
        return ResponseEntity.ok(resultList);
    }

    @GetMapping(value = "/findId")
    public ResponseEntity<FlightDto> findById(@RequestParam Long id) {
        FlightDto result = flightService.findById(id);
        if (result !=null){
            return ResponseEntity.ok(result);
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
