package com.finartz.booking.controller;

import com.finartz.booking.dto.RouteDto;
import com.finartz.booking.service.imp.RouteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/routes")
@RequiredArgsConstructor
public class RouteController {

    private final RouteServiceImpl routeService;

    @PostMapping
    public ResponseEntity<RouteDto> save(@RequestBody RouteDto routeDto){
        Assert.notNull(routeDto.getName(), "Name mustn't be null");
        Assert.notNull(routeDto.getCode(), "Code mustn't be null");
        return ResponseEntity.ok(routeService.save(routeDto));
    }

    @GetMapping
    public ResponseEntity<List<RouteDto>> getAll(){
        return ResponseEntity.ok(routeService.getAll());
    }

    @GetMapping(value = "/findName")
    public ResponseEntity<List<RouteDto>> findByName(@RequestParam Optional<String> name) {
        List<RouteDto> resultList = routeService.findByName(name);
        return ResponseEntity.ok(resultList);
    }

    @GetMapping(value = "/findCode")
    public ResponseEntity<List<RouteDto>> findByCode(@RequestParam Optional<String> code) {
        List<RouteDto> resultList = routeService.findByCode(code);
        return ResponseEntity.ok(resultList);
    }


    @GetMapping("/findId")
    public ResponseEntity<RouteDto> findById(@RequestParam Long id) {
        RouteDto result = routeService.findById(id);
        if (result !=null){
            return ResponseEntity.ok(result);
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


}
