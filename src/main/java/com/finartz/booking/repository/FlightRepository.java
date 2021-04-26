package com.finartz.booking.repository;

import com.finartz.booking.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,Long> {

    @Query("select s from Flight s where lower(s.name) like lower(concat('%', ?1,'%'))")
    List<Flight> findByName(String name);

    @Query("select s from Flight s where lower(s.code) like lower(concat('%', ?1,'%'))")
    List<Flight> findByCode(String code);

}
