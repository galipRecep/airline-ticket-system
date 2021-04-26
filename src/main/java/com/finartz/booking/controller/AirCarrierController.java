package com.finartz.booking.controller;


import com.finartz.booking.dto.AirCarrierDto;
import com.finartz.booking.model.AirCarrier;
import com.finartz.booking.service.imp.AirCarrierServiceImpl;
import com.finartz.booking.service.service.AirCarrierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/airCarrier")
public class AirCarrierController {

    private final AirCarrierServiceImpl airCarrierService;

    @PostMapping
    public ResponseEntity<AirCarrierDto> save (@RequestBody AirCarrierDto airCarrierDto){
        Assert.notNull(airCarrierDto.getName(), "Name mustn't be null");
        return ResponseEntity.ok(airCarrierService.save(airCarrierDto));
    }

    @GetMapping
    public ResponseEntity<List<AirCarrierDto>> getAll(){
        return ResponseEntity.ok(airCarrierService.getAll());
    }

    @RequestMapping(value = "/findId",method = RequestMethod.GET)
    public ResponseEntity<AirCarrierDto> findById(@RequestParam Long id) {
        AirCarrierDto result = airCarrierService.findById(id);
        if (result !=null){
            return ResponseEntity.ok(result);
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping(value = "/findName")
    public ResponseEntity<List<AirCarrierDto>> findByName(@RequestParam Optional<String> name) {
        List<AirCarrierDto> resultList = airCarrierService.findByName(name);
        return ResponseEntity.ok(resultList);
    }
}
