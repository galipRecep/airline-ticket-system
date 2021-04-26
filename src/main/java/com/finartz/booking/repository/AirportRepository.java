package com.finartz.booking.repository;

import com.finartz.booking.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AirportRepository  extends JpaRepository<Airport,Long> {

    @Query("select s from Airport s where lower(s.name) like lower(concat('%', ?1,'%'))")
    List<Airport> findByName(String name);


}
