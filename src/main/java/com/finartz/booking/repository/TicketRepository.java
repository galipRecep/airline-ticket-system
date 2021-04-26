package com.finartz.booking.repository;

import com.finartz.booking.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    @Query("select s from Ticket s where ticketNumber = ?1")
    Ticket findByTicketNumber(String ticketNumber);

    @Query("delete  from Ticket k where ticketNumber = ?1")
    void deleteByTicketNumber(String ticketNumber);
}
