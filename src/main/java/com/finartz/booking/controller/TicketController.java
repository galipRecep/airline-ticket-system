package com.finartz.booking.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.finartz.booking.dto.TicketDto;
import com.finartz.booking.service.imp.TicketServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketServiceImpl ticketService;
    @PostMapping
    public ResponseEntity<TicketDto> save(@RequestBody TicketDto ticketDto){
        return ResponseEntity.ok(ticketService.save(ticketDto));
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestBody String ticketNumber) throws JsonProcessingException {
        return ResponseEntity.ok(ticketService.delete(ticketNumber));
    }

    @GetMapping
    public ResponseEntity<List<TicketDto>> getAll(){
        return ResponseEntity.ok(ticketService.getAll());
    }

    @GetMapping("/findTicketNumber")
    public ResponseEntity<TicketDto> findByTicketNumber(@RequestParam Optional<String> ticketNumber) {
        TicketDto resultList = ticketService.findByTicketNumber(ticketNumber);
        return ResponseEntity.ok(resultList);
    }

    @GetMapping("/findId")
    public ResponseEntity<TicketDto> findById(@RequestParam Long id) {
        TicketDto result = ticketService.findById(id);
        if (result !=null){
            return ResponseEntity.ok(result);
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
